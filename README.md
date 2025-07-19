# Selenium Keyword Driven Framework (Java)

This project is a **Keyword Driven Test Automation Framework** built with **Selenium WebDriver** and **Java**.  
All **Action Keywords**, **Locators** (for UI elements), and **Test Data** are maintained externally in an **Excel file**, making the framework highly flexible and easy to maintain.

---

## Project Overview

- **Automation Type**: Keyword Driven Framework  
- **Technology Stack**:  
  - Selenium WebDriver  
  - Java  
  - Apache POI (for Excel integration)  
  - TestNG (optional, for test structure)
- **Test Site**: [OrangeHRM Demo](https://opensource-demo.orangehrmlive.com/)

This framework:
- Reads **locators**, **keywords**, and **test data** dynamically from Excel.
- Uses **ExecutionClass.java** as the main entry point.
- Executes tests that **log in to OrangeHRM**, **verify the dashboard title**, and **close the browser**.


---

## Excel Test Data

The Excel file is located in the project directory:


- **Locator Column**: Supports all locator types (e.g., `id=username`, `xpath=//input[@name='password']`, `css=.loginBtn`).
- **Action Keyword Column**: Defines the actions to be performed (e.g., `openBrowser`, `goToUrl`, `enterUsername`, `clickLogin`, `verifyLoginAndQuit`).
- **Test Data Column**: Supplies the input data required for the test step.



---

## Setup Instructions

### Best Recommended Setup
1. **Clone the repository** into IntelliJ IDEA:
   [Repo Link : https://github.com/ArunDrioder/OrangeHRMTask.git]

2. **Open the project in IntelliJ IDEA**.

3. **Ensure dependencies** (e.g., Selenium, Apache POI) are downloaded via Maven.

4. **Run the main execution file**:


