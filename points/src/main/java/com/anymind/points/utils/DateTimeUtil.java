package com.anymind.points.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtil {
	
	public static Timestamp getTimestampFromString  (String date, String format) throws ParseException {
		return new Timestamp(new SimpleDateFormat(format).parse(date).getTime());
	}
	public static String stringFormatTimestamp(Timestamp timestamp, String format) {
		return new SimpleDateFormat(format).format(new Date(timestamp.getTime()));
	}
}
