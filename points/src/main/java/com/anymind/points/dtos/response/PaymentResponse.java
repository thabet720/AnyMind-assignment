package com.anymind.points.dtos.response;

public class PaymentResponse extends BaseResponse{
	private  double finalPrice;
	private int points;
	
	
	public PaymentResponse(double finalPrice, int points) {
		super();
		this.finalPrice = finalPrice;
		this.points = points;
	}
	public double getFinalPrice() {
		return finalPrice;
	}
	public void setFinalPrice(double finalPrice) {
		this.finalPrice = finalPrice;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	

}
