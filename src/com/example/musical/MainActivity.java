package com.example.musical;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;


public class MainActivity extends Activity {
	
	
	MediaPlayer mpSplash;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		//Begins sound with splash screen
	    mpSplash = MediaPlayer.create(this, R.raw.rockthatbody);
		mpSplash.start();
		
		
		/*This thread is to time how long splash page is displayed before
		  moving on to next thing*/
		Thread logoTimer = new Thread() {
			public void run() {
				try {
					int logoTimer = 0;
					while(logoTimer < 5000) {
						sleep(100); //1/10 of a second
						logoTimer = logoTimer + 100;
					}
					startActivity(new Intent("com.example.musical.CLEARSCREEN"));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				finally {
					finish();
				}
			}
			
		}; //End of Thread
		logoTimer.start();

	}
	

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		mpSplash.release();//stops music after image is gone
	}


	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		mpSplash.pause();
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		mpSplash.start();
	}

}
  