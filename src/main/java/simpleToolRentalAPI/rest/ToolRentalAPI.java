package simpleToolRentalAPI.rest;

import io.restassured.specification.RequestSpecification;
import simpleToolRentalAPI.utils.PropertyLoader;

public class ToolRentalAPI extends AbstractApi{
    @Override
    protected RequestSpecification getClient() {
        return RestClientFactory.getClient(PropertyLoader.getProperty("baseUrl"));
    }
}
