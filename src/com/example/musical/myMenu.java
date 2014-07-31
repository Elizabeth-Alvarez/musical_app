package com.example.musical;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class myMenu extends Activity {
	
	Button end;
	Button start;
	Button instructions;
	
	
	@Override
	protected void onCreate(Bundle icicle) {
		// TODO Auto-generated method stub
		super.onCreate(icicle);
		setContentView(R.layout.menu);
		
		//Setting style to buttons' xml
		end = (Button)findViewById(R.id.end);
		start = (Button)findViewById(R.id.start);
		instructions = (Button)findViewById(R.id.instructions);
		
		//Setting button colors
		start.setBackgroundColor(0xffff0000);
		end.setBackgroundColor(0xffffff00);
		instructions.setBackgroundColor(0xff00ff00);
		
		
		end.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		
		
		instructions.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent("com.example.musical.TEXT"));
			}
		});
		
		
		start.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//startActivity(new Intent("com.example.musical.BUTTON1"));
				startActivity(new Intent("com.example.musical.BUTTONS"));
				
			}
		});
		
		
		
	}

}