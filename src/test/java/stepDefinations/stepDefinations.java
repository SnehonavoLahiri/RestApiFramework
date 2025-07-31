package stepDefinations;

import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pojo.DeletePlace;
import Pojo.GeoLocations;
import Pojo.LocationDetails;
import Pojo.Status;
import Pojo.message;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import payloads.AddPlacePayload;
import payloads.DeletePlacePayload;
import resources.Enums;
import resources.utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import org.apache.logging.log4j.message.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class stepDefinations extends utils{
	RequestSpecification  allReq,getReq,delReq;
	Response ress, getRes;
	String responseAsString,place_id;
	private String currentApi;
	private message ms;
	private Status status;
	Logger log = LoggerFactory.getLogger(stepDefinations.class);
	
@Given("User has Add place API with {string} {string} {string} {double} {double} {string} {string}")
public void user_has_add_place_api(String name, String phone, String address,double latitude, double longitude, String website, String language) throws IOException {
   
	AddPlacePayload app = new AddPlacePayload();
	
//	Compiling All Data into Objects and sending that Object as PAYLOAD

	allReq = given().spec(baseRequest()).body(app.AddPlace(name,phone,address,latitude,longitude,website,language));	
}


@When("User call {string} with http {string} request method")
public void user_call_add_place_api_with_http_post_request_method(String api,String method) throws IOException {
	
	currentApi = api;
	Enums en = Enums.valueOf(api);		
	String requiredApi = en.getApi();
delReq = given().spec(baseRequest());
	if (api.equalsIgnoreCase("addplace")) {
	    ress = allReq.when().post(requiredApi)
	                 .then().spec(baseResponse()).extract().response();

	    JsonPath js = new JsonPath(ress.asString());
	    place_id = js.getString("place_id");

	    log.info("Place ID is = " + place_id);

	} else if (api.equalsIgnoreCase("deleteplace")) {
		status = delReq.body(DeletePlacePayload.del(place_id))
	                 .when().delete(requiredApi)
	                 .then().spec(baseResponse()).extract().response().as(Status.class);
		log.info("Delete Operation Success.STATUS = "+status.getStatus());

	} else if (api.equalsIgnoreCase("getplace")) {
	    ms = allReq.queryParam("place_id", place_id).when().get(requiredApi)
	    		.then().spec(baseResponse()).extract().response().as(message.class);
	    log.info(ms.getMsg());

	} else if (api.equalsIgnoreCase("updateplace")) {
	    ress = allReq.when().put(requiredApi)
	                 .then().spec(baseResponse()).extract().response();
	}
}


@Then("{string} comes as {string}")
public void comes_as(String status, String code) {
	 responseAsString = ress.asString();
	 JsonPath js =  new JsonPath(responseAsString);
//	Assert.assertEquals(js.getString(status), code);

}

}
