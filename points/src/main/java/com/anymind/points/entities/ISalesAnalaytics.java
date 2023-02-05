package com.anymind.points.entities;

import java.sql.Timestamp;

public interface ISalesAnalaytics {
	
	public int getPointsSum();
	public double getPriceSum();
	public Timestamp getDateHour();

}
