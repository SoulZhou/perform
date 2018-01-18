package com.work.print;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.work.util.DateUtil;

import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

public class JPrintBug {
	private static final String TAG = "ToolUtil";
	
	Context context;
	DrawMsgView drawMsgView;
	WindowManager manager;
	WindowManager.LayoutParams params;
	static JPrintBug printBug;
	private Thread mUIThread;
	private Handler handler;
	
	private JPrintBug(Context context){
		this.context = context;
		drawMsgView = new DrawMsgView(context);
		manager = (WindowManager) this.context.getSystemService(this.context.WINDOW_SERVICE);
		params = getParams();
		manager.addView(drawMsgView, params);
		mUIThread = Thread.currentThread();
		handler = new Handler(context.getMainLooper());
	}
	
	public static void initPrint(Context context){
		if(printBug == null){
			printBug = new JPrintBug(context);
		}
	}
	
	public static JPrintBug getPrint(){
		return printBug;
	}
	
	/**
	 * 屏幕打印
	 * @return
	 */
	private  boolean isNeed2Print(){
		final String debugPath = "/mnt/sdcard/printdebug.txt";
		File file = new File(debugPath);
		if(file.exists()){
			return true;
		}
		return false;
	}
	/**
	 * 写出到文本
	 * @return
	 */
	private  boolean isNeed2Write(){
		final String debugPath = "/mnt/sdcard/writedebug.txt";
		File file = new File(debugPath);
		if(file.exists()){
			return true;
		}
		return false;
	}
	
	
	public void d(final String TAG, final String msg)
	{
		if(isNeed2Print()) {
			Log.d(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
			
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	public  void i(final String TAG, final String msg)
	{
		if(isNeed2Print()) {
			Log.i(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	
	public  void v(final String TAG, final String msg)
	{
		if(isNeed2Print()) {
			Log.v(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	
	public  void e(final String TAG, final String msg)
	{
		if(isNeed2Print()) {
			Log.e(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	public  void d(final String msg)
	{
		if(isNeed2Print()) {
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	public  void i(final String msg)
	{
		if(isNeed2Print()) {
			Log.i(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	
	public  void v( final String msg)
	{
		if(isNeed2Print()) {
			Log.v(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	
	public  void e( final String msg)
	{
		if(isNeed2Print()) {
			Log.e(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	public  void w(final String msg){
		if(isNeed2Print()) {
			Log.w(TAG, msg);
			if(mUIThread == Thread.currentThread()){
				addForceWindow(TAG +" : "+msg);
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						addForceWindow(TAG +" : "+msg);
					}
				});
			}
		}else{
			if(mUIThread == Thread.currentThread()){
				deleteForceWindow();
			}else{
				handler.post(new Runnable() {
					
					@Override
					public void run() {
						deleteForceWindow();
					}
				});
			}
		}
		if(isNeed2Write()){
			write2Txt(DateUtil.timeStamp2Datestr(String.valueOf(System.currentTimeMillis())));
			write2Txt(msg);
		}
	}
	
	public  void write2Txt(String msg){
		String pkgName = this.context.getPackageName();
		pkgName = pkgName.replace(".", "");
		String writePath = "/mnt/sdcard/"+pkgName+".txt";
		try {
			FileOutputStream fos = new FileOutputStream(writePath, true);
			fos.write(msg.getBytes("GBK"));
			fos.write("\n".getBytes());
			fos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	private  void addForceWindow(String msg) {
		if(drawMsgView != null){
			if (drawMsgView.getVisibility() != View.VISIBLE) {
				drawMsgView.setVisibility(View.VISIBLE);
			}
			drawMsgView.setMsg(msg);
		}
	}
	
	private  void deleteForceWindow() {
		if(drawMsgView != null){
			drawMsgView.setVisibility(View.GONE);
		}
	}
	
	public WindowManager.LayoutParams getParams(){
		WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
		layoutParams.x = 0;
		layoutParams.y = 0;
		layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
		layoutParams.height = WindowManager.LayoutParams.MATCH_PARENT;
		layoutParams.format = PixelFormat.RGBA_8888;
		layoutParams.flags = WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE;
		layoutParams.flags = WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;
		layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
				
		return layoutParams;
	}
	
}
