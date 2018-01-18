package com.work.util;

import java.io.ByteArrayOutputStream;
import java.util.Collection;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;

public class ToolAct {

	/**
	 * Bitmap ---> byte[]
	 * @param bm
	 * @return
	 */
	public byte[] Bitmap2Bytes(Bitmap bm) {  
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();  
	    bm.compress(Bitmap.CompressFormat.PNG, 100, baos);  
	    return baos.toByteArray();  
	}  
	
	/**
	 * byte[] ---> Bitmap
	 * @param b
	 * @return
	 */
	public Bitmap Bytes2Bimap(byte[] b) {  
	    if (b.length != 0) {  
	        return BitmapFactory.decodeByteArray(b, 0, b.length);  
	    } else {  
	        return null;  
	    }  
	} 
	
	/**
	 * Bitmap 缩放
	 */
	public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {  
	    int w = bitmap.getWidth();  
	    int h = bitmap.getHeight();  
	    Matrix matrix = new Matrix();  
	    float scaleWidth = ((float) width / w);  
	    float scaleHeight = ((float) height / h);  
	    matrix.postScale(scaleWidth, scaleHeight);  
	    Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);  
	    return newbmp;  
	}  
	
	/**
	 * 将Drawable 转换成Bitmap
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {  
        // 取 drawable 的长宽  
        int w = drawable.getIntrinsicWidth();  
        int h = drawable.getIntrinsicHeight();  
  
        // 取 drawable 的颜色格式  
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888  
                : Bitmap.Config.RGB_565;  
        // 建立对应 bitmap  
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);  
        // 建立对应 bitmap 的画布  
        Canvas canvas = new Canvas(bitmap);  
        drawable.setBounds(0, 0, w, h);  
        // 把 drawable 内容画到画布中  
        drawable.draw(canvas);  
        return bitmap;  
    } 
	
	/**
	 * 将Bitmap 转换成Drawable
	 */
	public static Drawable bitmapToDrawable(Bitmap bm){
		@SuppressWarnings("deprecation")
		Drawable drawable = new BitmapDrawable(bm);
		//因为BtimapDrawable是Drawable的子类，最终直接使用drawable对象即可。 
		return drawable;
	}
	
	/**
	 * Drawable 缩放 指定width heigth
	 */
	@SuppressWarnings("deprecation")
	public static Drawable zoomDrawable(Drawable drawable, int w, int h) {  
	    int width = drawable.getIntrinsicWidth();  
	    int height = drawable.getIntrinsicHeight();  
	    // drawable转换成bitmap  
	    Bitmap oldbmp = drawableToBitmap(drawable);  
	    // 创建操作图片用的Matrix对象  
	    Matrix matrix = new Matrix();  
	    // 计算缩放比例  
	    float sx = ((float) w / width);  
	    float sy = ((float) h / height);  
	    // 设置缩放比例  
	    matrix.postScale(sx, sy);  
	    // 建立新的bitmap，其内容是对原bitmap的缩放后的图  
	    Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true);  
	    return new BitmapDrawable(newbmp);  
	}  
	
	/**
	 * Drawable 缩放 不指定width heigth 但是指定缩放倍数
	 */
	@SuppressWarnings("deprecation")
	public static Drawable zoomDrawable(Drawable drawable, float scale) {  
	    int width = drawable.getIntrinsicWidth();  
	    int height = drawable.getIntrinsicHeight();  
	    // drawable转换成bitmap  
	    Bitmap oldbmp = drawableToBitmap(drawable);  
	    // 创建操作图片用的Matrix对象  
	    Matrix matrix = new Matrix();  
	    // 设置缩放比例  
	    matrix.postScale(scale, scale);  
	    // 建立新的bitmap，其内容是对原bitmap的缩放后的图  
	    Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true);  
	    return new BitmapDrawable(newbmp);  
	}  
	
	/**
	 * 这里是做一个对list的长度check 因为发现在代码累加操作的
	 * 时候，很容易对长度的判断，直接写一个方法，方便调用
	 * 如果长度大于0 返回true 
	 * 否则返回false
	 * 默认false
	 * @param list 传入的一个继承集合的子类 
	 * @return 
	 */
	public static boolean checkListLenght(Object list){
		if(list instanceof Collection<?>){
			if(((ByteArrayOutputStream) list).size()>0){
				return true;
			}else{
				return false;
			}
		}
		return false;
	}
}
