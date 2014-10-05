package com.feboll.motoguide;

import android.content.Context;
import android.text.Layout;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import static com.feboll.motoguide.R.color.*;

public class ImageAdapter extends BaseAdapter {
	private Context mContext;
	private int displayWidth;
	private ArrayList<String> brandName;


	public ImageAdapter(Context c, int dW, ArrayList<String> bn) {
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
		LinearLayout linearLayout = new LinearLayout(mContext);
		TextView imageView = new TextView(mContext);
		linearLayout.addView(imageView);
		linearLayout.setPadding(3,3,3,3);
		imageView.setBackgroundResource(R.color.bg_item);
		imageView.setWidth(displayWidth/2);
		imageView.setHeight(displayWidth/2);
		imageView.setGravity(Gravity.CENTER);

		imageView.setText(String.valueOf(brandName.get(position)));
		return linearLayout;
	}

	// references to our images
	private Integer[] mThumbIds = {
			1, 2,	3, 4,	5, 6,	7, 8,	9, 10, 11, 12, 13, 14,
			15, 16,	17, 18, 19, 20, 21, 22
	};
}
