package com.example.banknote.model;

import android.content.Context;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.AndroidSupport;
import com.db4o.config.EmbeddedConfiguration;




public class DBSingle
{
	
	private static ObjectContainer oc = null;

	
	private DBSingle(){}
	
	private static class Holder
	{
		private static final DBSingle INSTANCE = new DBSingle();
	}
	
	public static DBSingle getInstance()
	{
		return Holder.INSTANCE;
	}
	
	public void setDB(Context c)
	{
		String filePath = c.getFilesDir() + "/android.db4o";
        final EmbeddedConfiguration config = configure();
        oc = Db4oEmbedded.openFile(config,filePath);
        oc.close();
	}
	
	public ObjectContainer getDB()
	{
		return oc;
	}
	
	public void closeDB()
	{
		oc.close();
	}
	
	private static EmbeddedConfiguration configure()
	{
		EmbeddedConfiguration config =  Db4oEmbedded.newConfiguration();
		config.common().add(new AndroidSupport());
		
		config.common().objectClass(User.class).objectField("name").indexed(true);
		config.common().objectClass(User.class).cascadeOnUpdate(true);
		config.common().objectClass(User.class).cascadeOnDelete(true);
		config.common().objectClass(Account.class).objectField("fullName").indexed(true);
		config.common().objectClass(Account.class).cascadeOnUpdate(true);
		config.common().objectClass(Account.class).cascadeOnDelete(true);
		
		return config;
	
	}
}
	



