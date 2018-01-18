package com.syu.wheel;

import android.annotation.SuppressLint;

@SuppressLint("DefaultLocale")
public class NumericWheelAdapter implements WheelAdapter {

	 /** The default min value */  
    public static final int DEFAULT_MAX_VALUE = 9;  
  
    /** The default max value */  
    @SuppressWarnings("unused")
	private static final int DEFAULT_MIN_VALUE = 0;  
      
    // Values  
    /*private int minValue;  
    private int maxValue; */ 
      
    //int[] values
    private int[] mValues;
    
    // format  
    private String format;  
      
    /** 
     * Default constructor 
     */  
    /*public NumericWheelAdapter() {  
        this(DEFAULT_MIN_VALUE, DEFAULT_MAX_VALUE);  
    }  */
  
    /** 
     * Constructor 
     * @param minValue the wheel min value 
     * @param maxValue the wheel max value 
     */  
    /*public NumericWheelAdapter(int minValue, int maxValue) {  
        this(minValue, maxValue, null);  
    } */ 
  
    /**
     * 	如果传入的不是连续的数字呢，这个时候需要传入数组了
     * 并且不是按大小，而是按数组的顺序而已
     */
    
    public NumericWheelAdapter(int[] values) {  
        this.mValues = values;
    }  
    
    public NumericWheelAdapter(int[] values,String format) {  
        this.mValues = values;
        this.format = format;
    }  
    
    
    /** 
     * Constructor 
     * @param minValue the wheel min value 
     * @param maxValue the wheel max value 
     * @param format the format string 
     */  
   /* public NumericWheelAdapter(int minValue, int maxValue, String format) {  
        this.minValue = minValue;  
        this.maxValue = maxValue;  
        this.format = format;  
    }  */
    
  
    @Override  
    public String getItem(int index) {  
        if (index >= 0 && index < getItemsCount()) {  
            int value = mValues[index];  
            if(format != null){
            	return String.format("%.01f", value/100f);
            }
//            return format != null ? String.format(format, value) : Integer.toString(value);
            return ""+value;
        }  
        return null;  
    }  
  
    @Override  
    public int getItemsCount() {  
//        return maxValue - minValue + 1;
    	return mValues.length;
    }  
      
    @Override  
    public int getMaximumLength() {  
        /*int max = Math.max(Math.abs(maxValue), Math.abs(minValue));  
        int maxLen = Integer.toString(max).length();  
        if (minValue < 0) {  
            maxLen++;  
        }  
        return maxLen;  */
    	return mValues.length;
    }  

}
