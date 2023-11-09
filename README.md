<div align="center">
<h1 align="center">
<img src="https://raw.githubusercontent.com/PKief/vscode-material-icon-theme/ec559a9f6bfd399b82bb44393651661b08aaf7ba/icons/folder-markdown-open.svg" width="100" />
<br>LIBRARY-INVENTORY-SYSTEM</h1>
<h3>◦ Developed with the software and tools below.</h3>

<p align="center">
<img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=flat-square&logo=openjdk&logoColor=white" alt="java" />
</p>
<img src="https://img.shields.io/github/license/marislakss/library-inventory-system?style=flat-square&color=5D6D7E" alt="GitHub license" />
<img src="https://img.shields.io/github/last-commit/marislakss/library-inventory-system?style=flat-square&color=5D6D7E" alt="git-last-commit" />
<img src="https://img.shields.io/github/commit-activity/m/marislakss/library-inventory-system?style=flat-square&color=5D6D7E" alt="GitHub commit activity" />
<img src="https://img.shields.io/github/languages/top/marislakss/library-inventory-system?style=flat-square&color=5D6D7E" alt="GitHub top language" />
</div>

---

## 📖 Table of Contents
- [📖 Table of Contents](#-table-of-contents)
- [📍 Overview](#-overview)
- [📦 Features](#-features)
- [📂 repository Structure](#-repository-structure)
- [⚙️ Modules](#modules)
- [🚀 Getting Started](#-getting-started)
    - [🔧 Installation](#-installation)
    - [🤖 Running library-inventory-system](#-running-library-inventory-system)
- [🤝 Contributing](#-contributing)
- [📄 License](#-license)
- [👏 Acknowledgments](#-acknowledgments)

---


## 📍 Overview

The repository contains a library inventory system. It includes features such as book management, user registration, password reset, and inventory display. The codebase consists of Java classes for various functionalities like book, user, inventory table, registration form, login window, password reset form, and GUI. It also includes utility classes for look and feel configuration and XML files for view layouts.

---

## 📦 Features

- **User Authentication**: Secure login and registration system with the ability to reset passwords.
- **Inventory Management**: Add, remove, and update books in the inventory.
- **Search and Filter**: Locate books quickly and filter by genre or other criteria.
- **Persistent Storage**: Book and user data are stored persistently on the file system.
- **User Interface**: A clean and intuitive GUI for interacting with the system.

---


## 📂 Repository Structure

```sh
└── library-inventory-system/
    ├── mvnw
    ├── mvnw.cmd
    ├── src/
    │   └── main/
    │       ├── java/
    │       └── resources/
    └── users.txt

```

---


## ⚙️ Modules

<details closed><summary>Root</summary>

| File                                                                                    | Summary                                                                                                                                                                                                                                                                                                                                                                                              |
| ---                                                                                     | ---                                                                                                                                                                                                                                                                                                                                                                                                  |
| [mvnw.cmd](https://github.com/marislakss/library-inventory-system/blob/main/mvnw.cmd)   | The code is a batch script that serves as a start-up script for Apache Maven. It sets up the necessary environment variables, validates the Java installation, detects the project base directory, and downloads the Maven wrapper if necessary. Finally, it launches Maven with the proper configuration and command-line arguments.                                                                |
| [mvnw](https://github.com/marislakss/library-inventory-system/blob/main/mvnw)           | This code is a script written in the Unix shell language that is used to start up the Maven build tool. It sets up the environment variables required to run Maven and then executes the Maven wrapper main class to start the Maven build process. The script also includes an extension that allows automatically downloading the Maven wrapper JAR if it is not present in the project directory. |
| [users.txt](https://github.com/marislakss/library-inventory-system/blob/main/users.txt) | This code represents a directory tree structure for a library inventory system. It contains the necessary files and folders for building and running the system. The "users.txt" file stores user information in a comma-separated format, including username, password, first name, last name, phone number, email, and a personal description.                                                     |

</details>

<details closed><summary>Java</summary>

| File                                                                                                                | Summary                                                                                                                                                                                                                                                     |
| ---                                                                                                                 | ---                                                                                                                                                                                                                                                         |
| [module-info.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/module-info.java) | This code declares a Java module named "com.example.demo". It requires four external modules: javafx.controls, javafx.fxml, java.desktop, and java.logging. It opens the package "com.example.demo" to javafx.fxml and exports it for other modules to use. |

</details>

<details closed><summary>Demo</summary>

| File                                                                                                                                                       | Summary                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| ---                                                                                                                                                        | ---                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         |
| [Book.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/Book.java)                                     | The given code represents the Book class in a library inventory system. It defines the properties and methods associated with a book object. The properties include id, name, genre, price, quantity, publish, printed, and isbnNumber. The class provides getter and setter methods for each property, allowing access and modification of the book's information.                                                                                                                                                                                                                                                                                                                                                                                                         |
| [InventoryTableModel.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/InventoryTableModel.java)       | The code above defines the InventoryTableModel class, which extends the AbstractTableModel class. This class is used for displaying the inventory of books in a JTable component. It contains a list of books as its data and implements various methods to interact with the table, such as retrieving column names, retrieving and setting cell values, and determining cell editability. It uses an enum to define the column names and indices for easy reference.                                                                                                                                                                                                                                                                                                      |
| [RegistrationForm.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/RegistrationForm.java)             | The code above is a Java program that implements a registration form GUI (Graphical User Interface). It allows users to input their information such as username, password, first name, last name, contact number, email, and security question. The program then checks if the entered username is already taken by reading user records from a text file called "users.txt". If the username is available, a new user record is created and appended to the file. If the username is already taken, an error message is displayed. The program also includes a cancel button that clears the input fields and closes the registration form window. The core functionality revolves around validating usernames, saving user records, and displaying messages to the user. |
| [LoginWindow.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/LoginWindow.java)                       | A Swing-based interface class for user authentication, providing login, registration, and password reset functionality within the Library Inventory System.                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
| [User.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/User.java)                                     | The code defines a User class with instance variables for username, password, security question, and security answer. It includes a constructor to initialize these variables and getter/setter methods for accessing and modifying the variables. The encapsulation principle is utilized to hide the object's internal state and expose only necessary information.                                                                                                                                                                                                                                                                                                                                                                                                       |
| [ResetPasswordForm.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/ResetPasswordForm.java)           | The code represents a GUI form for resetting a user's password. It allows the user to enter their username, old password, new password, and security question. Upon clicking the "Reset Password" button, the code validates the user's information against a text file ("users.txt") containing user data. If the information matches, the code updates the user's password in the text file. If not, an error message is displayed.                                                                                                                                                                                                                                                                                                                                       |
| [InventoryManagementGUI.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/InventoryManagementGUI.java) | The code above defines a GUI (Graphical User Interface) for an inventory management system. It includes UI components such as text fields, combo boxes, and a table. The GUI allows users to add, update, and remove books from the inventory. It also provides functionality to display the inventory in a table format and performs validations on user inputs. The code utilizes constants for genres, fonts, colors, column names, and error/success messages. It also logs events using a logger object. The inventory is stored in an ArrayList<Book> and is initially populated with two books.                                                                                                                                                                      |
| [LookAndFeelUtil.java](https://github.com/marislakss/library-inventory-system/blob/main/src/main/java/com/example/demo/LookAndFeelUtil.java)               | The code is a utility class called "LookAndFeelUtil" which provides methods to configure the LookAndFeel of the application. It has a private constructor to prevent instantiation, and a "setLookAndFeel" method that sets the LookAndFeel of the application to Nimbus, if available. The code uses the Logger class for logging any errors that occur while setting the LookAndFeel.                                                                                                                                                                                                                                                                                                                                                                                     |
| [hello-view.fxml](https://github.com/marislakss/library-inventory-system/blob/main/src/main/resources/com/example/demo/hello-view.fxml)                    | The code snippet is an XML file that represents the layout for a JavaFX application view. It includes a VBox container with a Label and a Button. The VBox is centered and has a spacing of 20. The Label has an ID of "welcomeText" and the Button has a text of "Hello!" with an event handler for the "onHelloButtonClick" action. The XML also specifies padding for the VBox. This code is likely part of a larger JavaFX application for displaying a welcome screen with a button.                                                                                                                                                                                                                                                                                   |

</details>

---

## 🚀 Getting Started


### 🔧 Installation

1. Clone the library-inventory-system repository:
```sh
git clone https://github.com/marislakss/library-inventory-system.git
```

2. Change to the project directory:
```sh
cd library-inventory-system
```

3. Install the dependencies:
```sh
mvn clean install
```

### 🤖 Running library-inventory-system

```sh
java -jar target/myapp.jar
```

---

## 🤝 Contributing

Contributions are welcome! Here are several ways you can contribute:

- **[Submit Pull Requests](https://github.com/marislakss/library-inventory-system/blob/main/CONTRIBUTING.md)**: Review open PRs, and submit your own PRs.
- **[Join the Discussions](https://github.com/marislakss/library-inventory-system/discussions)**: Share your insights, provide feedback, or ask questions.
- **[Report Issues](https://github.com/marislakss/library-inventory-system/issues)**: Submit bugs found or log feature requests for MARISLAKSS.

#### *Contributing Guidelines*

<details closed>
<summary>Click to expand</summary>

1. **Fork the Repository**: Start by forking the project repository to your GitHub account.
2. **Clone Locally**: Clone the forked repository to your local machine using a Git client.
   ```sh
   git clone <your-forked-repo-url>
   ```
3. **Create a New Branch**: Always work on a new branch, giving it a descriptive name.
   ```sh
   git checkout -b new-feature-x
   ```
4. **Make Your Changes**: Develop and test your changes locally.
5. **Commit Your Changes**: Commit with a clear and concise message describing your updates.
   ```sh
   git commit -m 'Implemented new feature x.'
   ```
6. **Push to GitHub**: Push the changes to your forked repository.
   ```sh
   git push origin new-feature-x
   ```
7. **Submit a Pull Request**: Create a PR against the original project repository. Clearly describe the changes and their motivations.

Once your PR is reviewed and approved, it will be merged into the main branch.

</details>

---

## 📄 License


This project is protected under the [MIT](https://choosealicense.com/licenses) License.

---

## 👏 Acknowledgments

- [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Java Serialization](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html)
- [Nimbus Look and Feel](https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html)

[**Return**](#Top)

---

