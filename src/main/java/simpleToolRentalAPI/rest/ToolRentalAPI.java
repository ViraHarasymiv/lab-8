package simpleToolRentalAPI.rest;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import simpleToolRentalAPI.rest.model.Client;
import simpleToolRentalAPI.rest.model.ModifiedOrder;
import simpleToolRentalAPI.rest.model.Order;
import simpleToolRentalAPI.utils.Endpoint;
import simpleToolRentalAPI.utils.PropertyLoader;

public class ToolRentalAPI extends AbstractApi{

    /**
     Get the successful status of the API
     * @Vira_Harasymiv
     */
    @Step
    public Response getStatusSuccessful(){
        Response res = getClient()
                .when()
                .get(Endpoint.STATUS_URI)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return res;
    }

    /**
     Get the status of the API
     * @Vira_Harasymiv
     */
    @Step
    public Response getStatus() {
        Response res = getClient()
                .when()
                .get(Endpoint.STATUS_URI)
                .then()
                .log().all()
                .extract().response();
        return res;
    }

    /**
     Get all tools
     * @Vira_Harasymiv
     */
    @Step
    public Response getAllTools(){
        Response res = getClient()
                .get(Endpoint.TOOLS_URI)
                .then()
                .log().all()
                .extract().response();
        return res;
    }

    /**
     Get all tools successful
     * @Vira_Harasymiv
     */
    @Step
    public Response getAllToolsSuccessful(){
        Response res = getClient()
                .get(Endpoint.TOOLS_URI)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return res;
    }

    /**
     Get tools by the category successful
     * @Vira_Harasymiv
     */
    @Step
    public Response getToolsByCategorySuccessful(String category){
        Response res = getClient()
                .queryParam("category",category)
                .when()
                .get(Endpoint.TOOLS_URI)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return res;
    }

    /**
     Get tools by the number of results successful.
     Must be number between 1 and 20. By default, only 20 tools will be displayed
     * @Vira_Harasymiv
     */
    @Step
    public Response getToolsByNumberOfResultsSuccessful(int value){
        Response res = getClient()
                .queryParam("results",value)
                .when()
                .get(Endpoint.TOOLS_URI)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return res;
    }

    /**
     Get tools by the number of results.
     Must be number between 1 and 20. By default, only 20 tools will be displayed
     * @Vira_Harasymiv
     */
    @Step
    public Response getToolsByNumberOfResults(int value){
        Response res = getClient()
                .queryParam("results",value)
                .when()
                .get(Endpoint.TOOLS_URI)
                .then()
                .log().all()
                .extract().response();
        return res;
    }

    /**
     Get a single tool from the inventory
     * @Vira_Harasymiv
     */
    @Step
    public Response getSingleTool(int id){
        Response res = getClient()
                .pathParam("id",id)
                .get(Endpoint.TOOLS_ID)
                .then()
                .log().all()
                .extract().response();
        return res;
    }

    /**
     Register a new API client successful and get a new token
     * @Vira_Harasymiv
     */
    @Step
    public String getAccessToken(Client client){
        Response response = getClient()
                .body(client)
                .post(Endpoint.CLIENT)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
        return response.jsonPath().get("accessToken");

    }

    /**
     Returns all orders created by the API client
     * @Vira_Harasymiv
     */
    @Step
    public Response getAllOrders(String token){
        Response res = getClient()
                .auth()
                .oauth2(token)
                .when()
                .get(Endpoint.ORDER)
                .then()
                .log().all()
                .extract().response();
        return res;
    }

    /**
     Create a new order successful
     * @Vira_Harasymiv
     */
    @Step
    public Response addOrderSuccessful(String token, Order order){
        Response res = getClient()
                .auth()
                .oauth2(token)
                .body(order)
                .when()
                .post(Endpoint.ORDER)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_CREATED)
                .extract()
                .response();
        return res;
    }

    /**
     Get a single order by id successful
     * @Vira_Harasymiv
     */
    @Step
    public Response getOrderByIdSuccessful(String token, String orderId){
        Response res = getClient()
                .auth()
                .oauth2(token)
                .when()
                .pathParam("orderId", orderId)
                .get(Endpoint.ORDER_ID)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .extract().response();
        return res;
    }

    /**
     Get a single order by id
     * @Vira_Harasymiv
     */
    @Step
    public Response getOrderById(String token, String orderId){
        Response res = getClient()
                .auth()
                .oauth2(token)
                .when()
                .pathParam("orderId", orderId)
                .get(Endpoint.ORDER_ID)
                .then()
                .log().all()
                .assertThat()
                .extract().response();
        return res;
    }

    /**
     Update an order
     * @Vira_Harasymiv
     */
    @Step
    public Response modifyOrder(String token, String orderId, ModifiedOrder modifiedOrder){
        Response res = getClient()
                .auth()
                .oauth2(token)
                .body(modifiedOrder)
                .when()
                .pathParam("orderId", orderId)
                .patch(Endpoint.ORDER_ID)
                .then()
                .log().all()
                .extract().response();
        return res;
    }

    /**
     Delete an order successful
     * @Vira_Harasymiv
     */
    @Step
    public Response deleteOrderSuccessful(String token, String orderId){
        Response res = getClient()
                .auth()
                .oauth2(token)
                .when()
                .pathParam("orderId",orderId)
                .delete(Endpoint.ORDER_ID)
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT)
                .extract().response();
        return res;
    }
    @Override
    protected RequestSpecification getClient() {
        return RestClientFactory.getClient(PropertyLoader.getProperty("baseUrl"));
    }
}
