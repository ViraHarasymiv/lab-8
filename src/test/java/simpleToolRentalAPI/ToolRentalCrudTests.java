package simpleToolRentalAPI;

import io.qameta.allure.Link;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import simpleToolRentalAPI.rest.ToolRentalAPI;
import simpleToolRentalAPI.rest.builder.ClientFactory;
import simpleToolRentalAPI.rest.builder.UpdatedOrderFactory;
import simpleToolRentalAPI.rest.builder.OrderFactory;
import simpleToolRentalAPI.utils.CsvDataProviders;

import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.everyItem;

public class ToolRentalCrudTests {
    ToolRentalAPI api = new ToolRentalAPI();
    protected String authenticationToken = api.getAccessToken(ClientFactory.newDefaultClient());

    @Test(groups = {"status"})
    @Link(name = "Link to the API Status", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Status")
    public void checkResponseOfGetStatus() {
        api.getStatus()
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .assertThat()
                .body("status", equalTo("UP"));
    }

    @Test(groups = {"tools"})
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void checkGetAllTools() {
        api.getAllTools()
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void checkGetToolsByCategory(Map<String, String> testData) {
        String category = testData.get("category");
        api.getToolsByCategory(category)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK)
                .body("category", everyItem(equalTo(category)));
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void positiveCheckResultsCount(Map<String, String> testData) {
        int value = Integer.parseInt(testData.get("value"));
        api.getToolsByNumberOfResults(value)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body("category.size()", equalTo(value));
    }

    @Test(groups = {"tools"}, dataProvider = "csvReader", dataProviderClass = CsvDataProviders.class)
    @Link(name = "Link to the API Get all tools", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-tools")
    public void negativeCheckResultsCount(Map<String, String> testData) {
        int value = Integer.parseInt(testData.get("value"));
        api.getToolsByNumberOfResults(value)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

    @Test(groups = {"tools"})
    @Link(name = "Link to the API Get the single tool", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-a-single-tool")
    public void checkGettingSingleToolById() {
        List<Object> id = api.getIdsOfAllTools();
        for (int i = 0; i < id.size(); i++) {
            api.getSingleTool(id.get(i))
                    .then()
                    .assertThat()
                    .statusCode(HttpStatus.SC_OK);
        }
    }

    @Test(groups = {"orders"})
    @Link(name = "Link to the Get a single order", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-a-single-order")
    public void getOrderById() {
        String newOrderId = api.getNewOrderId(authenticationToken, OrderFactory.newDefaultOrder());
        api.getOrderById(authenticationToken, newOrderId)
                .then()
                .assertThat()
                .log().all()
                .statusCode(HttpStatus.SC_OK)
                .body("id", equalTo(newOrderId));
    }


    @Test(groups = {"orders"})
    @Link(name = "Link to the Get all orders", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Get-all-orders")
    public void getAllOrders() {
        api.getAllOrders(authenticationToken)
                .then()
                .log().all()
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Test(groups = {"orders"})
    @Link(name = "Update an order", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Update-an-order")
    public void updateOrder() {
        String newOrderId = api.getNewOrderId(authenticationToken, OrderFactory.newDefaultOrder());
        api.modifyOrder(authenticationToken, newOrderId, UpdatedOrderFactory.modifiedOrder())
                .then()
                .assertThat()
                .log().all()
                .statusCode(HttpStatus.SC_NO_CONTENT);
    }

    @Test(groups = {"orders"})
    @Link(name = "Delete an order", url =
            "https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md#Delete-an-order")
    public void checkIfOrderIsDeleted() {
        String newOrderId = api.getNewOrderId(authenticationToken, OrderFactory.newDefaultOrder());
        api.deleteOrderSuccessful(authenticationToken, newOrderId);
        api.getOrderById(authenticationToken, newOrderId)
                .then()
                .assertThat()
                .log().all()
                .statusCode(HttpStatus.SC_NOT_FOUND);
    }
}
