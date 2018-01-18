package com.work.provider;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * �ṩһЩ���� �����
 * �ṩContentProvider����ĸ��ֳ��������ⲿ������Ҫ���ʵ�ʱ�򣬾Ϳ��Բο���Щ����
 * @author Administrator
 */
public class ContentData {
	public static final String AUTHORITY = "com.work.provider";
	public static final String DATABASE_NAME ="soul.db";
	public static final int DATABASE_VERSION = 4;
	
//	public static String uri = "content://com.work.provider.ContentProviderDemo";
	
	public static final class TableData implements BaseColumns{
		//����һЩ������
		public static final String TABLE_NAME = "soultable";
		public static final String NAME1 = "info1";
		public static final String NAME2 = "info2";
		public static final String NAME3 = "info3";
		public static final String NAME4 = "info4";
		public static final String SEX = "SEX";
		//Uri���ⲿ������Ҫ���ʾ���ͨ�����Uri���ʵģ����Uri�����Ψһ�ġ�
		public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/"+TABLE_NAME);
		 // ���ݼ���MIME�����ַ�����Ӧ����vnd.android.cursor.dir/��ͷ  
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/hb.android.teachers";
        // ��һ���ݵ�MIME�����ַ���Ӧ����vnd.android.cursor.item/��ͷ  
        public static final String CONTENT_TYPE_ITME = "vnd.android.cursor.item/hb.android.teacher";
        /* �Զ���ƥ���� */ 
        public static final int TABLES = 1;  
        /* �Զ���ƥ���� */ 
        public static final int TABLE = 2;
        
        public static final UriMatcher uriMatcher;
        
        static {  
            // ����UriMatcher.NO_MATCH��ʾ��ƥ���κ�·���ķ�����  
            uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);  
            // ���match()����ƥ��content://hb.android.teacherProvider/teachern·��,����ƥ����ΪTEACHERS  
            uriMatcher.addURI(ContentData.AUTHORITY, "soultable", TABLES);  
            // ���match()����ƥ��content://hb.android.teacherProvider/teacher/230,·��������ƥ����ΪTEACHER  
            uriMatcher.addURI(ContentData.AUTHORITY, "soultable/#", TABLE);  
        }
	}
}
