# Mobile Automation using Appium

# Introduction
As name explains this framework is to automate the manual testing done on mobile application.
Project focuses on Solving problems faced a manual tester and provide understanding between Buisness,Development and Testing Units.
Tried to bring automation and more close to easy language where Buisness,Development and Testing unit can understand the features and steps easily, clear view of objectives, smooth road,etc.
Repeated testing is done automaically
Provides reliable and effective results.
This project is built over Appium,Cucumber,Maven with java.
After installation will support you to create and use predefined actions for an Android and lets you automate those actions. 


# Installation

	Follow the following steps:
		1. IDE:
			-Install preferred IDE- Intellij IDEA 
		2. Repository:
			-Download this repository : 
			[a Automation-Testing Android](https://github.com/nitindoodhiya/Automation-Testing/archive/master.zip)
		3. Cucumber Plugin
			-Install from plugin marketplace
		4. Appium Server
			-Download from [a Appium ](https://github.com/appium/appium-desktop/releases/tag/v1.17.1-1)
		5. Android Emulator
			-Use Virtual Device from Android Studio , Example Pixel_3a_API_28
		6. Maven 
			-Follow the guide [Guide ](https://www.javatpoint.com/how-to-install-maven)
# Running the Project

	1. Open repository in Intellij
	2. Changing paths:
		-log4jPropertyFile:
			Edit Constants class as => log4jPropertyFile = "C:\\Users\\nitin\\IdeaProjects\\Automation-Testing\\src\\test\\config\\log4j.properties";
		-logs location:
			Edit log4j.properties file => log4j.appender.file.File=C:\\Users\\nitin\\Desktop\\logs_${current.date.time}.log
	3. Appium Server:
		-Open Appium Server
		-Start Appium Server
	4. Android Emulator:
		-cd C:\Users\nitin\AppData\Local\Android\Sdk\emulator
		-adb start-server
		-emulator -avd Pixel_3a_API_28

	5. By Intellij 
		-Open TestRunner package and run LoginRunner through Intellij
	6. Bt Commandline
		-mvn build
		-mvn test
		
# Understanding the Structure
	## Softwares Used 
		1. Appium:
			- It provides Interface to connect with android device and control using libraries.
			- Its Rich in development and documentation
		2. Cucumber:
			- Cucumber understands a special high level language close to English called Gherkin
			- Language allows to understand for Business, Developers and Testers easily
		3. Maven:
			- Lets you to resolve dependencies in one go
			- Maintain Dependency easily
		4. java:
			- Rich Community
			- Multiple resources available
			- Easy to resolve errors
		5. log4j:
			- Logger for our system
			- Define errors on basis of severity
			- Format the error results in favourable way
	## Implementing:
		1. Packages:
			i. Features:
				Contains features of software to be tested
				Each feature will have actions/steps to conduct
				Feature is written in gherkin language
			ii. Base:
				BaseUtil.java: 
					- Basic functions to control an Android devices example, Scrolling, tapping, finding objects, etc.
					- Data members for connecting to Appium server
				Constants.java:
					- Static Final Strings to keep strings/names/locations separate 
				YMLReader.java:
					- To return xpath of required elements after reading YML files
			iii. Steps:
				Hook.java:
					- Initaializes/Injects the properties of BaseUtil objects
				LoginSteps.java:
					- Step definition of the actions/steps declared in feature file
					- Implements the the actions using the BaseUtil functions
			iv. TestRunner:
				LoginRunner:
					- @CucumberOptions(features = "src/test/java/Features", glue = "Steps")
					- Glue the StepDefinition java file with the feature file
			
					
# Class Diagram:
	![alt text](https://github.com/nitindoodhiya/Automation-Testing/blob/master/diagram_1.png?raw=true)				
			

	
