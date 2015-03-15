package com.abhishesh.slidinganimation;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.widget.ImageView;

public class SliderView implements OnTouchListener{
	
	private WindowManager mWindowManager;
	private ImageView mImageView;
	WindowManager.LayoutParams mLayoutParams;
	private GestureDetector mGestureDetector;
	private SliderMenuTouchGestureListener mTouchGestureListener;
	float mHorizontalDelta = 150.0f;
	final int width = 80;
	private Context mContext;

	public SliderView(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
		mImageView = new ImageView(mContext);
		mTouchGestureListener = new SliderMenuTouchGestureListener();
		mGestureDetector = new GestureDetector(mContext,mTouchGestureListener);
		mImageView.setOnTouchListener(this);
		mWindowManager = (WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE);
		mLayoutParams = new WindowManager.LayoutParams(
	        		width,
	        		WindowManager.LayoutParams.MATCH_PARENT, 
	                WindowManager.LayoutParams.TYPE_PHONE,
	                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,  
	                PixelFormat.TRANSLUCENT);      
         mLayoutParams.gravity = Gravity.LEFT | Gravity.TOP;
	}

	public void removeView() {
		// TODO Auto-generated method stub
		if(mImageView!=null)
			mWindowManager.removeView(mImageView);
		mImageView = null;
		mLayoutParams = null;
	}

	public void showView() {
		// TODO Auto-generated method stub   
	     mWindowManager.addView(mImageView, mLayoutParams);		
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		return mGestureDetector.onTouchEvent(event);
	}
	
	private void callFloatingActivity() {
		// TODO Auto-generated method stub
		mContext.startActivity(new Intent(mContext,FloatingActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
	}
	
	private class SliderMenuTouchGestureListener extends SimpleOnGestureListener{
		@Override
		public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
				float velocityY) {
			// TODO Auto-generated method stub
			float lenY = e2.getY() - e1.getY();
			float lenX = e2.getX() - e1.getX();
			if(lenX > mHorizontalDelta){
				Log.d("ABHISHESH","swiperight" + lenX);
				callFloatingActivity();				
			}
			return super.onFling(e1, e2, velocityX, velocityY);
		}

		@Override
		public boolean onSingleTapUp(MotionEvent e) {
			// TODO Auto-generated method stub
			return super.onSingleTapUp(e);
		}
		
	}
}
