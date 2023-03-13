package simpleToolRentalAPI;

import io.qameta.allure.Description;
import io.qameta.allure.Link;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import simpleToolRentalAPI.rest.ToolRentalAPI;
import simpleToolRentalAPI.rest.builder.ClientFactory;
import simpleToolRentalAPI.rest.builder.UpdatedOrderFactory;
import simpleToolRentalAPI.rest.builder.OrderFactory;
import simpleToolRentalAPI.utils.CsvDataProviders;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ToolRentalCrudTests {
    ToolRentalAPI api = new ToolRentalAPI();
    protected String authenticationToken = api.getAccessToken(ClientFactory.newDefaultClient());

    @Test(groups = {"status"})
    @Description("Verify if the response has the status which is equal to UP")
    @Link(name = "Link to the API Status", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Status")
    public void checkResponseOfGetStatus() {
        Response receivedStatus = api.getStatusSuccessful();
        Assertions.assertThat(receivedStatus.body().jsonPath().getString("status"))
                .as("Status must be equal to <UP>")
                .isEqualTo("UP");
    }

    @Test(groups = {"status"})
    @Description("Verify if a response has status code which is equal to 200")
    @Link(name = "Link to the API Status", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Status")
    public void checkStatus() {
        Response receivedStatus = api.getStatus();
        Assertions.assertThat(receivedStatus.statusCode())
                .as("Status must be equal to 200")
                .isEqualTo(HttpStatus.SC_OK);
    }

    @Test(groups = {"tools"})
    @Description("Verify if a response has status code which is equal to 200")
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void checkGetAllTools() {
        Response receivedTools = api.getAllTools();
        Assertions.assertThat(receivedTools.statusCode())
                .as("Status must be equal to 200")
                .isEqualTo(HttpStatus.SC_OK);
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    @Description("Verify if the response has required category")
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void checkGetToolsByCategory(Map<String, String> testData) {
        String category = testData.get("category");
        Response receivedTools = api.getToolsByCategorySuccessful(category);
        Assertions.assertThat(receivedTools.body().jsonPath().getString("category")
                .equals(category));
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    @Description("Verify the results' count with valid data")
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void positiveCheckResultsCount(Map<String, String> testData) {
        int value = Integer.parseInt(testData.get("value"));
        List<JsonPath> results = api.getToolsByNumberOfResultsSuccessful(value)
                .jsonPath()
                .getList("category");
        assertThat(results.size(), equalTo(value));
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    @Description("Verify the results' count with invalid data")
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void negativeCheckResultsCount(Map<String, String> testData) {
        int value = Integer.parseInt(testData.get("value"));
        Response receivedTools = api.getToolsByNumberOfResults(value);
        Assertions.assertThat(receivedTools.statusCode())
                .as("Status must be equal to 400")
                .isEqualTo(HttpStatus.SC_BAD_REQUEST);
    }

    @Test(groups = {"tools"})
    @Description("Verify the getting single tool ability")
    @Link(name = "Link to the API Get the single tool", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-a-single-tool")
    public void checkGettingSingleToolById() {
        Response getAllTools = api.getAllToolsSuccessful();
        List<Object> id = getAllTools.jsonPath().getList("id");
        System.out.println(id);
        for(int i = 0; i < id.size(); i++){
            Response getSingleTool = api.getSingleTool((Integer) id.get(i));
            Assertions.assertThat(getSingleTool.statusCode())
                    .as("Status must be equal to 200")
                    .isEqualTo(HttpStatus.SC_OK);
        }
    }

    @Test(groups = {"orders"})
    @Description("Verify adding a new order")
    @Link(name = "Link to the Get a single order", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-a-single-order")
    public void addNewOrder() {
        Response newOrder = api.addOrderSuccessful(authenticationToken, OrderFactory.newDefaultOrder());
        String newOrderId = newOrder.jsonPath().getString("orderId");
        Response orderTakenById = api.getOrderByIdSuccessful(authenticationToken, newOrderId);
        String actualId = orderTakenById.jsonPath().get("id");
        Assertions.assertThat(newOrderId
                .equals(actualId));
    }


    @Test(groups = {"orders"})
    @Description("Verify if the response of 'GET all orders' is equal to 200")
    @Link(name = "Link to the Get all orders", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-orders")
    public void getAllOrders() {
        Response response = api.getAllOrders(authenticationToken);
        Assertions.assertThat(response.statusCode())
                .as("Status must be equal to 200")
                .isEqualTo(HttpStatus.SC_OK);
    }

    @Test(groups = {"orders"})
    @Description("Verify if the response of 'Update Order' is equal to 204")
    @Link(name = "Update an order", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Update-an-order")
    public void updateOrder() {
        Response newOrder = api.addOrderSuccessful(authenticationToken,OrderFactory.newDefaultOrder());
        String newOrderId = newOrder.jsonPath().getString("orderId");
        Response response = api.modifyOrder(authenticationToken, newOrderId, UpdatedOrderFactory.modifiedOrder());
        Assertions.assertThat(response.statusCode())
                .as("Status must be equal to 204")
                .isEqualTo(HttpStatus.SC_NO_CONTENT);

    }

    @Description("Verify if the response of getting the deleted order is equal to 404")
    @Test(groups = {"orders"})
    public void checkIfOrderIsDeleted() {
        Response newOrder = api.addOrderSuccessful(authenticationToken,OrderFactory.newDefaultOrder());
        String newOrderId = newOrder.jsonPath().getString("orderId");
        api.deleteOrderSuccessful(authenticationToken,newOrderId);
        Response response = api.getOrderById(authenticationToken,newOrderId);
        Assertions.assertThat(response.statusCode())
                .as("Status must be equal to 404")
                .isEqualTo(HttpStatus.SC_NOT_FOUND);
    }
}
