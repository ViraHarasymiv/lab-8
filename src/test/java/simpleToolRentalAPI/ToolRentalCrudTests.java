package simpleToolRentalAPI;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import simpleToolRentalAPI.entities.Client;
import simpleToolRentalAPI.entities.ModifiedOrder;
import simpleToolRentalAPI.entities.Order;
import simpleToolRentalAPI.utils.CsvDataProviders;
import simpleToolRentalAPI.utils.GeneratorUtils;
import java.util.List;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ToolRentalCrudTests {
    String baseUrl = "https://simple-tool-rental-api.glitch.me";
    protected String authenticationToken = getAccessToken();

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
                .assertThat()
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

    @Test(groups = {"tools"})
    public void checkGetAllTools(){
        String endpoint = "/tools";
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void checkGetToolsByCategory(Map<String, String> testData) {
        String endpoint = "/tools";
                String category = testData.get("category");
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .queryParam("category", category)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        Assertions.assertThat(response.body().jsonPath().getString("category")
                .equals(category));
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void positiveCheckResultsCount(Map<String, String> testData) {
        int value = Integer.parseInt(testData.get("value"));
        String endpoint = "/tools";
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .queryParam("results",value)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        List<JsonPath> results = response.jsonPath().getList("category");
        assertThat(results.size(), equalTo(value));
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    public void negativeCheckResultsCount(Map<String, String> testData) {
        int value = Integer.parseInt(testData.get("value"));
        String endpoint = "/tools";
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .queryParam("results",value)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test(groups = {"tools"})
    public void checkGettingSingleToolById(){
        String tools_id = "/tools/{id}";
        Response getAllTools = getAllToolsSuccessful();
        List<Object> id = getAllTools.jsonPath().getList("id");
        for(int i = 0; i < id.size(); i++) {
            given()
                    .baseUri(baseUrl)
                    .contentType(ContentType.JSON)
                    .log().all()
                    .accept(ContentType.JSON)
                    .pathParam("id", id.get(i))
                    .get(tools_id)
                    .then()
                    .log().all()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK);
        }
    }

    public Response getAllToolsSuccessful(){
        String endpoint = "/tools";
        return given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
    }

    @Test(groups = {"orders"})
    public void getOrderById(){
        String endpoint = "/orders/{orderId}";
        String newOrderId = getNewOrderId();
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .auth()
                .oauth2(authenticationToken)
                .when()
                .pathParam("orderId", newOrderId)
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        String actualId = response.jsonPath().get("id");
        Assertions.assertThat(newOrderId
                .equals(actualId));
    }

    @Test(groups = {"orders"})
    public void getAllOrders(){
        String endpoint = "/orders";
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .auth()
                .oauth2(authenticationToken)
                .when()
                .get(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);

    }

    @Test(groups = {"orders"})
    public void updateOrder() {
        String endpoint = "/orders/{orderId}";
        String newOrderId = getNewOrderId();
        ModifiedOrder modifiedOrder = new ModifiedOrder(GeneratorUtils.generateName(), GeneratorUtils.generateComment());
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .auth()
                .oauth2(authenticationToken)
                .body(modifiedOrder)
                .when()
                .pathParam("orderId", newOrderId)
                .patch(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);

    }

    @Test(groups = {"orders"})
    public void deleteOrder(){
        String endpoint = "/orders/{orderId}";
        String newOrderId = getNewOrderId();
        given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .auth()
                .oauth2(authenticationToken)
                .when()
                .pathParam("orderId",newOrderId)
                .delete(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_NO_CONTENT);    }

    public String getNewOrderId(){
        String endpoint = "/orders";
        Order newOrder = new Order(4643, GeneratorUtils.generateName(), GeneratorUtils.generateComment());
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .auth()
                .oauth2(authenticationToken)
                .body(newOrder)
                .when()
                .post(endpoint)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .extract().response();
        return response.jsonPath().getString("orderId");
    }

    public String getAccessToken(){
        String endpoint = "/api-clients";
        Client newClient = new Client(GeneratorUtils.generateName(),GeneratorUtils.generateEmail());
        Response response = given()
                .baseUri(baseUrl)
                .contentType(ContentType.JSON)
                .log().all()
                .accept(ContentType.JSON)
                .body(newClient)
                .post(endpoint)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
        return response.jsonPath().get("accessToken");
    }
}
