package com.abhishesh.slidinganimation;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

public class SliderService extends Service{
	
	public static SliderService mService;
	private SliderView mSliderView = null;
	private Context mContext;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return START_STICKY;
	}
	
	@Override
	public void onCreate() {
		super.onCreate();
		mService = this;
		mContext = getApplicationContext();
		mSliderView = new SliderView(mContext);
		mSliderView.showView();
		
	}
	
	public SliderService getService(){
		return mService;
	}
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		if(mSliderView!=null)
			mSliderView.removeView();
		mSliderView = null;
		mService = null;
	}

}
