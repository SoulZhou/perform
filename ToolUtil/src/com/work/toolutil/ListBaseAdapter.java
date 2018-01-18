package com.work.toolutil;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListBaseAdapter extends BaseAdapter {

	List<PrivInfo> infos;
	LayoutInflater inflater;
	
	public ListBaseAdapter(List<PrivInfo> infos, Context context) {
		super();
		this.infos = infos;
		inflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount() {
		return infos.size();
	}

	@Override
	public Object getItem(int position) {
		return infos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHodler hodler = null;
		if(convertView == null){
			hodler = new ViewHodler();
			convertView = inflater.inflate(R.layout.item_show, null);
			hodler.id = (TextView) convertView.findViewById(R.id.showid);
			hodler.info1 = (TextView) convertView.findViewById(R.id.showInfo1);
			hodler.info2 = (TextView) convertView.findViewById(R.id.showInfo2);
			hodler.info3 = (TextView) convertView.findViewById(R.id.showInfo3);
			hodler.info4 = (TextView) convertView.findViewById(R.id.showInfo4);
			hodler.sex = (TextView) convertView.findViewById(R.id.showSex);
			convertView.setTag(hodler);
		}else{
			hodler = (ViewHodler) convertView.getTag();
		}
		hodler.id.setText(""+infos.get(position).getIndexID());
		hodler.info1.setText(infos.get(position).getInfo1Str());
		hodler.info2.setText(infos.get(position).getInfo2Str());
		hodler.info3.setText(infos.get(position).getInfo3Str());
		hodler.info4.setText(infos.get(position).getInfo4Str());
		hodler.sex.setText(infos.get(position).getSexStr());
		return convertView;
	}

	
	private class ViewHodler{
		TextView id;
		TextView info1;
		TextView info2;
		TextView info3;
		TextView info4;
		TextView sex;
	}
}
