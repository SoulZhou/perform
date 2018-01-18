package com.work.util;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

import android.util.Log;

public class DateUtil {
	
	public static Date now() {
		return new Date();
	}
	
	public static Date parseDate(Object objDate) {
		if (objDate.getClass() == Date.class
				|| objDate.getClass() == Timestamp.class)
			return (java.util.Date) objDate;

		Date date = new Date();
		String strTime = String.valueOf(objDate).trim();
		if (strTime == null || strTime.length() == 0) {
			return date;
		}
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(
					strTime.length() > 10 ? "yyyy-MM-dd HH:mm:ss"
							: (strTime.length() > 8 ?"yyyy-MM-dd":"yyyyMMdd"));
			date = dateFormat.parse(strTime);
		} catch (Exception ex) {
		}
		return date;
	}
	
	public static Boolean isDateStr(String str) {
		Boolean isDate = false;
		String reg = "(?:[0-9]{1,4}(?<!^0?0?0?0))-(?:0?[1-9]|1[0-2])-(?:0?[1-9]|1[0-9]|2[0-8]|(?:(?<=-(?:0?[13578]|1[02])-)(?:29|3[01]))|(?:(?<=-(?:0?[469]|11)-)(?:29|30))|(?:(?<=(?:(?:[0-9]{0,2}(?!0?0)(?:[02468]?(?<![13579])[048]|[13579][26]))|(?:(?:[02468]?[048]|[13579][26])00))-0?2-)(?:29)))";
		Pattern p = Pattern.compile(reg);
		str=str.length()==8?str.substring(0,4)+"-"+str.substring(4, 6)+"-"+str.substring(6,8):str;
		str = str.replace(".", "-").replace("/", "-").replace(" ", "-");
		isDate = p.matcher(str).matches();
		return isDate;
	}

	
	public static Date addDay(Date date, int amount) {
		return add(date, Calendar.DAY_OF_MONTH, amount);
	}
	
	public static Date addHours(Date date, int amount) {
		return add(date, Calendar.HOUR_OF_DAY, amount);
	}
	public static Date addMinute(Date date, int amount) {
		return add(date, Calendar.MINUTE, amount);
	}
	
	public static Date addSecond(Date date, int amount) {
		return add(date, Calendar.SECOND, amount);
	}
	
	public static Date add(Date date, int type, int amount) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(type, amount);
		return calendar.getTime();
	}
	
	public static String formatDateString(Date timeDate, String format) {
		
		if(timeDate==null)
			return "";
		
		DateFormat df = new SimpleDateFormat(format);
		return df.format(timeDate);
	}	
	
    public static String stampToDate(Timestamp timestamp){
    	if(timestamp == null){
    		return "";
    	}
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date  ts1 = Timestamp.valueOf(timestamp.toString());  
        res = simpleDateFormat.format(ts1);
        return res.split(".").length > 0 ? res.split(".")[0] : res;
    }
	
	
    public static Timestamp str2TimeStamp(String strDate){
    	Timestamp ts = new Timestamp(System.currentTimeMillis()); 
    	if(strDate!=null&& strDate.length()>10){
    		try {   
    			ts = Timestamp.valueOf(strDate);   
    			System.out.println(ts.getTime());
    			return ts;
    		} catch (Exception e) {   
    			e.printStackTrace();   
    		} 
    	}
        return ts;
    }
    
	
    public static String timeStamp2Datestr(String timeStamp){
    	 String tsStr = "";   
         DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
         
    	try {   
    		long lt = new Long(timeStamp);
            tsStr = sdf.format(new Date(lt));
//            tsStr = timeStamp.toString();   
        } catch (Exception e) {   
            e.printStackTrace();   
        } 
        return tsStr;
    }
    
	public static String timeStamp2DateSimaple(Long timeStamp) {
		String tsStr = "";
		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		try {
			tsStr = sdf.format(new Date(timeStamp));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tsStr;
	}
	
    public static Date timestampToDate(Timestamp tt){  
        return new Date(tt.getTime());  
    }  
    
    //获得本月第一天0点时间
 	public static String getTimesMonthmorning() {
 		Calendar cal = Calendar.getInstance();
 		cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY),cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
 		cal.set(Calendar.DAY_OF_MONTH,cal.getActualMinimum(Calendar.DAY_OF_MONTH));
 		return timeStamp2DateSimaple(cal.getTimeInMillis());
 	}
 	
 	public static String getTodayCanlendar(){
 		return timeStamp2DateSimaple(System.currentTimeMillis());
 	}
    
}