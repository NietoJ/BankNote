package com.example.banknote.model;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserCredentialDataSource {
	private SQLiteDatabase db;
	private DBManager dbHelper;
	private String[] allColumns = { DBManager.COLUMN_CREDENTIALS,
			DBManager.COLUMN_ID };

	public UserCredentialDataSource(Context context) {
		dbHelper = new DBManager(context);
	}

	public void open() throws SQLException {
		db = dbHelper.getWritableDatabase();
	}

	public void close() {
		dbHelper.close();
	}

	public UserCredential createUserCredential(String credentials) {
		ContentValues values = new ContentValues();
		values.put(DBManager.COLUMN_CREDENTIALS, credentials);
		long insertId = db.insert(DBManager.TABLE_CREDENTIALS, null, values);
		Cursor cursor = db.query(DBManager.TABLE_CREDENTIALS, allColumns,
				DBManager.COLUMN_ID + " = " + insertId, null, null, null, null);
		cursor.moveToFirst();

		UserCredential newCredential = cursorToUserCredential(cursor);
		cursor.close();
		return newCredential;
	}

	public List<UserCredential> getAllUserCredentials() {
		List<UserCredential> credentials = new ArrayList<UserCredential>();

		Cursor cursor = db.query(DBManager.TABLE_CREDENTIALS, allColumns, null,
				null, null, null, null);

		cursor.moveToFirst();
		while (!cursor.isAfterLast()) {
			UserCredential UserCredential = cursorToUserCredential(cursor);
			credentials.add(UserCredential);
			cursor.moveToNext();
		}
		// make sure to close the cursor
		cursor.close();
		return credentials;
	}

	private UserCredential cursorToUserCredential(Cursor cursor) {
		UserCredential cred = new UserCredential();
		cred.setId(cursor.getLong(0));
		cred.setCredentials(cursor.getString(0));
		return cred;
	}
}
