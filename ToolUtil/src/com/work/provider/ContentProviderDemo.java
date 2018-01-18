package com.work.provider;

/**
 * �������Ҫдһ�����ݹ����Demo �����Ժ������˿�������ѯ֮���
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
     * ��һ���ص���������ContentProvider������ʱ�򣬾ͻ�����,�ڶ�������Ϊָ�����ݿ����ƣ������ָ�����ͻ��Ҳ������ݿ⣻
     * ������ݿ���ڵ�������ǲ����ٴ���һ�����ݿ�ġ�
     * ����Ȼ�״ε��� ������Ҳ�����������ݿ�������SQLiteDatabase�� getWritableDatabase,getReadableDatabase���������е�һ���Żᴴ�����ݿ⣩
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
