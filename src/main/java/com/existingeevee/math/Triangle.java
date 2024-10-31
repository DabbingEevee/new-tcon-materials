package com.existingeevee.math;

public class Triangle {
	
	public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
		this.x3 = x3;
		this.y3 = y3;
		this.y23 = y2 - y3;
		this.x32 = x3 - x2;
		this.y31 = y3 - y1;
		this.x13 = x1 - x3;
		this.det = y23 * x13 - x32 * y31;
		this.minD = Math.min(det, 0);
		this.maxD = Math.max(det, 0);
	}

	public boolean contains(double x, double y) {
		if (det <= 0)
			return false;
		
		double dx = x - x3;
		double dy = y - y3;
		
		double a = y23 * dx + x32 * dy;
		if (a < minD || a > maxD)
			return false;
		
		double b = y31 * dx + x13 * dy;
		if (b < minD || b > maxD)
			return false;
		
		double c = det - a - b;
		if (c < minD || c > maxD)
			return false;
		
		return true;
	}

	private final double x3, y3;
	private final double y23, x32, y31, x13;
	private final double det, minD, maxD;
}