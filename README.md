# Automated Testing with Appium for Android in Java

## Description
This project contains an example of automated tests written in Java using Appium for testing Android applications. An existing application 
was used for testing: https://play.google.com/store/apps/details?id=com.phptravelsnative&hl=pl&gl=US&pli=1


## Requirements
- Java Development Kit (JDK) version 21 or newer
- Java IDE Environment (e.g., Eclipse, IntelliJ IDEA)
- Maven - a tool for managing dependencies and building projects
- Appium - a test automation tool for mobile applications
- Android SDK with appropriate SDK platform-tools and build-tools installed
- An Android emulator or a physical Android device connected to your computer

## Installation and Configuration
1. Clone the project using the `git clone` command.
2. Open the project in your preferred IDE.
3. Make sure you have installed and configured Java, Maven, and Appium properly.
4. Configure the Appium server URL, device capabilities, and other settings in the config.properties

## Running Tests
1. Start the Appium server.
2. Open a virtual machine with android or connect physical device to your computer.
3. Install PHPTRAVELS app from Google Play on your device.
4. Open the project in your IDE.
5. Run the tests by clicking the "Run" button or using the appropriate options in your IDE.

## Project Structure
- `src/test/java/tests`: Contains automated tests.
- `src/test/java/pages`: Contains page objects classes.
- `src/test/java/utils`: Contains supporting classes for reporting, utilities, etc.
- `src/test/reports`: Contains reports and screenshots generated after running tests.
- `src/test/resources`: Contains test resources, such as configuration files.
- `pom.xml`: Maven configuration file containing project information and dependencies.

## Author
Mariusz Wawreszuk - wawreszuk.mariusz@gmail.com
