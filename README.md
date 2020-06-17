# Mobile Automation using Appium

# Introduction
As name explains this framework is to automate the manual testing done on mobile application.
Project focuses on Solving problems faced a manual tester and provide understanding between Buisness,Development and Testing Units.
Tried to bring automation and more close to easy language where Buisness,Development and Testing unit can understand the features and steps easily, clear view of objectives, smooth road,etc.
Repeated testing is done automaically
![alt text](https://github.com/[username]/[reponame]/blob/[branch]/testrepeat.jpg?raw=true)
Provides reliable and effective results.
This project is built over Appium,Cucumber,Maven with java.
After installation will support you to create and use predefined actions for an Android and lets you automate those actions. 


# Installation

Follow the following steps:<br/>
	1. IDE:<br/>
		-Install preferred IDE- Intellij IDEA <br />
	2. Repository:<br/>
		-Download this repository : [Automation-Testing Android](https://github.com/nitindoodhiya/Automation-Testing/archive/master.zip)<br />
	3. Cucumber Plugin<br/>
		-Install from plugin marketplace<br/>
	4. Appium Server<br/>
		-Download from [Appium ](https://github.com/appium/appium-desktop/releases/tag/v1.17.1-1)<br/>
	5. Android Emulator<br/>
		-Use Virtual Device from Android Studio , Example Pixel_3a_API_28<br/>
	6. Maven <br/>
		-Follow the guide [Guide ](https://www.javatpoint.com/how-to-install-maven)<br/>
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
		
#Understanding the Structure
	##Softwares Used 
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
	##Implementing:
		1. Packages:
			- 
			

	
