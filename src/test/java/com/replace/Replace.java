package com.replace;

import com.wch.entity.User;
import com.wch.utils.BeanMapper;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Replace
{
	
	public void replaceToConcat(String path) throws Exception
	{
		File file = new File(path);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader reader = new BufferedReader(isr);
		String temp = null;
	    while(null != (temp = reader.readLine()))
	    {
	    	
	    }
	}

	@Test
	public void testBeanMapper() {
		BeanMapper mapper = new BeanMapper();
		System.out.println(mapper.convertCharToUpperCase(0, "helloWorld"));
	}

	@Test
	public void testObjecttoMap() {
		User user = new User();
		user.setUsername("CalvinWang");
		Map<String, Object> users = BeanMapper.objectToMap(user);
		String key = null;
		for(Iterator<String> iter = users.keySet().iterator(); iter.hasNext();) {
			key = iter.next();
			System.out.println(key + ":" + users.get(key));
		}
	}

	@Test
	public void testMapToObject() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("username", "CalvinWang");
		params.put("age", 20);
		User user = (User)BeanMapper.mapToObject(params, User.class);
		System.out.println("username: " + user.getUsername());
		System.out.println("age: " + user.getAge());
	}

}
