# 🏦 ATM Machine System 💳

This is a simple ATM Machine system built with **Java Swing** for the GUI and **SQL** for the backend. The system simulates various ATM functions, including withdrawing money, checking balance, depositing funds, and more! 🚀

## Features 🌟

- **Deposit** 💰
- **Withdrawal** 💵
- **Mini Statement** 📝
- **PIN Change** 🔐
- **Balance Enquiry** 💳
- **Fast Cash** 💸
- **Exit** 🚪

## Installation 📦

To get started with this project, follow these steps:

### Prerequisites 🔧

1. Java Development Kit (JDK) installed on your system (preferably JDK 8 or higher).
2. A MySQL database to store transaction data.

### Steps to Run 🔥

1. Clone this repository:
   ```bash
   git clone https://github.com/your-username/ATM-Machine.git


2. **Set up the MySQL database:**
   - Create a **Bank** table in your database with the following fields:
     - `Pin` (VARCHAR)
     - `CardNumber` (VARCHAR)
     - `Date` (DATE)
     - `Type` (VARCHAR)
     - `Amount` (INT)
   - Create a **Login** table with the fields:
     - `Pin` (VARCHAR)
     - `CardNumber` (VARCHAR)
   
3. **Modify database credentials:**
   - In the `Con` class, update the database connection details (host, username, password) as per your setup.

4. Run the Java project in your IDE (e.g., IntelliJ IDEA, Eclipse).

---

## Features Explained 🔍

### 1. **Transaction Screen (Main Screen)** 💻
The ATM displays a main screen where the user can select their transaction options:
- **Deposit** 💰: Add funds to your account.
- **Withdrawal** 💵: Withdraw funds from your account.
- **Fast Cash** 💸: Quickly withdraw a preset amount.
- **Mini Statement** 📝: View recent transactions.
- **PIN Change** 🔐: Change your ATM PIN.
- **Balance Enquiry** 💳: Check your current balance.
- **Exit** 🚪: Close the ATM system.

### 2. **Deposit Feature** 💰
Allows users to deposit money into their account, updating the balance accordingly. The transaction is saved to the database.

### 3. **Withdrawal & Fast Cash** 💵💸
Users can withdraw money or select preset withdrawal amounts. The system checks for sufficient funds before completing the transaction.

### 4. **Mini Statement** 📝
View the transaction history, including deposits and withdrawals. It also displays the current balance.

### 5. **PIN Change** 🔐
Users can change their ATM PIN to a new secure code.

---

## Code Structure 🏗️

- **Transaction.java** 💼: Main ATM interface with options for the user.
- **Deposit.java** 💰: Handles deposit transactions.
- **Withdrawal.java** 💵: Handles withdrawal transactions.
- **MiniStatement.java** 📝: Displays the transaction history.
- **PinChange.java** 🔐: Allows the user to change their PIN.
- **Con.java** 🔌: Manages the database connection and executes queries.

---

## Contributors 👩‍💻👨‍💻

- **Your Name** ([Dhruv Sapra]([https://github.com/YourGitHub](https://github.com/Dhruv-Cs2004)))

---

## License 📜

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.

---

## Acknowledgments 🙏

- Thanks to **Java Swing** for providing the framework for building this GUI.
- Special thanks to **MySQL** for database support.
```



### **Key Components**:
- **Emojis**: They are used throughout the README for a visual touch, making it more engaging.
- **Project Overview**: Introduces the purpose of the ATM system and its features.
- **Installation Instructions**: Step-by-step guide to get the system up and running.
- **Feature Descriptions**: Clear explanation of the available features (Deposit, Withdrawal, etc.).
- **Code Structure**: Provides an overview of the classes and their functions in the project.
- **Screenshots**: Placeholder for images (replace with actual screenshots if needed).
- **Contributors**: Placeholder for contributor names and GitHub links.
- **License**: Indicates licensing information.

This **README.md** is designed to be user-friendly and professional for presenting your ATM Machine project on GitHub.


