/**
 * 版权：深圳深青联科技有限公司
 * 设计:	 柯华栋
 * 代码：深青联研发部/Android组
 * 日期：2015年1月1日
 */

package com.work.util;

import android.os.SystemClock;

/**
 * ms时间内,不允许通过
 * 主要是为某些操作设置一个禁用时段
 */
public class TimeLock {
	private long last, cur;
	
	public boolean unlock(int ms) {
		cur = SystemClock.uptimeMillis();
		if (cur - last >= ms) {
			return true;
		}
		return false;
	}
	
	public long past() {
		cur = SystemClock.uptimeMillis();
		return cur-last;
	}
	
	public void reset() {
		last = SystemClock.uptimeMillis();
	}
	
	public void resetToZero() {
		last = 0;
	}
}
