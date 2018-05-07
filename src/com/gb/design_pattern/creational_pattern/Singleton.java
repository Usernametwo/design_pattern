package com.gb.design_pattern.creational_pattern;

public class Singleton
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

//懒汉，线程不安全
class Singleton_1
{
	private Singleton_1()
	{}
	private static Singleton_1 s1 = null;
	public static Singleton_1 getInstance()
	{
		if(s1 == null)
		{
			s1 = new Singleton_1();
		}
		return s1;
	}
}

//懒汉，线程安全，加锁之后会影响效率
class Singleton_2
{
	private Singleton_2()
	{}
	private static Singleton_2 s2 = null;
	public static synchronized Singleton_2 getInstance()
	{
		if(s2 == null)
		{
			s2 = new Singleton_2();
		}
		return s2;
	}
}

//饿汉,利用classloader机制避免了线程同步问题，没有加锁之后影响效率的问题，但是浪费内存
class Singleton_3
{
	private static Singleton_3 s3 = new Singleton_3();
	private Singleton_3()
	{}
	public static Singleton_3 getInstance()
	{
		return s3;
	}
}

//双检锁/双重校验锁,懒加载，而且线程安全，并且只是在进行实例化的时候加锁，效率影响不大   （JDK1.5以上才能用）

class Singleton_4
{
	private Singleton_4()
	{}
	private volatile static Singleton_4 s4 = null;
	public static Singleton_4 getInstance()
	{
		if(s4 == null)
		{
			synchronized (Singleton_4.class)
			{
				if(s4 == null) 
				{
					s4 = new Singleton_4();
				}
			}
		}
		return s4;
	}
}

//登记式/静态内部类   这种方式同样利用了 classloder 机制来保证初始化 instance 时只有一个线程，同时它还是懒加载的方式
class Singleton_5
{
	private Singleton_5()
	{}
	private static class SingletonHolder
	{
		private final static Singleton_5 s5 = new Singleton_5();
	}
	public static final Singleton_5 getInstance() 
	{
		return SingletonHolder.s5;
	}
}

//枚举  它不仅能避免多线程同步问题，而且还自动支持序列化机制，防止反序列化重新创建新的对象，绝对防止多次实例化。 由于 JDK1.5 之后才加入 enum 特性，用这种方式写让人感觉生疏。
enum Singleton_6
{
	INSTANCE;
	public void otherMethod() 
	{
		System.out.println("something");
	}
}

