package com.gb.design_pattern.start_up;

public class parent
{
	public void cry()
	{
		System.out.print("cry");
	}
	public static void main(String []args)
	{
		parent c = new child();
		c.cry();
	}
}

class child extends parent
{
	public void smile()
	{
		System.out.print("smile");
	}
}