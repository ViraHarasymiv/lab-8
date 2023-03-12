package simpleToolRentalAPI.rest;

import io.restassured.specification.RequestSpecification;

public abstract class AbstractApi {
    protected abstract RequestSpecification getClient();
}
