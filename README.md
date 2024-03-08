<!-- PROJECT LOGO -->
<div align="center">
  <h1 align="center">eBay</h1>
  <p align="center">Web Testing Project with Carina</p>
</div>

<!-- TABLE OF CONTENTS -->
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
        <li><a href="#prerequisites">Prerequisites</a></li>
      </ul>
    </li>
   <li><a href="#implementation-details">Implementation details</a></li>
   <li><a href="#useful-documentation">Useful Documentation</a></li>
  </ol>

<!-- ABOUT THE PROJECT -->
## About The Project

The project focuses on testing the eBay website, using core testing tools such as Carina Framework in Java. The goal of the project is to improve testing skills and gain experience in web testing.

### Built With

* Programming Language: Java
* Build Tool: Maven
* Frameworks: Carina

### Prerequisites

- [ ] Install Java +11
- [ ] Install and configure [Apache Maven 3.6.0+](http://maven.apache.org/)
- [ ] Clone the repo.
- [ ] Run mvn clean install in terminal.
- [ ] Start the selenium server with the command: java -jar selenium-server-4.18.1.jar standalone.

<!-- IMPLEMENTATION DETAILS -->

## Implementation details

### Migration from pure Selenium
1. Modify the _config.properties file.
2. Page classes should extend AbstractPage.
3. Test classes should implement IAbstractTest.
4. Use ExtendedWebElement instead of WebElement.

### Screenshot with Carina

1. Create a class that implements ITestListener. In this project it is done in BaseTest.
2. Override the **onTestFailure** method.
3. Add the code to take a screenshot with this method.
4. Get the Test method name and take a screenshot with the test name. Then place it in the desired destination folder.
5. Finally, add the annotation @Listeners(BaseTest.class) to the Test classes.

<!-- USEFUL DOCUMENTATION -->
## Useful Documentation

* [eBay](https://www.ebay.com)
* [Carina Framework](https://zebrunner.github.io/carina/)
* [TestNG](https://testng.org/doc/documentation-main.html)

