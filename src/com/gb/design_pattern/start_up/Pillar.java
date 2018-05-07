package com.gb.design_pattern.start_up;

public class Pillar
{
	Circle bottom;
	double height;
	public Pillar(Circle bottom, double height)
	{
		this.bottom = bottom;
		this.height = height;
	}
	public double getVolume()
	{
		return bottom.getArea()*height;
	}
}
