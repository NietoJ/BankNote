package com.example.banknote.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBManager extends SQLiteOpenHelper {
	public static final String TABLE_CREDENTIALS = "credentials";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_CREDENTIALS = "credential";

	private static final String DATABASE_NAME = "credentials.db";
	private static final int DATABASE_VERSION = 1;

	// SQL statement for database creation
	private static final String DATABASE_CREATE = "create table "
			+ TABLE_CREDENTIALS + "(" + COLUMN_ID
			+ " integer primary key autoincrement, " + COLUMN_CREDENTIALS
			+ " text not null);";

	public DBManager(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(DBManager.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_CREDENTIALS);
		onCreate(db);
	}

}