package services;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Arrays;

import org.apache.http.HttpStatus;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
//import io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
//import io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;



public class BookTests
{
	private static String ENDPOINT_GET_BOOK_BY_ISBN = "https://www.googleapis.com/books/v1/volumes";
	
	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;
	//@Test
	public void testGetByISBN(){
		String isbn = "isbn:9781451648546";

		given().
		param("q", isbn).
		when().
		get(ENDPOINT_GET_BOOK_BY_ISBN)
		.then().
		statusCode(HttpStatus.SC_BAD_REQUEST).
		body(	"totalItems", equalTo(1),
				"kind", equalTo("books#volumes"),
				"items.volumeInfo.title", containsInAnyOrder("Steve Jobs"),
				"items.volumeInfo.authors", containsInAnyOrder((Object)Arrays.asList("Walter Isaacson")),
				"items.volumeInfo.publisher", containsInAnyOrder("Simon and Schuster"),
				"items.volumeInfo.pageCount", containsInAnyOrder(630));
	}
	
	@Test
	public void testGetByISBN1(){
		String isbn = "isbn:9781451648546";
		RestAssured.baseURI = "https://itunes.apple.com";
		 given().when().queryParam("term", "jack+johnson").queryParam("entity", "musicVideo")
				 .get("/search").then().statusCode(200).body(	"resultCount", equalTo(13),
							//"kind", equalTo("books#volumes"),
							"results.wrapperType[1]", equalTo("trackdsdsdsds"));
						//	"items.volumeInfo.authors", containsInAnyOrder((Object)Arrays.asList("Walter Isaacson")),
							//"items.volumeInfo.publisher", containsInAnyOrder("Simon and Schuster"),
							//"items.volumeInfo.pageCount", containsInAnyOrder(630));
				}
	

		
		
	

}
