**************************KARROS TEST**************************************

-------------- UI: Java - Selenium - Serenity - Cucumber - Maven - POM -------------
-------------- API: Java - Rest Assured -------------

Prerequisite
--------------
- Install JDK 1.8
- Install maven - https://www.mkyong.com/maven/how-to-install-maven-in-windows/ (v3.6.3)
- Install IntelliJ Community Idea: https://www.jetbrains.com/idea/download/#section=windows
- Install Cucumber for Java plugin for your Idea (IntelliJ) - https://www.hindsightsoftware.com/blog/cucumber-jvm-intellij#:~:targetText=Install%20and%20conFIgure%20cucumber%20plugin&targetText=Head%20to%20Preferences%20%3E%20Plugins%20and,to%20restart%20IntelliJ%20once%20complete.


Running test
--------------
Run UI:
---------------
**Run by JUnit**
1. Right click the Project
2. Click on Maven
3. Click on Reimport
4. Right click on src/test/java/testrunner/TestRunner.class
5. Click on Run 'TestRunner'

**Run by Command Line:**
Go to your project directory from terminal and hit following commands
* `mvn verify`
* `mvn verify -Dcucumber.options="classpath:features/Filter.feature"` to run specific feature.

Run API:
---------------

**Run by JUnit**
1. Right click the Project
2. Click on Maven
3. Click on Reimport
4. Right click on src/test/java/api/TypicodeAPIDemo.class
5. Click on Run 'TypicodeAPIDemo'


Framework Architecture
--------------
	ParentPortalTest
		|
		|_src/main/java
		|	|_config
		|	|   |_config.properties
		|	|_pages
		|   |   |_api
		|   |      |_TypicodeAPIPage.class
		|	|   |_web
		|	|      |_BasePage.class
		|	|      |_FilterPage.class
		|	|      |_HomPagePage.class		
		|	|_util
		|       |_Config.class
		|       |_SetUp.class
		|       |_Util.class
		|       
		|_src/test/java
		|   |_api
		|      |_TypicodeAPIDemo.class
		|   |_stepdefs
		|      |_FilterStepDefs.class		
		|   |_testrunner
		|       |_browsers
		|       |   |_chrome	
		|       |_hook
		|       |    |_Hooks
		|       |_TestRunner.class
		|   
		|_src/test/resources
		|	|_features
		|	|   |_Filter.feature

		

* **src/main/java/config** - config.properties is storing CONSTANT for testing
* **src/main/java/pages** - all the Pages in POM goes here.

* **src/main/java/util** - Utilize functions

* **src/test/java/stepdefs** - Define step defintion under this package for your feature steps.

* **src/test/java/testrunner** - This package contains JUnit Cucumber runner where you can configure your glue code location (step defintions). 
> **This test framework support cross browser test**, just config which browser you want to run in glue. SetUp hook will be run to initilize WebDriver Depend on which browser you had selected
**i.e I want to run Test with Chrome browser**: glue = {"stepdefs","testrunner.hook","testrunner.browsers.**chrome**"}

> **Hooks.class** where you can configure all before and after Test with @After/@Before annotation. It will be run after each scenario.

* **src/test/resources/features** - all the cucumber features files (files .feature ext) goes here.

Writing a test
--------------

The cucumber features goes in the **src/test/resources/features** library and should have the ".feature" extension.

Predefined steps
-----------------
By using predefined steps you can automate your test cases more quickly, more efficiently and without much coding.

The predefined steps are located **src/test/resources/stepdefs**


Setting Browser from TestRunner
-----------------
You can define to run with which browser from TestRunner: **src/test/java/testrunner**  

**i.e: I want to run Test with Chrome browser**: glue = {"stepdefs","testrunner.hook","testrunner.browsers.**chrome**"}



