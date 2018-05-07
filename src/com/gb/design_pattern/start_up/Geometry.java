package com.gb.design_pattern.start_up;

abstract class Geometry
{
	public abstract double getArea();
}

class Circle extends Geometry
{
	double r;
	public Circle(double r)
	{
		this.r = r;
	}
	public double getArea()
	{
		// TODO Auto-generated method stub
		return 3.14*r*r;
	}
}

class Rectangle extends Geometry
{
	double bottom,height;
	public Rectangle(double bottom, double height)
	{
		this.bottom = bottom;
		this.height = height;
	}
	public double getArea()
	{
		// TODO Auto-generated method stub
		return 0.5*bottom*height;
	}
}


class Pillar
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
