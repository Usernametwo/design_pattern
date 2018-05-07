package com.gb.design_pattern.creational_pattern;

public class Builder
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		Director director = new Director(new ConcreteBuilder());
		Product product = director.construct();
	}

}

class Product
{
	public int part_A = 0;
	public int part_B = 0;
	void method()
	{
		System.out.print("Product builded");
	}
}

interface builder
{
	public void buildPartA();
	public void buildPartB();
	public Product getResult();
}

class ConcreteBuilder implements builder
{
	private Product product = new Product();
	public void buildPartA()
	{
		product.part_A = 1;
		System.out.println("part A buildered");
	}
	public void buildPartB()
	{
		product.part_B = 2;
		System.out.println("part B buildered");
	}
	public Product getResult()
	{
		return null;
	}
}

class Director
{
	private builder b = null;
	public Director(builder b)
	{
		this.b = b;
	}
	public Product construct()
	{
		b.buildPartA();
		b.buildPartB();
		return b.getResult();
	}
}