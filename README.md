# Library Management System

## Overview
This is a **console-based Library Management System** developed in **Java**. It allows users to manage books and library members, including borrowing and returning books. The project demonstrates **Object-Oriented Programming (OOP) concepts** such as **classes, objects, encapsulation, collections, and HashMaps**.

---

## Features
1. **Add Books**
   - Add new books with a unique ID, name, and author.
   - Prevents adding duplicate books.
2. **Add Members**
   - Register new members with a unique ID and name.
   - Prevents adding duplicate members.
3. **Borrow Books**
   - Members can borrow available books.
   - Prevents borrowing already borrowed books.
4. **Return Books**
   - Members can return books they have borrowed.
   - Updates book availability automatically.
5. **Display Books**
   - Shows all books along with their status (Available/Borrowed).
6. **Display Members**
   - Shows all registered members and the number of books they have borrowed.
7. **Exit**
   - Safely exits the system.

---

## Technologies Used
- Java 8+
- Collections Framework (`ArrayList`, `HashMap`)
- OOP Concepts: Classes, Objects, Encapsulation, Method Overriding

---

## Classes
1. **Book**
   - Fields: `bname` (book name), `bid` (book ID), `a_name` (author), `isAvailable` (status)
   - Methods: `toString()`, `equals()`, `hashCode()`
2. **Member**
   - Fields: `m_name` (member name), `m_id` (member ID), `borrow` (list of borrowed books)
   - Methods: `toString()`
3. **Library_Management**
   - Main class with `HashMap` to store books and members
   - Methods for adding books/members, borrowing, returning, and displaying

---

## How to Run
1. Clone the repository or download the source code.
2. Compile the Java program:
   ```bash
   javac Library_Management.java