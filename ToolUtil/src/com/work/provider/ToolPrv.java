package com.work.provider;

import android.content.Context;
import android.database.Cursor;

public class ToolPrv {

	//根据名称查询数据库
	public static Cursor queryByName(Context context,String info1,String info2,String info3,String info4,String sex){
		String whereSelect = ContentData.TableData.NAME1+"=? and "+
				ContentData.TableData.NAME2+"=? and "+
				ContentData.TableData.NAME3+"=? and "
				+ContentData.TableData.NAME4+"=? and "
				+ContentData.TableData.SEX+"=?";
		String[] selectionArgs = new String[]{info1,info2,info3,info4,sex};
		if(context!= null && context.getContentResolver()!= null){
			Cursor cursor = context.getContentResolver().query(ContentData.TableData.CONTENT_URI, null, whereSelect ,selectionArgs, null);
			if(cursor!= null){
				return cursor;		
			}
		}
		return null;
	}
	
	//删除数据by Name
	public static int deleteByID(Context context,int id){
		String whereSelect = ContentData.TableData._ID+"=?";
		String[] selectionArgs = new String[]{String.valueOf(id)};
		int deleteid  = context.getContentResolver().delete(ContentData.TableData.CONTENT_URI,whereSelect ,selectionArgs);
		return deleteid;
	}
}
