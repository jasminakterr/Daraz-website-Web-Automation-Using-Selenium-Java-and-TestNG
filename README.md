# Daraz-website-Web-Automation-Using-Selenium-Java-and-TestNG
## Project Overview
This project automates the testing of the Daraz e-commerce website using Selenium WebDriver, Java, and TestNG. It includes various test cases to validate different functionalities of the website such as login, product search, adding items to the cart, and logout.

- Login functionality: Automates the login process.
- Product search: Searches for products and validates the results.
- Add to cart: Adds products to the cart and verifies the cart contents.
- Logout functionality: Automates the logout process.

## Technologies Used
- Selenium WebDriver: For browser automation.
- Java: Programming language for writing test scripts.
- TestNG: Test framework for managing test cases and generating reports.
- Maven: Build automation and dependency management.
- Extent Reports: For generating detailed and interactive test reports.
- WebDriverManager: For managing browser drivers automatically.
- Page Object Model (POM): For better test maintainability and scalability.
## Prerequisites
Before running the project, ensure you have the following installed:
- Java Development Kit (JDK): Version 8 or higher.
- Maven: For dependency management.
- IDE: IntelliJ IDEA.
- Browser: Chrome, Firefox, or any other supported browser.
- Git: To clone the repository.

## Setup Instructions
1. **Clone the repository**:
   ```bash
   git clone https://github.com/jasminakterr/Daraz-website-Web-Automation-Using-Selenium-Java-and-TestNG.git

2. **Install dependencies**:
   ```bash
   mvn clean install
3. **View reports**:
After running the tests, the Extent Reports will be generated in the ``test-output`` folder. Open the ``Report.html`` file to view the detailed test results.

## Test Cases
The following test cases are included in this project:
- Login Test:
Validates the login functionality with valid credentials.
Handles invalid login attempts.

- Product Search Test:
Searches for a product and verifies the search results.

- Add to Cart Test:
Adds a product to the cart and verifies the cart contents.

- Logout Test:
Validates the logout functionality works correctly.

## Reporting
This project uses Extent Reports for generating detailed and interactive test reports. The reports include:
- Test case status (Pass/Fail).
- Screenshots for failed test cases.
- Execution time and other metadata.
Reports are saved in the test-output folder after each test run.
![Daraz 2](https://github.com/user-attachments/assets/02dd7578-216d-4556-9576-f131b4ab19e3)

![Daraz 1](https://github.com/user-attachments/assets/504a55cb-b3c1-4283-b29a-34b2b5533f50)
