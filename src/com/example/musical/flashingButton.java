package com.example.musical;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;



public class flashingButton extends Activity implements SensorEventListener{
	
	
	float x, y, sensorX, sensorY;
	Bitmap ball;
	SensorManager sm;
	MyBringBackSurface ourSurfaceView;
	
	
	public class MyBringBackSurface extends SurfaceView implements Runnable {
		
		SurfaceHolder ourHolder;
		Thread ourThread = null;
		boolean isRunning = false;
		
		
		public MyBringBackSurface(Context context) {
			super(context);
			ourHolder = getHolder();
		}
		
		public void pause() {
			isRunning = false;
			while(true) { 
				try {
					ourThread.join();
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
				break;
			}
			ourThread = null;
		}
		
		public void resume() {
			isRunning = true;
			ourThread = new Thread(this);
			ourThread.start();
		}
		
		public void run() {
			while(isRunning) {
				if(!ourHolder.getSurface().isValid())
					continue;
				
				Canvas canvas = ourHolder.lockCanvas();
				canvas.drawRGB(02, 02, 150);
				float centerX = canvas.getWidth()/4;
				float centerY = canvas.getHeight()/4;
				canvas.drawBitmap(ball,centerX + sensorX*20, centerY + sensorY*20, null);
				ourHolder.unlockCanvasAndPost(canvas);
			}
		}
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		if (sm.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			Sensor s = sm.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
		}
		
		ball = BitmapFactory.decodeResource(getResources(),R.drawable.greenball);
		x = y = sensorX = sensorY = 0;
		ourSurfaceView = new MyBringBackSurface(this);
		ourSurfaceView.resume();
		setContentView(ourSurfaceView);
	}
	

	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onSensorChanged(SensorEvent e) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(16);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		sensorX = e.values[0];
		sensorY = e.values[1];
	}
	
	
	

	
}