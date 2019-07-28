package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BookStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_BOOK_BY_ISBN = "https://itunes.apple.com";
	// private = null;

	@Given("user enter baseURL")
	public void a_book_exists_with_isbn() {
		RestAssured.baseURI = "https://itunes.apple.com";

	}

	@When("a user retrieves the book by isbn")
	public void a_user_retrieves_the_book_by_isbn() {
		;
		// response = given().when().get(ENDPOINT_GET_BOOK_BY_ISBN);
		response = given().when().queryParam("term", "jack+johnson").queryParam("entity", "musicVideo").get("/search");
		System.out.println("response: " + response.prettyPrint());
		System.out.println("response: " + response.statusCode());
	}

	@When("a user enter query perameter the details with \"(.*)\" and \"(.*)\"$")
	public void a_user_retrieves_the_book_by_isbn(String permeter1, String peraemter2) {
		response = given().when().queryParam("term", permeter1).queryParam("entity", peraemter2).get("/search");
		System.out.println("response: " + response.prettyPrint());
		System.out.println("response: " + response.statusCode());
	}

	@Then("Perform Put Operation")
	public void verify_status_code() {
		response = given().when().queryParam("term", "Hi").queryParam("entity", "Hello").put("/search");
	}

	@Then("the status code is (\\d+)")
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the following$")
	public void response_equals(Map<String, String> responseFields) {

		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			} else {
				json.body(field.getKey(), equalTo(field.getValue()));
			}

		}

	}


}
