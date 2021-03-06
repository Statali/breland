package org.server.localshop.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

@Service
public class DateTime {

	
	public String  getCurrentDateTime(){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

		//Here you say to java the initial timezone. This is the secret
		sdf.setTimeZone(TimeZone.getTimeZone("WAT"));
		return sdf.format(calendar.getTime());
		/*
		System.out.println(sdf.format(calendar.getTime()));    

		//Here you set to your timezone
		sdf.setTimeZone(TimeZone.getDefault());
		//Will print on your default Timezone
		System.out.println(sdf.format(calendar.getTime()));*/
	}
}
