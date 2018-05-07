package com.gb.design_pattern.creational_pattern;

interface Product_interface
{
	public void method();
}

class Product_A implements Product_interface
{
	public void method()
	{
		// TODO Auto-generated method stub
		System.out.print("A");
		return;
	}
}

class Product_B implements Product_interface
{

	public void method()
	{
		// TODO Auto-generated method stub
		System.out.print("B");
		return;
	}
}

public class Simple_Factory
{
	public static Product_interface getinstance(String s)
	{
		if (s.equals("A"))
		{
			return new Product_A();
		}
		else if(s.equals("B"))
		{
			return new Product_B();
		}
		else 
			return null;
		
	}
	public static void main(String []args)
	{
		Product_interface p_A = Simple_Factory.getinstance("A");
		Product_interface p_B = Simple_Factory.getinstance("B");
		
		p_A.method();
		p_B.method();
	}
}
