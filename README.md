# Example for the lab 9. Ivano-Frankivsk National Technical University of Oil and Gas. Department of Computer Systems and Networks.

The project is made by using Page Object Model and TestNG framework. Log4j is used for logging events. All logs are saved in the directory named logs (target/logs/appTest.log).

- The "DataProvider" annotation is used in order to pass multiple parameters to our tests. Using DataProviders, we can easily pass multiple values to a test in just one execution cycle.
- The "Parameter" annotation is used in order to select web-browser

The target website is [BPBOnline](http://practice.bpbonline.com/index.php)

Automated tests:
1. Positive test for the creating new account
2. Negative test for the creating new account
3. Test for checking the hardware's item in the cart
4. Test for checking the software's item in the cart

## Documentation:

1. [MVN REPOSITORY](https://mvnrepository.com/);
2. [WebDriverManager](https://bonigarcia.dev/webdrivermanager/).

- Clone the repository:
```shell
git clone https://github.com/ViraHarasymiv/labs
```
- Switch to the lab-9 branch:
```shell
git checkout lab-9
```
- Execute [test-case #1](https://github.com/ViraHarasymiv/labs/issues/1):
```shell
mvn -Dtest=HardwareCartTests#checkItemPriceInCart test
```
- Execute [test-case #2](https://github.com/ViraHarasymiv/labs/issues/2):
```shell
mvn -Dtest=PositiveCreateAccountTest#positiveCreateAccountTest test
```
- Execute [test-case #3](https://github.com/ViraHarasymiv/labs/issues/3):
```shell
mvn -Dtest=SoftwareCartTests#checkItemPriceInCart test
```
