# 💊 Pharmacy Management System

A Java-based desktop application designed to streamline pharmacy operations through user authentication, medicine management, inventory handling, sales, and billing. The application uses Java Swing for the graphical user interface, MySQL for data storage, and JDBC for database connectivity.

---

## 📌 Project Overview

The Pharmacy Management System (PMS) is a database-driven desktop application developed to manage essential pharmacy operations.

The system provides authentication and user management features along with medicine inventory management, medicine sales, and billing functionality through a Java Swing interface.

---

## ✨ Features

### 🔐 Authentication
- User login
- User registration
- Password recovery
- CAPTCHA-based login verification
- Password visibility option

### 👥 User Management
- Add user
- View users
- Update user information
- Store user details such as name, email, address, date of birth, and mobile number

### 💊 Medicine Management
- Add medicine
- View medicines
- Update medicine details
- Delete medicine
- Store medicine ID, name, company, manufacturing date, expiry date, quantity, and price

### 🛒 Sales Management
- Search medicines
- Select medicines for sale
- Add medicines to sales list
- Calculate total price
- Calculate payment and return amount
- Generate bills

### 🧾 Billing Management
- Create bills
- Store customer name
- Store bill ID and date
- Store total amount paid
- View bills
- Search bills
- Update and delete bill records

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Application development |
| Java Swing | Graphical User Interface |
| MySQL | Database management |
| JDBC | Database connectivity |
| Eclipse IDE | Development environment |

---

## 🏗️ System Architecture

The Pharmacy Management System follows a desktop-based architecture built with Java Swing, Java, JDBC, and MySQL.

### Architecture Flow

```text
┌─────────────────────────────┐
│        Java Swing UI        │
│     User Interface Layer    │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│      Java Application       │
│       Business Logic        │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│            JDBC             │
│    Database Connectivity    │
└──────────────┬──────────────┘
               │
               ▼
┌─────────────────────────────┐
│           MySQL             │
│       Database Layer        │
└─────────────────────────────┘

Application Modules
                    Login / Authentication
                              │
                ┌─────────────┴─────────────┐
                │                           │
                ▼                           ▼
        User Management             Admin Dashboard
                │                           │
        ┌───────┼───────┐          ┌───────┼────────┐
        │       │       │          │       │        │
       Add     View   Update     Medicine  Sales   Billing
       User    User    User     Management


📦 Main Modules
1. Authentication Module
- Login
- Username and password authentication
- CAPTCHA verification
- Forgot password
- Create account
2. User Management Module
- Add User
- View User
- Update User
3. Medicine Management Module
- Add Medicine
- View Medicine
- Update Medicine
- Delete Medicine
4. Sales Module
- Search Medicine
- Select Medicine
- Add Medicine to List
- Calculate Total Price
- Calculate Return Amount
- Generate Bill
5. Billing Module
- Add Bill
- View Bill
- Search Bill
- Update Bill
- Delete Bill
📂 Project Structure
Pharmacy-Management-System/
│
├── ADDUSER.java
├── Addmedicine.java
├── Admin_dashboard.java
├── Dashboard.java
├── FORGETPASS.java
├── UPDATEUSER.java
├── VIEWUSER.java
├── admin.java
├── login.java
├── scanner.java
├── selectmedicine.java
├── signup.java
├── updatemedicine.java
├── verify.java
├── viewbill.java
└── viewmedicine.java
```

🖥️ Application Screenshots
Screenshots demonstrate the main application workflows, including authentication, user management, medicine management, sales, and billing.
🔐 Login
<img width="690" height="682" alt="image" src="https://github.com/user-attachments/assets/0d5b5171-aab0-42a5-9a90-efc9d09898f5" />
👤 User Dashboard
<img width="692" height="591" alt="image" src="https://github.com/user-attachments/assets/885546b2-125b-4bd4-8bc1-17bc71512af3" />
👥 Add User
<img width="760" height="772" alt="image" src="https://github.com/user-attachments/assets/eff099d6-8df9-4eb0-ab01-25ad1743931b" />
👤 Update User
<img width="1367" height="852" alt="image" src="https://github.com/user-attachments/assets/6f24993a-222f-4355-aff5-e965ea90c6b2" />
👨‍💼 Admin Dashboard
<img width="762" height="770" alt="image" src="https://github.com/user-attachments/assets/d924edaf-3bf6-4fd2-82cf-4b7a93e18dfb" />
💊 Add Medicine
<img width="960" height="850" alt="image" src="https://github.com/user-attachments/assets/a09aa255-c06e-4d7c-948d-255c646232a6" />
💊 View Medicine
<img width="917" height="702" alt="image" src="https://github.com/user-attachments/assets/6cbfc102-1a5f-4786-9565-974653f3a06e" />
✏️ Update Medicine
<img width="1346" height="837" alt="image" src="https://github.com/user-attachments/assets/b9799392-6c6e-4931-b1ab-1fcaa842607a" />
🛒 Sell Medicine
<img width="1346" height="838" alt="Screenshot 2026-10-08 131434" src="https://github.com/user-attachments/assets/ae4bfe03-fcf2-446a-88e6-d749cdb9ae98" />
🧾 Add Bill
<img width="852" height="577" alt="image" src="https://github.com/user-attachments/assets/8bb272c5-aa6a-48c5-9f7b-821f8fe9e6e1" />
📋 View Bill
<img width="1122" height="825" alt="image" src="https://github.com/user-attachments/assets/804b9d89-bc4e-4053-a0bb-08e8e9a309b0" />

🗄️ Database
The application uses MySQL as its database management system.
JDBC is used to establish communication between the Java application and the MySQL database.
The database stores information related to:
- Users
- Medicines
- Inventory
- Sales
- Bills
⚙️ How to Run
Prerequisites
- Java JDK
- Eclipse IDE
- MySQL Server
- MySQL Connector/J JDBC Driver
1. Clone the Repository
git clone https://github.com/YOUR_USERNAME/pharmacy-management-system.git

2. Open the Project
Import the project into Eclipse IDE.
3. Configure MySQL
Create the required MySQL database and tables.
Update the database connection details in the Java source code according to your local MySQL configuration.
4. Configure JDBC
Add the MySQL Connector/J driver to the project's build path.
5. Run the Application
Run the login class and start using the application.
🔒 Security Note
Do not commit database passwords, API keys, or other sensitive credentials to GitHub.
For local development, keep credentials outside the repository or use environment-specific configuration.
🚀 Future Improvements
- Improve the user interface and overall UX
- Implement stronger password security
- Add role-based access control
- Add low-stock alerts
- Add medicine expiry notifications
- Improve database validation
- Add detailed sales reports
- Improve error handling
- Add automated testing
- Containerize the application for modern deployment
🎓 Project Type
Academic / DBMS Project
This project was developed to demonstrate practical knowledge of Java desktop application development, database management, JDBC connectivity, and CRUD operations.
👨‍💻 Author
Raj Kapoor Jaiswal

## ⭐ Acknowledgement

This project was developed as an academic DBMS project to gain practical experience in Java, Java Swing, MySQL, JDBC, and database-driven application development.







