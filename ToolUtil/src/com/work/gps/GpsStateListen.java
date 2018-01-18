package com.work.gps;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GpsStateListen {
	
	static LocationManager locationManager;
	static Context mContext;
	private static GpsStateListen gpsStateListen;
	
	public static GpsStateListen getInstance(){
		return gpsStateListen;
	}
	
	public static void initGps(Context context){
		if(gpsStateListen == null){
			gpsStateListen = new GpsStateListen(context);
		}
	}
	
	private GpsStateListen(Context context){
		mContext = context;
		locationManager = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
		if(locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){
			Criteria criteria = new Criteria();
			criteria.setAccuracy(Criteria.ACCURACY_FINE); //高精度
			criteria.setPowerRequirement(Criteria.POWER_LOW);//低电量
			criteria.setAltitudeRequired(true);  //不获取海拔信息 
			criteria.setBearingRequired(true);  //不获取方位信息   
			criteria.setCostAllowed(false);  //是否允许付费   
			String provider = locationManager.getBestProvider(criteria, true);
			Location location = locationManager.getLastKnownLocation(provider);
			updateWithNewLocation(location);
			locationManager.requestLocationUpdates(provider, 5*1000, 5, locationListener);
		}
	}
	
	/**
	 * 根据更新过来的location来进行处理
	 * @param location 位置
	 */
	private void updateWithNewLocation(Location location) {
			double lat = location.getLatitude();
			double log = location.getLongitude();
			//处理经纬度
	}
	
	
	LocationListener locationListener = new LocationListener() {
		/**
         * GPS状态变化时触发
         */
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
		/**
         * GPS开启时触发
         */
		@Override
		public void onProviderEnabled(String provider) {
			
		}
		/**
         * GPS禁用时触发
         */
		@Override
		public void onProviderDisabled(String provider) {
			
		}
		/**
		 * 位置发生改变的时候触发
		 */
		@Override
		public void onLocationChanged(Location location) {
			updateWithNewLocation(location);
		}
	};
}
