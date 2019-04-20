package getrequestpackage;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetRequestClass {

	public static void main(String[] args) {
				  
		 RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
		 
		 RequestSpecification httpRequest = RestAssured.given(); 
	
		 Response response = httpRequest.request(Method.GET, "/Pune");
		 
		 System.out.println("Response Body is =>  " + response.getBody().asString());	
		 System.out.println(response.body().asString());
		 System.out.println("status code : "+response.getStatusCode());
		 System.out.println("status line :" + response.getStatusLine());
		 System.out.println("header content value : "+response.getHeader("Content-Type"));
		 System.out.println("content value : "+response.contentType());
		 System.out.println("content type : "+response.getContentType());
		 System.out.println("content server value :"+ response.getHeader("Server"));
		 System.out.println("content encoding :"+ response.getHeader("Content-Encoding"));
		 
		 Headers headerValue = response.getHeaders();
		 for(Header headervalue : headerValue)
		 {
			 System.out.println("<header name : "+headervalue.getName() + ">    <header value :"+ headervalue.getValue()+" >");
		 }
		 
		 JsonPath jsonpathevaluator = response.jsonPath();
		 System.out.println("City received from response : "+ jsonpathevaluator.get("City"));
		 System.out.println("Humidity received from response : "+ jsonpathevaluator.get("Humidity"));
		 

		 
		 
		 
		 
		 
		 
		 
		 
		 
	}
}