# 🚀WikipediaAutotestsJavaCucumber🚀

 Java Project with Cucumber, JUnit, and Allure

The project implements functionality related to changing data format, scrolling, searching, and user login. 
All scenarios are described in the respective feature files.
The development of this framework was conducted in the develop branch.


## Requirements

- Java 17
- Maven
- Cucumber 7
- JUnit4
- Allure

### Feature Files
ChangeDataFormat.feature: Scenarios related to changing data format.

Scroll.feature: Scenarios related to scrolling.

Search.feature: Scenarios related to searching.

UserLogin.feature: Scenarios related to user login.

## Installation
Clone the repository:
```bash
gh repo clone irinaBerendeeva87/WikipediaAutotestsJavaCucumber
```
## Running Tests
Using Maven

mvn clean test

### Using RunTest.java
To run tests using the RunTest.java class, follow these steps:

Open the src/test/java/runner/RunTest.java file.

Right-click on the file and choose "Run" to execute the tests

## Generating Allure Report
mvn allure:serve

### Known Issue
Encountered a problem with running tests on CI through GitHub Actions. 
Currently investigating and working on a resolution.

