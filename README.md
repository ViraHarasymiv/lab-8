# Example for the lab 12. Ivano-Frankivsk National Technical University of Oil and Gas. Department of Computer Systems and Networks.

=========================================================================

# Rest Assured Simple Tool Rental API

[Simple Tool Rental API](https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md) testing using REST Assured

API documentation was taken from the [Quick Introduction to Postman and API Testing for Beginners](https://www.udemy.com/course/postman-crash-course-for-beginners-learn-rest-api-testing/) course

**Tool Rental API.postman_collection.json** or [link](https://elements.getpostman.com/redirect?entityId=23008621-ab564d95-b36a-474e-8f64-ccf834bf6213&entityType=collection) can be used for running tests in Postman

## Executing the Tests

- Clone the repository:
```shell
git clone https://github.com/ViraHarasymiv/rest-assured-framework.git
```
- Run all tests:
```shell
mvn clean test
```
- Generate the report:
```shell
mvn allure:serve
```
- Run test:
```shell
mvn clean test -DsuiteXmlFile=${xml} -Dgroups=${} -Denv=${env}
```
Examples:
- Run the status group tests on prod environment:
```shell
mvn clean test -Dgroups=status -Denv=prod
```
- Run the tools group tests:
```shell
mvn clean test -Dgroups=tools
```
- Run the tools group tests:
```shell
mvn clean test -Dgroups=orders
```
