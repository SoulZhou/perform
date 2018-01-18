package com.work.provider;

/**
 * 这里的是要写一个数据共享的Demo 方便以后忘记了可以来查询之类的
 */
import com.work.print.JPrintBug;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class ContentProviderDemo extends ContentProvider {

	public static final String TAG = ContentProviderDemo.class.getSimpleName();
	
	DBOpenHelp dbOpenHelp = null;
	
	/**
     * 是一个回调函数，在ContentProvider创建的时候，就会运行,第二个参数为指定数据库名称，如果不指定，就会找不到数据库；
     * 如果数据库存在的情况下是不会再创建一个数据库的。
     * （当然首次调用 在这里也不会生成数据库必须调用SQLiteDatabase的 getWritableDatabase,getReadableDatabase两个方法中的一个才会创建数据库）
     */
	@Override
	public boolean onCreate() {
		if(JPrintBug.getPrint()== null){
			JPrintBug.initPrint(getContext());
		}
		JPrintBug.getPrint().d(TAG, "onCreate()");
		
		dbOpenHelp = new DBOpenHelp(getContext());
		return true;
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		SQLiteDatabase sd = dbOpenHelp.getReadableDatabase();
		Cursor cursor = sd.query(ContentData.TableData.TABLE_NAME, null, selection, selectionArgs, null, null, sortOrder);
		return cursor;
	}

	@Override
	public String getType(Uri uri) {
		return null;
	}

	@Override
	public Uri insert(Uri uri, ContentValues values) {
		SQLiteDatabase db = dbOpenHelp.getWritableDatabase();
		long rowid = db.insert(ContentData.TableData.TABLE_NAME, null, values);
		if(rowid>0){
			Uri inserturi = Uri.withAppendedPath(uri, ""+rowid);
			getContext().getContentResolver().notifyChange(inserturi, null);
			return inserturi;
		}
		return null;
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		SQLiteDatabase db = dbOpenHelp.getWritableDatabase();
		int id = db.delete(ContentData.TableData.TABLE_NAME, selection, selectionArgs);
		if(id>0){
			Uri deleteUri = Uri.withAppendedPath(uri, ""+id);
			getContext().getContentResolver().notifyChange(deleteUri, null);
		}
		return id;
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,String[] selectionArgs) {
		SQLiteDatabase db = dbOpenHelp.getWritableDatabase();
		int id = db.update(ContentData.TableData.TABLE_NAME, values, selection, selectionArgs);
		return id;
	}

}
