package com.work.util;

/**
 * 网络限制的封装 共同管理同一个list列表，这样就安全可靠一点
 * @author Administrator
 *
 */
public class ToolNetLimit {
	
	/*//wifi的时候的黑名单 mobile时候的黑名单
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
	 * 添加单一的一个UID 然后就去设置
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
	 * 删除单一的一个UID 然后就去设置
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
	 * 添加限制的UID 只负责添加进列表，设置需要最后设置
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

	//设置上网权限
	public void setLimitNet() {
		DroidWallAPI.applyIptablesRules(context, listWifi, listMobile, false, false);
	}
	
	public void reSetLimitNet() {
		DroidWallAPI.purgeIptables(context);
	}
	
	//目前暂时没想好封装的 所以先提供原本的方法来设置上网
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
