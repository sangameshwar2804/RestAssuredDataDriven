package com.wbl.test;

import com.wbl.base.BaseTest;
import com.wbl.utils.ExcellUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class PostTest extends BaseTest {
@Test(dataProvider="data")
public void postData(String name,String role) {
	JSONObject params=new JSONObject();
	params.put("id", name);
	params.put("role", role);
	Response res=given().contentType(ContentType.JSON).body(params.toString()).when().post(endPoint+"/api/users");
System.out.println(res.statusCode());
System.out.println(res.getBody().asString());
}
@DataProvider(name="data")
String [][] getPostData() throws IOException{
//	String data[][]= {{"john","ui"},{"morphenus","qa"}}; 
	int rows=ExcellUtils.getRowCount(excell_Path, "Sheet1");
	int colos=ExcellUtils.getCellCount(excell_Path, "Sheet1", 1);
	String data[][]=new String[rows][colos];
	for(int i=1;i<=rows;i++) {
		for(int j=0;j<colos;j++) {
			data[i-1][j]=ExcellUtils.getCellData(excell_Path, "Sheet1", i, j);
		}
	}
	return data;
}
}
