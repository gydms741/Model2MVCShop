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
		
		map = new HashMap<String, Action>();//property랑 대조해서 가져오는 것
		
		InputStream in = null;
		try{
			in = getClass().getClassLoader().getResourceAsStream(resources);//항상 절대적인 리소스 경로로 리소스를 탐색하게 된다.
			properties = new Properties();
			properties.load(in);//정해진 규칙대로만 파일을 작성하면 load()호출하는 것만으로 쉽게 데이터를 물어올 수 있다. 
		}catch(Exception ex){
			System.out.println(ex);
			throw new RuntimeException("actionmapping.properties 파일 로딩 실패 :"  + ex);
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
		//고정된 메모리 사용,getter setter같은 느낌 
		if(requestMapping == null){
			requestMapping = new RequestMapping(resources);
		}
		return requestMapping;
	}
	
	public Action getAction(String path){//map에경로가 들어오면 path key에 해당하는 value는 null
		
		Action action = map.get(path);
		
		if(action == null){
			
			String className = properties.getProperty(path);//value값 가져와
			System.out.println("prop : " + properties);
			System.out.println("path : " + path);			
			System.out.println("className : " + className);
			className = className.trim();
			
			try{
				Class c = Class.forName(className);//path에 대한 value값, String자체인걸 Class로 만들어줘
				Object obj = c.newInstance();//선언된 걸로 인스턴스 생성. 오브젝트로
				if(obj instanceof Action){//obj가 action으로 형변환 가능한지 확인
					map.put(path, (Action)obj);
					action = (Action)obj;
				}else{
					throw new ClassCastException("Class형변환시 오류 발생  ");
				}
			}catch(Exception ex){
				System.out.println(ex);
				throw new RuntimeException("Action정보를 구하는 도중 오류 발생 : " + ex);
			}
		}
		return action;
	}
}