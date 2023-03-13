package simpleToolRentalAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ToolRentalCrudTests {
    String baseUrl = "https://simple-tool-rental-api.glitch.me";

    @Test(groups = {"status"})
    public void checkStatus(){
        String endpoint = "/status";
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = {"status"})
    public void checkResponseOfGetStatus() {
        String endpoint = "/status";
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .extract().response();
        Assertions.assertThat(response.body().jsonPath().getString("status"))
                .as("Status must be equal to <UP>")
                .isEqualTo("UP");
    }

}
