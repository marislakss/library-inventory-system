# Library Inventory System

The Library Inventory System is a Java-based application that allows users to manage a book inventory through a graphical user interface (GUI). It supports operations such as adding new books, updating existing information, tracking inventory levels, and user authentication.

## Features

- **User Authentication**: Secure login and registration system with the ability to reset passwords.
- **Inventory Management**: Add, remove, and update books in the inventory.
- **Search and Filter**: Locate books quickly and filter by genre or other criteria.
- **Persistent Storage**: Book and user data are stored persistently on the file system.
- **User Interface**: A clean and intuitive GUI for interacting with the system.

## Getting Started

### Prerequisites

Before running the Library Inventory System, ensure you have the following installed:
- Java Development Kit (JDK) 8 or higher

### Installation

To set up the Library Inventory System on your local machine, follow these steps:

1. Clone the repository or download the source code:
```git clone https://github.com/marislakss/library-inventory-system.git```
   Or download the ZIP and extract it.
2. Navigate to the source code directory:
```cd path/to/library-inventory-system```
3. Compile the Java files. Make sure to compile from the root directory of your project:
```javac -d bin src/com/example/demo/*.java```
   Adjust the `src/com/example/demo/` path according to your package structure.
4. Run the `InventoryManagementGUI` class to start the application:
```java -cp bin com.example.demo.InventoryManagementGUI```


## Usage

After starting the application, you can:

- **Login/Register**: New users can create an account, and existing users can log in.
- **Manage Books**: Add, update, or remove books from the inventory.
- **Search**: Locate books using the search functionality.
- **Logout**: Securely exit the application.

## Contributing

To contribute to the Library Inventory System:

1. Fork the repository.
2. Create your feature branch (`git checkout -b feature/AmazingFeature`).
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`).
4. Push to the branch (`git push origin feature/AmazingFeature`).
5. Open a pull request.

## License

Distributed under the MIT License. See `LICENSE` for more information.

## Acknowledgements

- [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/)
- [Java Serialization](https://docs.oracle.com/javase/tutorial/jndi/objects/serial.html)
- [Nimbus Look and Feel](https://docs.oracle.com/javase/tutorial/uiswing/lookandfeel/nimbus.html)
   



