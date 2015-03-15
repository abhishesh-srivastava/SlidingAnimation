package com.abhishesh.slidinganimation;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.GridView;

public class FloatingActivity extends Activity{	
	
	private GridViewAdapter mAdapter;
	private GridView mGridView;
	private ArrayList<GridViewItem> mGridItemList;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_floating);
		getActionBar().hide();
		mGridView = (GridView) findViewById(R.id.gridview);

	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		populateList();
		overridePendingTransition(R.anim.activity_slide_left,0);
	}
	
	private void populateList() {
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
	    shareIntent.setType("image/png");
		List<ResolveInfo> resInfo = getPackageManager().queryIntentActivities(shareIntent, 0);
		mGridItemList = new ArrayList<GridViewItem>();
		for(ResolveInfo res : resInfo){
			String name = (String) res.loadLabel(getPackageManager());
			String packageName = res.activityInfo.packageName;
			Drawable image = res.loadIcon(getPackageManager());
			if(getPackageManager().getLaunchIntentForPackage(packageName) != null){
				GridViewItem item = new GridViewItem(name,image,packageName);
				mGridItemList.add(item);
			}
		}

		mAdapter = new GridViewAdapter(this,mGridItemList);
		mGridView.setAdapter(mAdapter);
	}

	@Override
	public void onAttachedToWindow() {
		// TODO Auto-generated method stub
		super.onAttachedToWindow();
		View view = getWindow().getDecorView();
		WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) view.getLayoutParams();          
        layoutParams.gravity = Gravity.LEFT|Gravity.TOP;  
        layoutParams.width = getWindowManager().getDefaultDisplay().getWidth()/2;  
        layoutParams.height = getWindowManager().getDefaultDisplay().getHeight();
        getWindowManager().updateViewLayout(view, layoutParams);
     //   overridePendingTransition(R.anim.activity_slide_left,0);
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		overridePendingTransition(0, R.anim.activity_slide_right);
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		super.finish();
		//overridePendingTransition(0, R.anim.activity_slide_right);
	}
	
	@Override
	public void onWindowFocusChanged(boolean hasFocus) {
		// TODO Auto-generated method stub
		if(hasFocus)
			getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
		super.onWindowFocusChanged(hasFocus);
	}

}
