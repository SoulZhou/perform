package com.work.util;

/**
 * �������Ƶķ�װ ��ͬ����ͬһ��list�б������Ͱ�ȫ�ɿ�һ��
 * @author Administrator
 *
 */
public class ToolNetLimit {
	
	/*//wifi��ʱ��ĺ����� mobileʱ��ĺ�����
	List<Integer> listWifi = new ArrayList<Integer>();
	List<Integer> listMobile = new ArrayList<Integer>();
	Context context;
	static ToolNetLimit limit;
	public static void initLimit(Context context){
		if(limit == null){
			limit = new ToolNetLimit(context);
		}
	}
	
	public static ToolNetLimit getLimit(){
		return limit;
	}
	
	private ToolNetLimit(Context context) {
		this.context = context;
	}
	
	*//**
	 * ��ӵ�һ��һ��UID Ȼ���ȥ����
	 * @param lists
	 * @param uid
	 *//*
	public void setOneLimitList(List<Integer> lists, int uid){
		if(lists == null){
			return;
		}
		if(lists!=null&&lists.size()==0){
			lists.add(uid);
		}else{
			if(!ToolDao.isContains(lists, uid)){
				lists.add(uid);
			}
		}
		setLimitNet();
	}
	*//**
	 * ɾ����һ��һ��UID Ȼ���ȥ����
	 * @param lists
	 * @param uid
	 *//*
	public void delOneLimitList(List<Integer> lists, int uid){
		if(lists!=null&&lists.size()>0){
			if(ToolDao.isContains(lists, uid)){
				lists.remove(uid);
			}
			setLimitNet();
		}
	}
	
	*//**
	 * ������Ƶ�UID ֻ������ӽ��б�������Ҫ�������
	 * @param lists
	 * @param uid
	 *//*
	public void addLimitList(List<Integer> lists, int uid){
		if(lists == null){
			return;
		}
		if(lists!=null&&lists.size()==0){
			lists.add(uid);
		}else{
			if(!ToolDao.isContains(lists, uid)){
				lists.add(uid);
			}
		}
	}

	//��������Ȩ��
	public void setLimitNet() {
		DroidWallAPI.applyIptablesRules(context, listWifi, listMobile, false, false);
	}
	
	public void reSetLimitNet() {
		DroidWallAPI.purgeIptables(context);
	}
	
	//Ŀǰ��ʱû��÷�װ�� �������ṩԭ���ķ�������������
	public boolean setLimitNet(Context context,List<Integer> listWifi,List<Integer> listMobile) {
		return DroidWallAPI.applyIptablesRules(context, listWifi, listMobile, false, false);
	}
	
	public void reSetLimitNet(Context context) {
		DroidWallAPI.purgeIptables(context);
	}

	
	
	public List<Integer> getListWifi() {
		return listWifi;
	}

	public void setListWifi(List<Integer> listWifi) {
		this.listWifi = listWifi;
	}

	public List<Integer> getListMobile() {
		return listMobile;
	}

	public void setListMobile(List<Integer> listMobile) {
		this.listMobile = listMobile;
	}*/



}
