package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class utils {
	static RequestSpecification req;
	ResponseSpecification resSpec;
	
	public static RequestSpecification baseRequest() throws IOException {
		
		if(req==null) {
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
	
		 req  = new RequestSpecBuilder().setBaseUri(getBaseUrl("baseUrl"))
				 .addFilter(RequestLoggingFilter.logRequestTo(log))
				 .addFilter(ResponseLoggingFilter.logResponseTo(log))
				 .addQueryParam("key", "qaclick123")
				 .setContentType(ContentType.JSON)
				 .build();
		 return req;
		}
		return req;
	}
	
	public ResponseSpecification baseResponse() throws FileNotFoundException {
	
		 resSpec = new ResponseSpecBuilder()
//				 .expectStatusCode(404)
				 
				 .expectContentType(ContentType.JSON)
				 .build();
			return resSpec;
	}
	
	public static String getBaseUrl(String url) throws IOException {
		FileInputStream inputFile = new FileInputStream("C:\\Users\\BUBAN LAHIRI\\eclipse-workspace\\ApiFramework\\src\\test\\java\\resources\\application.properties");
		Properties prop = new Properties();
		prop.load(inputFile);
		String baseUrl = prop.getProperty(url);
		return baseUrl;
	}
	
}
