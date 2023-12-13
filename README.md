## 🚀WikipediaAutotestsJavaCucumber🚀

 Java Project with Cucumber, JUnit, and Allure

I have tested the basic functionality of the web application [Wikipedia.](https://en.wikipedia.org/wiki/Main_Page)

The project implements functionality related to changing data format, scrolling, searching, and user login. 
All scenarios are described in the respective feature files.
The development of this framework was conducted in the develop branch.

### Requirements

- Java 17
- Maven
- Cucumber 7.14.1
- Cucumbe Picocontainer 7.14.1
- JUnit5
- Allure

### Feature Files
ChangeDataFormat.feature: Scenarios related to changing data format.

Scroll.feature: Scenarios related to scrolling.

Search.feature: Scenarios related to searching.

UserLogin.feature: Scenarios related to user login.

### Continuous Integration (CI)
Continuous Integration is configured through GitHub Actions, automating the test execution process.

### Branch Information
The development of this framework was conducted in the develop branch.

### 🔖 View Report in two ways:

1. You can view [here](https://github.com/irinaBerendeeva87/WikipediaAutotestsJavaCucumber/tree/gh-pages/10/data/test-cases) the latest Allure report in the branch gh-pages

2. By following the link provided at GitHub page

https://irinaberendeeva87.github.io/WikipediaAutotestsJavaCucumber/10/
### Installation
Clone the repository:
```bash
gh repo clone irinaBerendeeva87/WikipediaAutotestsJavaCucumber
```
### Running Tests
Using Maven

`mvn clean test`


### Using RunTest.java
To run tests using the RunTest.java class, follow these steps:

Open the src/test/java/runner/RunTest.java file.

Right-click on the file and choose "Run" to execute the tests

### Generating Allure Report
`mvn allure:serve`

