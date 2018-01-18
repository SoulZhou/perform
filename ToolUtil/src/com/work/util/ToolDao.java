package com.work.util;

import java.io.File;
import java.util.List;

import com.work.print.JPrintBug;

import android.R.integer;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.view.View;

public class ToolDao {

	
	/**
     * �����жϷ����Ƿ�����.
     * @param context
     * @param className �жϵķ�������
     * @return true ������ false ��������
     */
    public static boolean isServiceRunning(Context mContext,String className) {
//        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager)mContext.getSystemService(Context.ACTIVITY_SERVICE); 
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(Integer.MAX_VALUE);
       if (serviceList == null || serviceList.size()<=0) {
            return false;
        }
       for (RunningServiceInfo runningServiceInfo : serviceList) {
    	   if (className.equals(runningServiceInfo.service.getClassName())) {
               return true;
           }
       }
       return false;
    }
        
	//ͨ��apk��ȡapk�����ֺ��ļ��� ����System/appĿ¼�µ�����apk
	public static void binarySystemApp(String path,Context context){
//		String path = "/system/app";
		final String systempath = path;
		PackageManager pm = context.getPackageManager();
		File file = new File(systempath);
		if(file.exists()){
			File[] file2 = file.listFiles();
			for (int i = 0; i < file2.length; i++) {
				if(file2[i].isFile()){
					String str = getMIMEType(file2[i]);
					if(!TextUtils.isEmpty(str)&&str.equals("apk")){
						String str2 = file2[i].getPath();
						PackageInfo info = pm.getPackageArchiveInfo(str2, PackageManager.GET_ACTIVITIES);    
						if(info != null){    
							ApplicationInfo appInfo = info.applicationInfo;    
							String packageName = appInfo.packageName;  //�õ���װ������  
//							App.me().listpackageName.add(packageName);
						}
					}
				}else if(file2[i].isDirectory()){
					binarySystemApp(file2[i].getAbsolutePath(),context);
				}
			}
		}
	}
	
	private static String getMIMEType(File f)		// ��ȡMIME Type����  
    {
    	String type = "" ;
    	String filename = f.getName();
    	String end = getPointString(filename);
    	if(end.equalsIgnoreCase("apk"))
    	{  
    		type="apk";  
    	}
    	return type;  
    }
	 
	private static String getPointString(String name)	//�õ�ÿ���ļ����͵ĸ�ʽ
	{
		int position =0;
		for(int i=0;i<name.length();i++)
		{
			char b = name.charAt(i);
			if(b == '.')
			{
				position = i;
			}
		}
		String end = name.substring(position+1);
		return end;
	}

	/**
	 * ��ȡ���ϲ��apk�İ���
	 */
	public static String getTopPkgName(Context context) {
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<RunningTaskInfo> tasklists = am.getRunningTasks(1);
		String name = tasklists.get(0).topActivity.getPackageName();
		if(name != null && !name.isEmpty()){
			return name;
		}
		return "";
	}
	
	
	public static void appEnable(String packageName, int enable,Context context) {
		PackageManager pm = context.getPackageManager();
		int state = enable == 0 ? PackageManager.COMPONENT_ENABLED_STATE_DISABLED : PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
		try {
			if (state != pm.getApplicationEnabledSetting(packageName)){
				pm.setApplicationEnabledSetting(packageName, state,	PackageManager.DONT_KILL_APP);
			}
		} catch (Exception e) {}
	}
	
	
    //����Ƿ�����������3g�źţ����Է�������
    public static boolean go2CheckNet(Context context){
        // ��ȡ�ֻ��������ӹ�����󣨰�����wi-fi,net�����ӵĹ���
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null){
            return false;
        }else{
            // ��ȡNetworkInfo����
            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            if (networkInfo != null && networkInfo.length > 0){
                for (int i = 0; i < networkInfo.length; i++){
                    // �жϵ�ǰ����״̬�Ƿ�Ϊ����״̬
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED){
                        return true;
                    }
                }
            }
        }
    	return false;
    }
    
	public static boolean isAppInstalled(String pkgName,Context context) {
		PackageManager pm = context.getPackageManager();
		boolean installed =false;
		try {
			pm.getPackageInfo(pkgName,PackageManager.GET_ACTIVITIES);
			installed = true;
		} catch(PackageManager.NameNotFoundException e) {
			installed =false;
		}
		return installed;
	}
	
	public static boolean isContains(List<Integer> lists,int uid){
		if(lists!=null&&lists.size()>0){
			for (Integer integer : lists) {
				if(integer == uid){
					return true;
				}
			}
		}
		return false;
	}
	
	public static void showVisible(View view){
		if(view!=null && view.getVisibility()!=View.VISIBLE){
			view.setVisibility(View.VISIBLE);
		}
	}
	public static void showGone(View view){
		if(view!=null && view.getVisibility()!=View.GONE){
			view.setVisibility(View.GONE);
		}
	}
}
