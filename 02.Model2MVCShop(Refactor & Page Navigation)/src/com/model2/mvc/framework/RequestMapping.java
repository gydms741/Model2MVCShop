package com.model2.mvc.framework;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


public class RequestMapping {
	
	///Field
	private static RequestMapping requestMapping;
	private Map<String, Action> map;
	private Properties properties;
	
	///Constructor
	private RequestMapping(String resources) {
		
		map = new HashMap<String, Action>();//property�� �����ؼ� �������� ��
		
		InputStream in = null;
		try{
			in = getClass().getClassLoader().getResourceAsStream(resources);//�׻� �������� ���ҽ� ��η� ���ҽ��� Ž���ϰ� �ȴ�.
			properties = new Properties();
			properties.load(in);//������ ��Ģ��θ� ������ �ۼ��ϸ� load()ȣ���ϴ� �͸����� ���� �����͸� ����� �� �ִ�. 
		}catch(Exception ex){
			System.out.println(ex);
			throw new RuntimeException("actionmapping.properties ���� �ε� ���� :"  + ex);
		}finally{
			if(in != null){
				try{ 
					in.close(); 
				} catch(Exception ex){ }
			}
		}
	} 
	
	///Method
	public synchronized static RequestMapping getInstance(String resources){
		//������ �޸� ���,getter setter���� ���� 
		if(requestMapping == null){
			requestMapping = new RequestMapping(resources);
		}
		return requestMapping;
	}
	
	public Action getAction(String path){//map����ΰ� ������ path key�� �ش��ϴ� value�� null
		
		Action action = map.get(path);
		
		if(action == null){
			
			String className = properties.getProperty(path);//value�� ������
			System.out.println("prop : " + properties);
			System.out.println("path : " + path);			
			System.out.println("className : " + className);
			className = className.trim();
			
			try{
				Class c = Class.forName(className);//path�� ���� value��, String��ü�ΰ� Class�� �������
				Object obj = c.newInstance();//����� �ɷ� �ν��Ͻ� ����. ������Ʈ��
				if(obj instanceof Action){//obj�� action���� ����ȯ �������� Ȯ��
					map.put(path, (Action)obj);
					action = (Action)obj;
				}else{
					throw new ClassCastException("Class����ȯ�� ���� �߻�  ");
				}
			}catch(Exception ex){
				System.out.println(ex);
				throw new RuntimeException("Action������ ���ϴ� ���� ���� �߻� : " + ex);
			}
		}
		return action;
	}
}