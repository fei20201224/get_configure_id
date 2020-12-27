package cheng;

import java.util.Locale;
import java.util.Locale.Category;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Dog implements ApplicationContextAware,BeanNameAware,InitializingBean,DisposableBean
{
	private String name;
	private int age;
	private ApplicationContext ctx;
	private String beanId;
	
	
	public String getBeanId()
	{
		return beanId;
	}
	public Dog(String name)
	{
		
		System.out.println("Dog构造器:"+name);
		this.name = name;
	}
	public void setAge(int age)
	{
		System.out.println("Set方法");
		this.age = age;
	}
	
	//希望该方法具有国际化的功能，需要借助于Spring容器的国际化支持
	public void bark() {
		
		System.out.println("配置Id是"+beanId);
		System.out.println(ctx.getMessage("bark",null,Locale.getDefault(Category.FORMAT)));
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException
	{
		
		System.out.println("--------------调用setApplicationContext方法--------------");
		this.ctx = arg0;
		
	}
	
	
	
	
	
	@Override
	public void setBeanName(String arg0)
	{
		// TODO Auto-generated method stub
		
		this.beanId = arg0;
	}
	
	
	public void init() {
		System.out.println("模拟打开数据库等一些基础资源....");
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		
		System.out.println("配置网络等一些基础资源.....");
	}
	
	
	public void close() {
		System.out.println("模拟关闭数据库等基础资源");
		System.out.println("-----close-----");
	}
	@Override
	public void destroy() throws Exception
	{
		System.out.println("模拟关闭网络等基础资源");
		System.out.println("-----close-----");
	}
}
