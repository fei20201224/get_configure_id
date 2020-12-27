package cheng;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.Locale.Category;

import org.cheng.spring.InfoBean;
import org.springframework.cglib.core.Local;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain
{

	public static void main(String[] args) 
	throws UnsupportedEncodingException, IOException
	{
		
		AbstractApplicationContext ctx = 
		new ClassPathXmlApplicationContext(new String[] {"beans.xml","beans2.xml"});
		ctx.registerShutdownHook();  //×¢²á¹Ø±Õ¹³×Ó
//		InfoBean infoBean =  ctx.getBean("infoBean",InfoBean.class);
//		infoBean.readInfo();
		
		System.out.println("--------------------");
		Dog dog = ctx.getBean("@_@",Dog.class);
		dog.bark();
	}

}
