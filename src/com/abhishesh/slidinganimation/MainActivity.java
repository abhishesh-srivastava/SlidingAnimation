package com.abhishesh.slidinganimation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	private Button btnStrt;
	String btnText = "Start Service";
	private Context mContext;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mContext = this;
		btnStrt = (Button)findViewById(R.id.btnStart);
		
		btnStrt.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				Intent intent = new Intent(mContext,SliderService.class);
				if(SliderService.mService == null){
					startService(intent);
					btnText = "Stop Service";					
				} else{
					stopService(intent);
					btnText = "Start Service";
				}
				btnStrt.setText(btnText);
			}
		});
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		btnText = SliderService.mService!=null ? "Stop Service" : "Start Service";
		btnStrt.setText(btnText);
	}

}
