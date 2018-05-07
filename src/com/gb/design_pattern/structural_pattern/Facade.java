package com.gb.design_pattern.structural_pattern;

public class Facade
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		facade facade = new facade();
		facade.dosomething();
	}

}

class SystemA
{
	public void operation_1()
	{
		System.out.println("start SystemA");
	}
}



class SystemB
{
	public void operation_2()
	{
		System.out.println("start SystemB");
	}
}


class facade
{
	private SystemA systemA;
	private SystemB systemB;
	public facade()
	{
		systemA = new SystemA();
		systemB = new SystemB();
	}
	public void dosomething()
	{
		systemA.operation_1();
		systemB.operation_2();
	}
}