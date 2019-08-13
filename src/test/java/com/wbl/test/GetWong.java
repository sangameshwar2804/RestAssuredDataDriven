package com.wbl.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.jayway.restassured.http.Method;
import com.wbl.base.BaseTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;

public class GetWong extends BaseTest {
	@Test
	public void getRequiredText() {

		Response response = given().contentType(ContentType.JSON).when().get(endPoint + "/api/users");
		JsonPath jsonPathEvaluator = response.jsonPath();

		ArrayList getLastName = (ArrayList) jsonPathEvaluator.get("data");

		Object obj = getLastName.get(2);
		String jsonStr = obj.toString();

		String onlyStr = jsonStr.replaceAll("[{} ]", "");

		String[] splitedArr = onlyStr.split(",");

		String oneKeyValue = splitedArr[0];

		String[] splitedkeyValue = oneKeyValue.split("=");

		String result = splitedkeyValue[1];

		System.out.println(result);

		Assert.assertEquals(result, "Wong");
	}
}
