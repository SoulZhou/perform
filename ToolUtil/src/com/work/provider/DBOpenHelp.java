package com.work.provider;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelp extends SQLiteOpenHelper {

	public DBOpenHelp(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	public DBOpenHelp(Context context, String name, int version) {
        this(context, name, null, version);
    }
	
	public DBOpenHelp(Context context) {
        this(context, ContentData.DATABASE_NAME, null, ContentData.DATABASE_VERSION);
    }
	
	/**
     * 只有当数据库执行创建 的时候，才会执行这个方法。
     * 如果更改表名，也不会创建，只有当创建数据库的时候，才会创建改表名之后 的数据表
     */
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table "+ContentData.TableData.TABLE_NAME
				+"("+ContentData.TableData._ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
				+ContentData.TableData.NAME1+" varchar(20),"
				+ContentData.TableData.NAME2+" varchar(20),"
				+ContentData.TableData.NAME3+" varchar(20),"
				+ContentData.TableData.NAME4+" varchar(20),"
				+ContentData.TableData.SEX+" boolean);");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS soultable");
		onCreate(db);
	}

}
