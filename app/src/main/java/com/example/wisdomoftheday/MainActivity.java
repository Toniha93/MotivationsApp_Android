package com.example.wisdomoftheday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private Button settingsButton;
	private TextView quotes;
	private TextView quotes2;
	private TextView quotes3;
	private TextView quotes4;
	private TextView quotes5;
	private LinearLayout mL1;
	private LinearLayout mL2;
	private LinearLayout mL3;
	private LinearLayout mL4;
	private LinearLayout mL5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//create UI Elements
		settingsButton = (Button)findViewById(R.id.settingsButton);
		quotes = (TextView)findViewById(R.id.quote);
		quotes2 = (TextView)findViewById(R.id.quote2);
		quotes3 = (TextView)findViewById(R.id.quote3);
		quotes4 = (TextView)findViewById(R.id.quote4);
		quotes5 = (TextView)findViewById(R.id.quote5);
		mL1 = (LinearLayout)findViewById(R.id.lo);
		mL2 = (LinearLayout)findViewById(R.id.lo2);
		mL3 = (LinearLayout)findViewById(R.id.lo3);
		mL4 = (LinearLayout)findViewById(R.id.lo4);
		mL5 = (LinearLayout)findViewById(R.id.lo5);
		
		
		opensettings();
	}

	private void opensettings() {
		
		settingsButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				mL1.removeAllViews();
				mL2.removeAllViews();
				mL3.removeAllViews();
				mL4.removeAllViews();
				mL5.removeAllViews();
				Intent intent = new Intent(MainActivity.this,SettingsActivity.class);
				int requestCode = 101;
				startActivityForResult(intent, requestCode);
			}
		});
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode == 101){
			if(resultCode == RESULT_OK){
				Bundle extras = data.getExtras();
				quotes.setText(extras.getString("Quotes1"));
				quotes2.setText(extras.getString("Quotes2"));
				quotes3.setText(extras.getString("Quotes3"));
				quotes4.setText(extras.getString("Quotes4"));
				quotes5.setText(extras.getString("Quotes5"));
				mL1.addView(quotes);
				mL2.addView(quotes2);
				mL3.addView(quotes3);
				mL4.addView(quotes4);
				mL5.addView(quotes5);
			}
		}
	}
}
