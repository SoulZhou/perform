
package com.work.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.work.print.JPrintBug;

/**
 * 这个可以作为翻页的时候的一个显示当前页的效果，在哪个页面
 * 就高亮哪个亮点
 * @author Administrator
 *
 */
public class Point extends View{
	
	final int DEFAULT_WIDTH = 10;
	final int DEFAULT_HEIGHT = 10;
	
	final int CIRCLE_MODE = 0;
	final int RECT_MODE = 1;
	final int RECTF_MODE = 2;

	int mMode = CIRCLE_MODE;
	int norColor;
	int slectedColor;
	
	float mCenterX;
	float mCenterY;
	
	Paint norPaint;
	Paint slectPaint;
	
	int mWidth;
	int mHeight;
	
	boolean slected = false;
	
	/**
	 * @param context
	 * @param attrs
	 * @param defStyle
	 */
	public Point(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		norColor = Color.WHITE;
		slectedColor = Color.GREEN;
	}

	/**
	 * @param context
	 * @param attrs
	 */
	public Point(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	/**
	 * @param context
	 */
	public Point(Context context) {
		this(context, null);
	}

	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		mHeight = MeasureSpec.getSize(heightMeasureSpec);
		mWidth = MeasureSpec.getSize(widthMeasureSpec);
		int heightMode = MeasureSpec.getMode(heightMeasureSpec);
		int widthMode = MeasureSpec.getMode(widthMeasureSpec);
		
		if(widthMode != MeasureSpec.EXACTLY){
			mWidth = DEFAULT_WIDTH;
		}
		
		if(heightMode != MeasureSpec.EXACTLY){
			mHeight = DEFAULT_HEIGHT;
		}
		
		mCenterX = mWidth / 2.f;
		mCenterY = mHeight / 2.f;
		
		setMeasuredDimension(mWidth, mHeight);
	}
	
	@Override
	public void draw(Canvas canvas) {
		super.draw(canvas);
		if(norPaint ==  null){
			norPaint = new Paint();
			norPaint.setColor(norColor);
			norPaint.setStrokeWidth(0.5f); 
			norPaint.setFilterBitmap(true);
			norPaint.setAntiAlias(true);
			norPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_OVER));
		}
		
		if(slectPaint == null){
			slectPaint = new Paint();
			slectPaint.setColor(slectedColor);
			slectPaint.setFilterBitmap(true);
			slectPaint.setAntiAlias(true);
			slectPaint.setStrokeWidth(.5f);
		}
		
		 int sc = canvas.saveLayer(0, 0, getWidth(), getHeight(), null,
                 Canvas.MATRIX_SAVE_FLAG |
                 Canvas.CLIP_SAVE_FLAG |
                 Canvas.HAS_ALPHA_LAYER_SAVE_FLAG |
                 Canvas.FULL_COLOR_LAYER_SAVE_FLAG |
                 Canvas.CLIP_TO_LAYER_SAVE_FLAG);
		
		final float radius = Math.min(getWidth(), getHeight()) / 2.f;
		JPrintBug.getPrint().d("slected == "+slected);
		if(slected) canvas.drawCircle(mCenterX, mCenterY, radius, slectPaint);
		canvas.drawCircle(mCenterX, mCenterY, radius - 2.f, norPaint);
		canvas.restoreToCount(sc);
	}
	
	@Override
	public boolean isSelected() {
		return super.isSelected();
	}
	
	/**
	 * @param slected the slected to set
	 */
	public void setSlected(boolean slected) {
		JPrintBug.getPrint().d("setSlected == "+slected);
		this.slected = slected;
		invalidate();
	}
}
