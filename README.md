# Innovecture_API
Folder Structure
1) The "src/test/java" folder contains a package for tests, which includes 4 test classes. One of the additional     test cases is to validate the JSON schema of the response.
2) The "BaseTest" class contains common utilities and is extended by all the test classes.
3) The "PriceChangeValidationTest" is responsible for generating a .json file as mentioned in the question.

Executing Tests/Test Suite:

1) The framework being used is TestNG. You can execute individual test classes.
2) By triggering the "testng.xml" file, you can execute the TestNG suite.
3) You can execute the entire suite by running the "pom.xml" file.
4) A GitHub CI/CD pipeline is set up to trigger the build.

Notes:
1) Default TestNG and HTML reports are available; separate reports are not created as it was not specified in the test.
2) Since there is only a single endpoint and resource, there is no need for a properties file.
Feel free to reach out if you need any clarification.
