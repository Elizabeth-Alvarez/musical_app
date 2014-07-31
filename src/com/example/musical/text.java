package com.example.musical;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;



public class text extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		
		TextView tv1 = (TextView) findViewById(R.id.TextView01);
		tv1.setText("Welcome my friend!..." + "All you have to do to enjoy yourself..." + "is click on the button and have fun!!!");

	}
	
	
}