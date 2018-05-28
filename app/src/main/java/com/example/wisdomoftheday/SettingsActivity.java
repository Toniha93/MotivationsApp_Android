package com.example.wisdomoftheday;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.NumberPicker;
import android.widget.ToggleButton;

public class SettingsActivity extends Activity {

	private ToggleButton randomButton;
	private Button doneButton;
	private NumberPicker mQuotesPerview;
	static int counter = 0;
	static String random1 =null;
	static String random2 = null;
	static String random3= null;
	static String random4=null;
	static String random5=null;
	static String value[] = new String[5];
	static int valueCounter = 0;
	
	
	private class DownloadWisdom extends AsyncTask<String, Void, WisdomDb> {

		@Override
		protected WisdomDb doInBackground(String... result) {
			WisdomDb.init();
			return null;
		}

		@Override
		protected void onPostExecute(WisdomDb result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			random1 =WisdomDb.getRandom();
			random2 =WisdomDb.getRandom();
			random3 =WisdomDb.getRandom();
			random4 =WisdomDb.getRandom();
			random5 =WisdomDb.getRandom();
			String[] wisdoms = {random1,random2,random3,random4,random5};
			for(int i=0;i<mQuotesPerview.getValue();i++){
				value[valueCounter] =wisdoms[counter];
				counter++;
				valueCounter++;
			}
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.settings);

		// create UI Elements
		randomButton = (ToggleButton) findViewById(R.id.randomButton);
		doneButton = (Button) findViewById(R.id.doneButton);
		mQuotesPerview = (NumberPicker) findViewById(R.id.numberPicker1);
		mQuotesPerview.setMaxValue(5);
		mQuotesPerview.setMinValue(1);
		mQuotesPerview.setValue(2);
		AsyncTask<String, Void, WisdomDb> task = new DownloadWisdom();
		task.execute("");
		randomButton.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				if (isChecked) {
					finishSettings();
				}

			}
		});
	}

	private void finishSettings() {
		doneButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent returnIntent = new Intent();
				String value1 = value[0];
				String value2 = value[1];
				String value3 = value[2];
				String value4 = value[3];
				String value5 = value[4];
				
				if(value1 != null){
					returnIntent.putExtra("Quotes1", value1);
				}
				
				if(value2 != null){
					returnIntent.putExtra("Quotes2", value2);
				}
				
				if(value3 != null){
					returnIntent.putExtra("Quotes3", value3);
				}
				
				if(value4 != null){
					returnIntent.putExtra("Quotes4", value4);
				}
				
				if(value5 != null){
					returnIntent.putExtra("Quotes5", value5);
				}
				
				setResult(RESULT_OK, returnIntent);
				finish();
			}
		});
	}
}
