package com.replace;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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

}
