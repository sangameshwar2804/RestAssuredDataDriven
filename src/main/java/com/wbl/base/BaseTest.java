package com.wbl.base;

import java.util.Properties;

import org.testng.annotations.BeforeTest;

import com.wbl.utils.ConfigUtils;
import com.wbl.utils.Constants;

public class BaseTest {
	protected String endPoint;
	protected String excell_Path=Constants.Resources_path+"/RestPost.xlsx";
@BeforeTest
public void beforeTest() {
Properties pro=ConfigUtils.loadPro("config.properties");
endPoint=pro.getProperty("url");
}
}
