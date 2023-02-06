package com.anymind.points.entities;

import java.sql.Timestamp;

public interface ISalesAnalaytics {
	
	public int getPointsSum();
	public double getPriceSum();
	public Timestamp getDateHour();
	public void setPointSum(int points);
	public void setPriceSum(double sales);
	public void setDateHour(Timestamp dateHour);

}
