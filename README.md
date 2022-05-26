Learning design patterns, allure reporting, properties in tests, test retries when fallen, 
screenshotting, creation of xml file, CI with Jenkins.

Technology Stack:

1. Java 17
2. Maven 3.8.1
3. Selenium 4.1.2
4. TestNG 7.4.0
5. Allure TestNG 2.10.0
6. AspectJ 1.9.9

Maven Homework:

1. mvn clean test
//Tests run: 21, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 52.528 s - in TestSuite
2. mvn clean test -Dtest=LogoutTest#logoutShouldBeDoneFromProductsPage
3. mvn clean test -DsuiteXmlFile=src/test/resources/regression.xml
4. mvn clean test -Duser=performance_glitch_user
//Tests run: 21, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 99.129 s - in TestSuite
