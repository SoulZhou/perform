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
	 * Bitmap ����
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
	 * ��Drawable ת����Bitmap
	 */
	public static Bitmap drawableToBitmap(Drawable drawable) {  
        // ȡ drawable �ĳ���  
        int w = drawable.getIntrinsicWidth();  
        int h = drawable.getIntrinsicHeight();  
  
        // ȡ drawable ����ɫ��ʽ  
        Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888  
                : Bitmap.Config.RGB_565;  
        // ������Ӧ bitmap  
        Bitmap bitmap = Bitmap.createBitmap(w, h, config);  
        // ������Ӧ bitmap �Ļ���  
        Canvas canvas = new Canvas(bitmap);  
        drawable.setBounds(0, 0, w, h);  
        // �� drawable ���ݻ���������  
        drawable.draw(canvas);  
        return bitmap;  
    } 
	
	/**
	 * ��Bitmap ת����Drawable
	 */
	public static Drawable bitmapToDrawable(Bitmap bm){
		@SuppressWarnings("deprecation")
		Drawable drawable = new BitmapDrawable(bm);
		//��ΪBtimapDrawable��Drawable�����࣬����ֱ��ʹ��drawable���󼴿ɡ� 
		return drawable;
	}
	
	/**
	 * Drawable ���� ָ��width heigth
	 */
	@SuppressWarnings("deprecation")
	public static Drawable zoomDrawable(Drawable drawable, int w, int h) {  
	    int width = drawable.getIntrinsicWidth();  
	    int height = drawable.getIntrinsicHeight();  
	    // drawableת����bitmap  
	    Bitmap oldbmp = drawableToBitmap(drawable);  
	    // ��������ͼƬ�õ�Matrix����  
	    Matrix matrix = new Matrix();  
	    // �������ű���  
	    float sx = ((float) w / width);  
	    float sy = ((float) h / height);  
	    // �������ű���  
	    matrix.postScale(sx, sy);  
	    // �����µ�bitmap���������Ƕ�ԭbitmap�����ź��ͼ  
	    Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true);  
	    return new BitmapDrawable(newbmp);  
	}  
	
	/**
	 * Drawable ���� ��ָ��width heigth ����ָ�����ű���
	 */
	@SuppressWarnings("deprecation")
	public static Drawable zoomDrawable(Drawable drawable, float scale) {  
	    int width = drawable.getIntrinsicWidth();  
	    int height = drawable.getIntrinsicHeight();  
	    // drawableת����bitmap  
	    Bitmap oldbmp = drawableToBitmap(drawable);  
	    // ��������ͼƬ�õ�Matrix����  
	    Matrix matrix = new Matrix();  
	    // �������ű���  
	    matrix.postScale(scale, scale);  
	    // �����µ�bitmap���������Ƕ�ԭbitmap�����ź��ͼ  
	    Bitmap newbmp = Bitmap.createBitmap(oldbmp, 0, 0, width, height, matrix, true);  
	    return new BitmapDrawable(newbmp);  
	}  
	
	/**
	 * ��������һ����list�ĳ���check ��Ϊ�����ڴ����ۼӲ�����
	 * ʱ�򣬺����׶Գ��ȵ��жϣ�ֱ��дһ���������������
	 * ������ȴ���0 ����true 
	 * ���򷵻�false
	 * Ĭ��false
	 * @param list �����һ���̳м��ϵ����� 
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
