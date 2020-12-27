package org.cheng.spring;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.springframework.core.io.Resource;

public class InfoBean
{

	//Resouce�������Դ���������ڴ��̡����硢��·��
	private Resource res;
	private String charSet;
	public void readInfo() throws UnsupportedEncodingException, IOException {	
		BufferedReader br = 
	    new BufferedReader(new InputStreamReader(res.getInputStream(), charSet));
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}
	public void setRes(Resource res)
	{
		this.res = res;
	}
	public void setCharSet(String charSet)
	{
		this.charSet = charSet;
	}
   
	 
}
