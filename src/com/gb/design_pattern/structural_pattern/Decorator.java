package com.gb.design_pattern.structural_pattern;

public class Decorator
{
	public static void main(String[] args)
	{
		Component concreteComponent = new ConcreteComponent();
		Component decorator_1 = new decorator_1(concreteComponent);
		decorator_1.operation();
		Component decorator_2 = new decorator_2(decorator_1);
		decorator_2.operation();
		
	}
}


interface Component
{
	public int operation();
}


class ConcreteComponent implements Component
{

	public int operation()
	{
		// TODO Auto-generated method stub
		System.out.println("1");
		return 1;
	}
	
}


class decorator_1 implements Component
{

	private Component component;
	public decorator_1(Component component)
	{
		this.component = component;
	}
	public int operation()
	{
		// TODO Auto-generated method stub
		System.out.println("2");
		return component.operation() + 1;
	}	
}


class decorator_2 implements Component
{

	private Component component;
	public decorator_2(Component component)
	{
		this.component = component;
	}
	public int operation()
	{
		// TODO Auto-generated method stub
		System.out.println("3");
		return component.operation() + 1;
	}	
}