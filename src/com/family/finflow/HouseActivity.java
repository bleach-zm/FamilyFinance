package com.family.finflow;

import com.family.dataes.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class HouseActivity extends Activity {
	
	private Date today;
	private Date week;
	private Date month;
	
	private float balance;
	private float incomeNo,inweek,inmonth;
	private float payNo,payweek,paymonth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.house);
		changedate();
	}
	
	// sql 返回值展示
	private void changedate(){
		final TextView today = (TextView)findViewById(R.id.today);
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
			today.setText(sdf.format(new Date()));
		final TextView balance = (TextView)findViewById(R.id.balance);
			
		
	}

	
	

}
