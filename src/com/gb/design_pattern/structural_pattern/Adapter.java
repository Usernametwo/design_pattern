package com.gb.design_pattern.structural_pattern;

public class Adapter implements Target
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		//对象适配器
		Adaptee adaptee = new Adaptee();
		Target target = new Adapter(adaptee);
		target.request();
		
		
		//类适配器
		Target adapter_2 = new Adapter_2();
		adapter_2.request();
	}
	
	private Adaptee adaptee;
	public Adapter(Adaptee adaptee)
	{
		// TODO Auto-generated constructor stub
		this.adaptee = adaptee;
	}
	public void request() 
	{
		adaptee.request();
	}
}

interface Target
{
	public void request();
}

class Adaptee
{
	public void request() 
	{
		System.out.println("this is real request from Adaptee");
	}
}

//类适配器
class Adapter_2 extends Adaptee implements Target
{
	
	public void request()
	{
		// TODO Auto-generated method stub
		super.request();
	}
	
}