package com.feboll.motoguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridAdapter extends BaseAdapter {
	private Context mContext;
	private int displayWidth;
	private ArrayList<String> brandName;


	public GridAdapter(Context c, int dW, ArrayList<String> bn) {
		mContext = c;
		displayWidth = dW;
		brandName = bn;
	}

	@Override
	public int getCount() {
		return brandName.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.brand_item, null);
		}
		TextView brandNameValue = (TextView) convertView.findViewById(R.id.brandName);
		brandNameValue.setText(String.valueOf(brandName.get(position)));

		brandNameValue.setWidth(displayWidth/2);
		brandNameValue.setHeight(displayWidth/2);

		return convertView;
	}
}
