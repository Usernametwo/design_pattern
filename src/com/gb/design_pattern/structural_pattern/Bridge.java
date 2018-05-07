package com.gb.design_pattern.structural_pattern;


public class Bridge
{
	public static void main(String[] args)
	{
		MySQLDeiver mySQLDeiver = new MySQLDeiver();
		MyDriverManager myDriverManager = new MyDriverManager(mySQLDeiver);
		myDriverManager.connect();
		
		OracleDriver oracleDriver = new OracleDriver();
		MyDriverManager myDriverManager2 = new MyDriverManager(oracleDriver);
		myDriverManager2.connect();
		
	}
}


interface Driver
{
	public void connect();
}


class MySQLDeiver implements Driver
{

	public void connect()
	{
		// TODO Auto-generated method stub
		System.out.println("MySQL connected");
	}
}

class OracleDriver implements Driver
{

	public void connect()
	{
		// TODO Auto-generated method stub
		System.out.println("Oracle connected");
	}
	
}

abstract class DriverManager
{
	private Driver driver;
	public DriverManager(Driver driver)
	{
		this.driver = driver;
	}
	public void connect() 
	{
		driver.connect();
	}
}

class MyDriverManager extends DriverManager
{
	public MyDriverManager(Driver driver)
	{
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void connect()
	{
		super.connect();
	}
}


