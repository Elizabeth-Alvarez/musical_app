package com.example.musical;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Buttons extends Activity {
	
	Button button1;
	Button button2;
	Button button3;
	Button button4;
	Button buttonEnd;

	MediaPlayer mpbutton1;
	MediaPlayer mpbutton2;
	MediaPlayer mpbutton3;
	MediaPlayer mpbutton4;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		button1 = (Button)findViewById(R.id.button1);
		button2 = (Button)findViewById(R.id.button2);
		button3 = (Button)findViewById(R.id.button3);
		button4 = (Button)findViewById(R.id.button4);
		buttonEnd = (Button)findViewById(R.id.buttonEnd);
		
		//Setting color to buttons
		buttonEnd.setBackgroundColor(0xffc0b846);
		button1.setBackgroundColor(0xff4565b7);
		button2.setBackgroundColor(0xffeb7197);
		button3.setBackgroundColor(0xffff5d27);
		button4.setBackgroundColor(0xff44ff5c);

		
		//Setting sound to buttons
		mpbutton1 = MediaPlayer.create(this, R.raw.hastaabajo);
		mpbutton2 = MediaPlayer.create(this, R.raw.saxobeat);
		mpbutton3 = MediaPlayer.create(this, R.raw.passthedutch);
		mpbutton4 = MediaPlayer.create(this, R.raw.mesaquemasaplauda);
		
		
		button1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.musical.FLASHINGBUTTON"));
				mpbutton1.start();
				if(!(mpbutton1.isPlaying()))
					  mpbutton1.release();
			}
		});
		

		button2.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.musical.FLASHINGBUTTON2"));
				mpbutton2.start();
				if(!(mpbutton2.isPlaying()))
					  mpbutton2.release();
			}
			
		});
		

		button3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.musical.FLASHINGBUTTON3"));
				mpbutton3.start();
				if(!(mpbutton3.isPlaying()))
					  mpbutton3.release();
			}
		});
		

		button4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.musical.FLASHINGBUTTON4"));
				mpbutton4.start();
				if(!(mpbutton4.isPlaying()))
					  mpbutton4.release();
			}
		});
		
		
		buttonEnd.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		
	}
	
	
}