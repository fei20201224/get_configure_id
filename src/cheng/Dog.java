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
		
		System.out.println("Dog������:"+name);
		this.name = name;
	}
	public void setAge(int age)
	{
		System.out.println("Set����");
		this.age = age;
	}
	
	//ϣ���÷������й��ʻ��Ĺ��ܣ���Ҫ������Spring�����Ĺ��ʻ�֧��
	public void bark() {
		
		System.out.println("����Id��"+beanId);
		System.out.println(ctx.getMessage("bark",null,Locale.getDefault(Category.FORMAT)));
		
	}
	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException
	{
		
		System.out.println("--------------����setApplicationContext����--------------");
		this.ctx = arg0;
		
	}
	
	
	
	
	
	@Override
	public void setBeanName(String arg0)
	{
		// TODO Auto-generated method stub
		
		this.beanId = arg0;
	}
	
	
	public void init() {
		System.out.println("ģ������ݿ��һЩ������Դ....");
	}

	@Override
	public void afterPropertiesSet() throws Exception
	{
		
		System.out.println("���������һЩ������Դ.....");
	}
	
	
	public void close() {
		System.out.println("ģ��ر����ݿ�Ȼ�����Դ");
		System.out.println("-----close-----");
	}
	@Override
	public void destroy() throws Exception
	{
		System.out.println("ģ��ر�����Ȼ�����Դ");
		System.out.println("-----close-----");
	}
}
