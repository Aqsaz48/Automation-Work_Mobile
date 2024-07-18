 
## About The SFA Mobile Automation Project for Android App

This project is related to my Mobile Automation Test cases for SFA Android App which are designed for the assessment purpose. 
 

### Built With

This Project is built with BrowserStack and Appium to automate the mobile application test cases.

* Appium
* TestNG
* Selenium
* BrowserStack
* ExtentReports: For generating detailed test reports
* Log4j: For logging
* Maven: For project management and dependency resolution


# Getting Started

# Prerequisites
Before you begin, ensure you have the following installed on your system:

* Appium Complete Setup
* Account created on BrowserStack
* IntelliJ or Eclipse IDE
* Java Setup is must


# Installation

1. Download Intellij or Eclipse 
2. Java setup is must
3. Clone the Repository:

Write the following code on bash

```git clone https://github.com/Aqsaz48/Automation-Work_Mobile.git```
   
   OR unzip the zip file shared

4. Import it as maven project in intelliJ or any IDE


## Setup the Project

* Go to IntelliJ or any IDE
* Open the cloned project from the directory in IntelliJ as maven project.
* Open BrowserStack and upload your .apk file here.
* Copy AccessKey and ID credentials for your account and .apk path value in the Constants.java file (Path: /sfa.qa/src/main/java/sfa/configs/Constants.java) 
* Then go to App automate dashboard and see the app should be fully uplaoded and basic setup is ready to run.
* Go to testng.xml file and run it to execute the test cases.
* After successfully running the project, it will start running the test cases and you can view them along with their demo video and logs on App Automate dashboard.


## Configuration:
 
- The configuration for the app is managed through a `config.properties` 
path: /src/main/resources/config.properties

- 'Constants.java' which you can find in /sfa.qa/src/main/java/sfa/configs/Constants.java = "bs://36eadffc28e696c3aa2ffe946d3f51332d39fc72"

You can get this path on uploading your app in browserstack for app automaiton, you will get a path value  of bs://..... (Copy the value and add it here)

- The browserstack credentials are account specific so when you create an acoount, you will have your own credentials to use here in the project. 

It is managed though a 'Constants.java' path: /sfa.qa/src/main/java/sfa/configs/Constants.java

- Change following values in this file:

	 BS_USERNAME = "abc"; ----You will get this from BrowserStack Account
	 BS_ACCESSKEY = "gahongsd2qi1csLkZaf";  ----You will get this from BrowserStack Account
	 EMAILID = "test email"; ----Your app login email
	 PHONE = "+966787XXX878"; ----Any phone number for testing provide here
	 final String PASSWORD = "Pass*1"; ----Your app password for testing


##  `pom.xml`: Here all the dependencies have been added which is required for building the framework


 	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<java.version>11</java.version>
		<maven.compiler.version>3.8.1</maven.compiler.version>
		<maven.surefire.version>3.0.0-M1</maven.surefire.version>
		<appium.version>9.2.2</appium.version>
	</properties>
	<dependencies>
		<!-- https://mvnrepository.com/artifact/io.appium/java-client -->
		<dependency>
			<groupId>io.appium</groupId>
			<artifactId>java-client</artifactId>
			<version>${appium.version}</version>
		</dependency>
		<dependency>
			<groupId>org.seleniumhq.selenium</groupId>
			<artifactId>selenium-java</artifactId>
			<version>4.10.0</version>
		</dependency>
		<dependency>
			<groupId>org.testng</groupId>
			<artifactId>testng</artifactId>
			<version>7.4.0</version>
			<scope></scope>
		</dependency>
		<!-- https://mvnrepository.com/artifact/com.aventstack/extentreports -->
		<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>5.0.9</version>
		</dependency>
		<dependency>
			<groupId>commons-io</groupId>
			<artifactId>commons-io</artifactId>
			<version>2.11.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-core</artifactId>
			<version>2.20.0</version>
		</dependency>
		<dependency>
			<groupId>org.apache.logging.log4j</groupId>
			<artifactId>log4j-api</artifactId>
			<version>2.20.0</version>
		</dependency>
		<!-- https://mvnrepository.com/artifact/org.json/json -->
		<dependency>
			<groupId>org.json</groupId>
			<artifactId>json</artifactId>
			<version>20220320</version>
		</dependency>
	</dependencies>
	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-compiler-plugin</artifactId>
				<version>${maven.compiler.version}</version>
				<configuration>
					<encoding>UTF-8</encoding>
					<source>${java.version}</source>
					<target>${java.version}</target>
				</configuration>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>${maven.surefire.version}</version>
				<configuration>
					<!-- Force alphabetical order to have a reproducible build -->
					<!-- <runOrder>alphabetical</runOrder> <useSystemClassLoader>false</useSystemClassLoader> -->
					<perCoreThreadCount>false</perCoreThreadCount>
					<!-- <useUnlimitedThreads>true</useUnlimitedThreads> -->
					<!--  <argLine>-Xmx1024m -XX:MaxPermSize=256m</argLine> -->
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>


## Test Scenarios: 

You will find all the test case scenarios in the below path:

/sfa.qa/src/test/java/sfa/mobile/xxxx.java

### To run the test cases: 

* Navigate to "/sfa.qa/testng.xml" file
* Verify the test cases you want to run, if you want to run all don't change anything
* If you want to run specific test cases , simply comment out those or add them in excluded form and run the specific ones.
* Now to Run, click on file > Right click > Run as testNG suite.
* Now navigate to your browserstack account and verify on App Automate dashboard the tests will start executing.

### NOTE: Videos for the DEMO are also available on BrowserStack to view.

## TEST CASE SCENARIOS: 

### (NOTE: There are numerous amount of other test cases are also there which I know and could be added but due to time constraint and configuration setup which is too time taking I added just these scenarios for now)

### IN ENGLISH LANGUAGE: 

* Test-1: Launch App, navigate to profile screen and login with valid credentials.
* Test-2: Launch App, navigate to different screens like Discover and search for any input data e.g. Cricket.
* Test-3: Launch App, go to Groups screen, search for any Football group.

### IN ARABIC LANGUAGE:
* Test-1: Launch App, change langaue to Arabic, navigate to profile screen and login with valid credentials.
* Test-2: Launch App, change the language to arabic, avigate to Discover screen.


## Recommendations for Improvements for best practices in Mobile Application

* The App was very poor in responsiveness as for teh automation testing point of view, it makes it sloe or sometimes it does not repsond on your actions which fails the test cases. (This behavior is very Inconsistent)

* Benefits of Using Unique IDs, Class Locators or accessbility IDs is very important in any application as it makesit easier to automate for future and the dev or tester will have to spend less time or configuratios and scripting cases for it. 

