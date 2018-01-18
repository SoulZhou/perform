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
			criteria.setAccuracy(Criteria.ACCURACY_FINE); //�߾���
			criteria.setPowerRequirement(Criteria.POWER_LOW);//�͵���
			criteria.setAltitudeRequired(true);  //����ȡ������Ϣ 
			criteria.setBearingRequired(true);  //����ȡ��λ��Ϣ   
			criteria.setCostAllowed(false);  //�Ƿ�������   
			String provider = locationManager.getBestProvider(criteria, true);
			Location location = locationManager.getLastKnownLocation(provider);
			updateWithNewLocation(location);
			locationManager.requestLocationUpdates(provider, 5*1000, 5, locationListener);
		}
	}
	
	/**
	 * ���ݸ��¹�����location�����д���
	 * @param location λ��
	 */
	private void updateWithNewLocation(Location location) {
			double lat = location.getLatitude();
			double log = location.getLongitude();
			//����γ��
	}
	
	
	LocationListener locationListener = new LocationListener() {
		/**
         * GPS״̬�仯ʱ����
         */
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			
		}
		/**
         * GPS����ʱ����
         */
		@Override
		public void onProviderEnabled(String provider) {
			
		}
		/**
         * GPS����ʱ����
         */
		@Override
		public void onProviderDisabled(String provider) {
			
		}
		/**
		 * λ�÷����ı��ʱ�򴥷�
		 */
		@Override
		public void onLocationChanged(Location location) {
			updateWithNewLocation(location);
		}
	};
}
