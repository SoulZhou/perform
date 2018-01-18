/**
 * 版权：深圳深青联科技有限公司
 * 设计:	 柯华栋
 * 代码：柯华栋 严兴林 廖丰
 * 日期：2013年7月1日
 */

package com.work.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;


public class JumpPage {
	
	private static void defIntentSetForStartActivity(Intent intent)	{
		intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	}
	
	public static void go2Activity(String packageName, String ActvityName,Context context){
		ComponentName componetName = new ComponentName(packageName,ActvityName);
		try {  
			Intent intent = new Intent();  
			intent.setComponent(componetName);  
			defIntentSetForStartActivity(intent);
			context.startActivity(intent);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public static void go2Activity(String intentAction,Context context){
		try {  
			Intent intent = new Intent(intentAction);  
			defIntentSetForStartActivity(intent);
			context.startActivity(intent);  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean go2YiKa(Context context){
		try {
			Intent intent= new Intent();
			ComponentName componentName = new ComponentName("com.coagent.app", "com.coagent.activity.MainActivity");
			intent.setComponent(componentName);
			intent.setAction("android.intent.action.view");
			intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
			intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(intent);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
