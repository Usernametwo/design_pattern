package com.gb.design_pattern.creational_pattern;

interface Product_A_interface
{
	public void method();
}

interface Product_B_interface
{
	public void method();
}

class Product_A1 implements Product_A_interface
{
	public void method()
	{
		System.out.print("A1");
	}
}

class Product_A2 implements Product_A_interface
{
	public void method()
	{
		System.out.print("A2");
	}
}

class Product_B1 implements Product_B_interface
{
	public void method()
	{
		System.out.print("B1");
	}
}

class Product_B2 implements Product_B_interface
{
	public void method()
	{
		System.out.print("B2");
	}
}

interface Factory_interface
{
	public Product_A_interface create_Product_A();
	public Product_B_interface create_Product_B();
}

class Factory_1 implements Factory_interface
{
	public Product_A_interface create_Product_A()
	{
		// TODO Auto-generated method stub
		return new Product_A1();
	}

	public Product_B_interface create_Product_B()
	{
		// TODO Auto-generated method stub
		return new Product_B1();
	}
}

class Factory_2 implements Factory_interface
{
	public Product_A_interface create_Product_A()
	{
		// TODO Auto-generated method stub
		return new Product_A2();
	}

	public Product_B_interface create_Product_B()
	{
		// TODO Auto-generated method stub
		return new Product_B2();
	}
}

public class Abstract_Factory
{
	public static void main(String[] args)
	{
		Factory_interface fi1 = new Factory_1();
		Factory_interface fi2 = new Factory_2();
	
		Product_A_interface pa1 = fi1.create_Product_A();
		Product_B_interface pb1 = fi1.create_Product_B();
	
		Product_A_interface pa2 = fi2.create_Product_A();
		Product_B_interface pb2 = fi2.create_Product_B();
	
		pa1.method();
		pb1.method();
		pa2.method();
		pb2.method();
	
	}
}

