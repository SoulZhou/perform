/**
 * ��Ȩ�������������Ƽ����޹�˾
 * ���:	 �»���
 * ���룺�������з���/Android��
 * ���ڣ�2015��1��1��
 */

package com.work.util;

import android.os.SystemClock;

/**
 * msʱ����,������ͨ��
 * ��Ҫ��ΪĳЩ��������һ������ʱ��
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
