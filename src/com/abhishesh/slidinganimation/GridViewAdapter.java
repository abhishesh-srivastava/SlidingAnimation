package com.abhishesh.slidinganimation;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridViewAdapter extends BaseAdapter{

	private ArrayList<GridViewItem> list;
	private Context mContext;
	private LayoutInflater mInflater;

	
	public GridViewAdapter(Context context,
			ArrayList<GridViewItem> resInfo) {
		// TODO Auto-generated constructor stub
		mContext = context;
		list = resInfo;
		mInflater = LayoutInflater.from(mContext);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
			ImageView imageView;
	 		TextView txtView;
 			convertView = mInflater.inflate(R.layout.grid_item, null);
			imageView = (ImageView) convertView.findViewById(R.id.icon);
			imageView.setBackground(list.get(position).getIcon());
			txtView = (TextView)convertView.findViewById(R.id.name);
			txtView.setText(list.get(position).name);
			imageView.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					triggerLaunchIntent(list.get(position));					
				}
	
	
			});
		return convertView;
	}
	
	private void triggerLaunchIntent(GridViewItem gridViewItem) {
		// TODO Auto-generated method stub
	    Intent intent = mContext.getPackageManager().getLaunchIntentForPackage(gridViewItem.packageName);
	    
	    mContext.startActivity(intent);
		
	}
	public static class ViewHolder {
        ImageView mImg;
        TextView mTxt;  
    }

}
