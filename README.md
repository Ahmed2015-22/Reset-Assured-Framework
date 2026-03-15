# 🧪 Integrated Test Automation Framework (Web & API)

### 🔍 Project Overview
A **robust, maintainable, and scalable Test Automation Framework (TAF)** designed to handle both Web UI and API testing. This project demonstrates industry best practices in automation using **Java**, **Selenium**, **Rest-Assured**, and **Postman/Newman**.

---

## 🚀 Key Features

### 🌐 Web Automation (UI)
- ✅ **Page Object Model (POM)** design pattern for high reusability & maintainability.
- ⏳ **Explicit Waits Utility** for reliable synchronization and handling flaky tests.
- 🌐 **Cross-browser support** (Chrome, Edge, Firefox).
- 📸 **Custom Listeners & Hooks** for automated screenshots and logging on failure.
- 🧠 **Environment-based execution** (Local, Remote, and Headless).

### 📡 API Automation (Backend)
- 🛠 **Rest-Assured + Java** for powerful, fluent, and automated API validation.
- 📬 **Postman & Newman** integration for collection-based testing and documentation.
- 📁 **Data-Driven Testing** using JSON and Excel for dynamic test coverage.
- 🔍 **Schema Validation** to ensure API response structure integrity.
- 🪵 **Log4j2 & Allure Reporting** for detailed runtime insights and visual reports.
- ⚙️ **CI-ready** integration with GitHub Actions.

---

## 🛠 Tools & Technologies

| Category | Tools |
| :--- | :--- |
| **Language** | Java, JavaScript (Node.js) |
| **Web UI** | Selenium WebDriver |
| **API Testing** | Rest-Assured, Postman, Newman |
| **Unit Testing** | TestNG |
| **Build Tool** | Maven |
| **Reporting** | Allure Reports, Extent Reports |
| **Mocking** | MockAPI.io |

---

## 🏗️ Framework Structure

* `src/main/java`: Contains Base setup, Page Objects, and API Utilities.
* `src/test/java`: Contains Test scripts for Web UI and Rest-Assured API tests.
* `src/test/resources`: Test data files (Excel/JSON) and environment configurations.
* `Postman_Collections/`: Contains `.json` collections for Newman execution.

---

## 📋 Employee API Test Scenarios (Documentation)
Tested using **Postman** and **Rest-Assured** against MockAPI endpoints: `https://697f9730d1548030ab667629.mockapi.io/`

| Endpoint | Method | Key Validations |
| :--- | :--- | :--- |
| `/employee` | **GET** | Status 200, Response Time <800ms, Schema Validation, Data Integrity. |
| `/employee/:id` | **GET** | Verify specific ID, Validate Data Types (String, Number, Boolean). |
| `/employee` | **POST** | Status 201, Capturing created ID in Environment Variables. |
| `/employee/:id` | **PUT/PATCH** | Data Consistency (Request matches Response), Header Verification. |
| `/employee/:id` | **DELETE** | Status 200, Verification of the returned deleted object. |

---

## 💻 Getting Started

### 1. Prerequisites
* JDK 11 or higher.
* Maven installed.
* Node.js & Newman (for Postman collection execution).

### 2. Execution
**Run All Java Tests (Web & API):**
```bash
mvn clean test
```

👨‍💻 Author
**Ahmed El-Sharkawi**  
*Junior Test Automation Engineer*

🔗 [LinkedIn Profile](https://www.linkedin.com/in/ahmed-el-sharkawi/)
🔗 [GitHub Profile](https://github.com/Ahmed2015-22)
