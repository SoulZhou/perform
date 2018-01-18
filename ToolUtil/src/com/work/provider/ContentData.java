package com.work.provider;

import android.content.UriMatcher;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * 提供一些常量 对外的
 * 提供ContentProvider对外的各种常量，当外部数据需要访问的时候，就可以参考这些常量
 * @author Administrator
 */
public class ContentData {
	public static final String AUTHORITY = "com.work.provider";
	public static final String DATABASE_NAME ="soul.db";
	public static final int DATABASE_VERSION = 4;
	
//	public static String uri = "content://com.work.provider.ContentProviderDemo";
	
	public static final class TableData implements BaseColumns{
		//定义一些属性名
		public static final String TABLE_NAME = "soultable";
		public static final String NAME1 = "info1";
		public static final String NAME2 = "info2";
		public static final String NAME3 = "info3";
		public static final String NAME4 = "info4";
		public static final String SEX = "SEX";
		//Uri，外部程序需要访问就是通过这个Uri访问的，这个Uri必须的唯一的。
		public static final Uri CONTENT_URI = Uri.parse("content://"+AUTHORITY+"/"+TABLE_NAME);
		 // 数据集的MIME类型字符串则应该以vnd.android.cursor.dir/开头  
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/hb.android.teachers";
        // 单一数据的MIME类型字符串应该以vnd.android.cursor.item/开头  
        public static final String CONTENT_TYPE_ITME = "vnd.android.cursor.item/hb.android.teacher";
        /* 自定义匹配码 */ 
        public static final int TABLES = 1;  
        /* 自定义匹配码 */ 
        public static final int TABLE = 2;
        
        public static final UriMatcher uriMatcher;
        
        static {  
            // 常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码  
            uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);  
            // 如果match()方法匹配content://hb.android.teacherProvider/teachern路径,返回匹配码为TEACHERS  
            uriMatcher.addURI(ContentData.AUTHORITY, "soultable", TABLES);  
            // 如果match()方法匹配content://hb.android.teacherProvider/teacher/230,路径，返回匹配码为TEACHER  
            uriMatcher.addURI(ContentData.AUTHORITY, "soultable/#", TABLE);  
        }
	}
}
