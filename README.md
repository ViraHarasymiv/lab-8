# The example of the eighth lab. Ivano-Frankivsk National Technical University of Oil and Gas. Department of Computer Systems and Networks.

The target website is [BPBOnline](http://practice.bpbonline.com/index.php)

Automated tests:
1. [Verify the price of the hardware's item in the cart](https://github.com/ViraHarasymiv/labs/issues/1).
2. [Verify the new account's creating (positive test)](https://github.com/ViraHarasymiv/labs/issues/2)


## Documentation:

1. [MVN REPOSITORY](https://mvnrepository.com/);
2. [WebDriverManager](https://bonigarcia.dev/webdrivermanager/).

- Clone the repository:
```shell
git clone https://github.com/ViraHarasymiv/labs
```
-Switch to the lab-8 branch:
```shell
git checkout lab-8
```
- Execute [test-case #1](https://github.com/ViraHarasymiv/labs/issues/1):
```shell
mvn -Dtest=CartTests#checkItemPriceInCart test
```
- Execute [test-case #2](https://github.com/ViraHarasymiv/labs/issues/2):
```shell
mvn -Dtest=createAccountTest#createAccountPositiveTest test
```