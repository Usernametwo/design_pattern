package com.gb.design_pattern.structural_pattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class proxy
{
	public static void main(String[] args)
	{
		//静态代理
		//目标对象
		IUserDao target = new UserDao();
		//代理对象
		IUserDao userDaoProxy = new UserDaoProxy(target);
		//执行方法
		userDaoProxy.save();
		
		
		
		//动态代理（这种动态代理还是需要提供接口）
        // 目标对象   
        IUserDao target_2 = new UserDao();
        // 【原始的类型 class com.gb.design_pattern.structural_pattern.UserDao】
        System.out.println(target_2.getClass());

        // 给目标对象，创建代理对象
        IUserDao proxy = (IUserDao) new ProxyFactory(target_2).getProxyInstance();
        // class com.gb.design_pattern.structural_pattern.$Proxy0   内存中动态生成的代理对象
        System.out.println(proxy.getClass());
        // 执行方法   【代理对象】
        proxy.save();
        
        //Cglib动态代理（这种动态代理无需实现任何的接口）
        
	}
}

//静态代理
interface IUserDao
{
	void save();
}

class UserDao implements IUserDao
{

	public void save()
	{
		// TODO Auto-generated method stub
		System.out.println("已保存数据");
	}
}

class UserDaoProxy implements IUserDao
{
	private IUserDao target;
	public UserDaoProxy(IUserDao iUserDao)
	{
		this.target = iUserDao;
	}
	public void save()
	{
		// TODO Auto-generated method stub
		System.out.println("开始事务");
		target.save();
		System.out.println("提交事务");
	}
}



//动态代理:不需要实现接口,但是需要指定接口类型
class ProxyFactory
{
    //维护一个目标对象
    private Object target;
    public ProxyFactory(Object target)
    {
        this.target=target;
    }

   //给目标对象生成代理对象   
    public Object getProxyInstance()
    {
    	//需要实现 static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces,InvocationHandler h)  方法
        return Proxy.newProxyInstance(
        		//指定当前目标对象使用类加载器,获取加载器的方法是固定的
                target.getClass().getClassLoader(),
                //目标对象实现的接口的类型,使用泛型方式确认类型
                target.getClass().getInterfaces(),
                new InvocationHandler() 
                {
                	//每一次执行目标对象的方法时,会触发事件处理器的方法,会把当前执行目标对象的方法作为参数传入
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable 
                    {
                        System.out.println("开始事务2");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("提交事务2");
                        return returnValue;
                    }
                }
        );
    }
}


