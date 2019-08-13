package com.wbl.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
	
public static Properties loadPro(String fileName) {
	Properties pro=new Properties();
	try {
		pro.load(new FileInputStream(Constants.Resources_path+fileName));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return pro;
}
}
