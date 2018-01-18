package com.work.print;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class DrawMsgView extends View {
	private final int MAX = 16;//MAX定义最大的msg显示
	String[] MSG = new String[MAX];
	//总共的数量
	int count = 0;
	Paint paint = new Paint();
	private Thread mUIThread;
	
	public DrawMsgView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public DrawMsgView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public DrawMsgView(Context context) {
		super(context);
		mUIThread = Thread.currentThread();
	}
	
	public void setMsg(String msg){
		if(count<MAX){
			MSG[count] = msg;
			count++;
		}else{
			for (int i = 0; i < MAX; i++) {
				if(i<(MAX-1)){
					String tmp = MSG[i+1];
					MSG[i]= tmp;
				}else{
					MSG[MAX-1] = msg;
				}
			}
		}
		invalidate();
	}
	
	@Override
	public void invalidate() {
		if(mUIThread == Thread.currentThread()){
			super.invalidate();
		}else{
			super.postInvalidate();
		}
	}
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/*if(count == 0){
			return;
		}*/
		paint.setColor(Color.RED);
		paint.setTextSize(20);
		int x = 8;
		//每一行的字体的高度 暂定30
		int heiht = 30;
		for (int i = 0; i < MAX; i++) {
			if(MSG[i] != null){
				canvas.drawText(MSG[i], x, heiht*(i+1), paint);
			}
		}
	}
}
