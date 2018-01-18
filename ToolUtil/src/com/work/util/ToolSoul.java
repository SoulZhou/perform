package com.work.util;

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.work.print.JPrintBug;
import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.app.DownloadManager.Query;
import android.content.Context;
import android.database.Cursor;

public class ToolSoul {
	private static ToolSoul me = new ToolSoul();
	private ToolSoul(){};
	
	public static ToolSoul getInstance(){
		return me;
	}
	
    //��Ҫд��ȡ�������ϵ�MCU�汾
    //�������ϵ�allapp�汾��os�汾 can�а汾
  //��ȡ��ǰ�����ں�����
    public  String getTimeAndWeek(){
    	StringBuffer sb = new StringBuffer();
    	Calendar c = Calendar.getInstance();  
    	int year = c.get(Calendar.YEAR);
    	sb.append(year);
    	int month = c.get(Calendar.MONTH);
    	sb.append(month);
    	int day = c.get(Calendar.DAY_OF_MONTH);
    	sb.append(day);
    	sb.append("_");
    	int week = c.get(Calendar.DAY_OF_WEEK);
    	sb.append(week);
		return sb.toString();
    }
    
    //����2��ʱ��֮����������
    public double getXiangchaDay(String day1,String day2){
    	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    	Date date1 = null;
    	Date date2 = null;
    	try {
    		date1 = simpleDateFormat.parse(day1);
    		date2 = simpleDateFormat.parse(day2);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	GregorianCalendar calendar1 = new GregorianCalendar();
    	GregorianCalendar calendar2 = new GregorianCalendar();
    	calendar1.setTime(date1);
    	calendar2.setTime(date2);
    	double dayCount = (calendar2.getTimeInMillis()-calendar1.getTimeInMillis())/(1000*3600*24);
    	return dayCount;
    }
    
    
    //��ȡ����
    public String getDay(){
    	StringBuffer sb = new StringBuffer();
    	Calendar c = Calendar.getInstance();  
    	int year = c.get(Calendar.YEAR);
    	sb.append(year);
    	int month = c.get(Calendar.MONTH)+1;
    	if(month<10){
    		sb.append("0"+month);
    	}else{
    		sb.append(month);
    	}
    	int day = c.get(Calendar.DAY_OF_MONTH);
    	if(day<10){
    		sb.append("0"+day);
    	}else{
    		sb.append(day);
    	}
		return sb.toString();
    }
    //��ȡ����
    public int getWeek(){
    	Calendar c = Calendar.getInstance();  
    	int week = c.get(Calendar.DAY_OF_WEEK);
		return week;
    }
    
    /**
     * ��Ĭ��װ
     */
    public boolean clientInstall(String apkPath){
        PrintWriter PrintWriter = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            PrintWriter = new PrintWriter(process.getOutputStream());
            PrintWriter.println("chmod 777 "+apkPath);
            PrintWriter.println("export LD_LIBRARY_PATH=/vendor/lib:/system/lib");
            PrintWriter.println("pm install -r "+apkPath);
//          PrintWriter.println("exit");
            PrintWriter.flush();
            PrintWriter.close();
            int value = process.waitFor();  
            return returnResult(value);
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(process!=null){
                process.destroy();
            }
        }
        return false;
    }
     
    /**
     * ��Ĭж��
     */
    public boolean clientUninstall(String packageName){
        PrintWriter PrintWriter = null;
        Process process = null;
        try {
            process = Runtime.getRuntime().exec("su");
            PrintWriter = new PrintWriter(process.getOutputStream());
            PrintWriter.println("LD_LIBRARY_PATH=/vendor/lib:/system/lib ");
            PrintWriter.println("pm uninstall "+packageName);
            PrintWriter.flush();
            PrintWriter.close();
            int value = process.waitFor();  
            return returnResult(value); 
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(process!=null){
                process.destroy();
            }
        }
        return false;
    }
    
    private  boolean returnResult(int value){
        // ����ɹ�  
        if (value == 0) {
            return true;
        } else if (value == 1) { // ʧ��
            return false;
        } else { // δ֪���
            return false;
        }  
    }
    
    @SuppressLint("NewApi")
	private void getDownloadPaused(Context context,DownloadManager downloadManager) {
    	  
    	// Create a query for paused downloads.  
    	Query pausedDownloadQuery = new Query();  
    	pausedDownloadQuery.setFilterByStatus(DownloadManager.STATUS_PAUSED);  
    	  
    	// Query the Download Manager for paused downloads.  
    	Cursor pausedDownloads = downloadManager.query(pausedDownloadQuery);  
    	  
    	// Find the column indexes for the data we require.  
    	int reasonIdx = pausedDownloads.getColumnIndex(DownloadManager.COLUMN_REASON);  
    	int titleIdx = pausedDownloads.getColumnIndex(DownloadManager.COLUMN_TITLE);  
    	int fileSizeIdx =   
    	  pausedDownloads.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES);      
    	int bytesDLIdx =   
    	  pausedDownloads.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);  
    	  
    	// Iterate over the result Cursor.  
    	while (pausedDownloads.moveToNext()) {  
    	  // Extract the data we require from the Cursor.  
    	  String title = pausedDownloads.getString(titleIdx);  
    	  int fileSize = pausedDownloads.getInt(fileSizeIdx);  
    	  int bytesDL = pausedDownloads.getInt(bytesDLIdx);  
    	  
    	  // Translate the pause reason to friendly text.  
    	  int reason = pausedDownloads.getInt(reasonIdx);  
    	  String reasonString = "Unknown";  
    	  switch (reason) {  
    	    case DownloadManager.PAUSED_QUEUED_FOR_WIFI :   
    	      reasonString = "Waiting for WiFi"; break;  
    	    case DownloadManager.PAUSED_WAITING_FOR_NETWORK :   
    	      reasonString = "Waiting for connectivity"; break;  
    	    case DownloadManager.PAUSED_WAITING_TO_RETRY :  
    	      reasonString = "Waiting to retry"; break;  
    	    default : break;  
    	  }  
    	  
    	  // Construct a status summary  
    	  StringBuilder sb = new StringBuilder();  
    	  sb.append(title).append("\n");  
    	  sb.append(reasonString).append("\n");  
    	  sb.append("Downloaded ").append(bytesDL).append(" / " ).append(fileSize);  
    	  
    	  // Display the status   
    	  JPrintBug.getPrint().d("sb.toString() = "+sb.toString());
//    	  Log.d("DOWNLOAD", sb.toString());  
    	}  
    	  
    	// Close the result Cursor.  
    	pausedDownloads.close();
    }
    
    
}
