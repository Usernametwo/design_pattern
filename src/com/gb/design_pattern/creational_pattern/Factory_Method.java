package com.gb.design_pattern.creational_pattern;

public class Factory_Method
{
	public static void main(String []args)
	{
		Factory_interface fa = new Factory_A();
		Factory_interface fb = new Factory_B();
		
		Product_interface pa = fa.getinstance();
		Product_interface pb = fb.getinstance();
		
		pa.method();
		pb.method();
	}
}

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

interface Factory_interface
{
	public Product_interface getinstance();
}

class Factory_A implements Factory_interface
{
	public Product_interface getinstance()
	{
		// TODO Auto-generated method stub
		return new Product_A();
	}	
}

class Factory_B implements Factory_interface
{
	public Product_interface getinstance()
	{
		// TODO Auto-generated method stub
		return new Product_B();
	}	
}
