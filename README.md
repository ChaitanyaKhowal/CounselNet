<h1 align="center">📌 Mini-Project-1 – Counsellor Enquiry Management System</h1>

<p align="center">
A Spring Boot-based web application designed to help counsellors manage student enquiries efficiently.<br>
This project demonstrates <b>Spring Boot, JPA, MySQL, Thymeleaf</b>, and the <b>MVC design pattern</b>.
</p>

---

<h2>🚀 Features</h2>

- ✅ **User Authentication** – Counsellors can securely log in and register.  
- ✅ **Dashboard View** – Displays total enquiries, open, enrolled, and lost enquiries at a glance.  
- ✅ **Enquiry Management** – Add, view, edit, and filter enquiries.  
- ✅ **Search & Filter** – Filter enquiries by course, class mode, or status.  
- ✅ **Session Handling** – Ensures only logged-in users can access the system.  
- ✅ **Database Integration** – Data is stored in a MySQL database using JPA and Hibernate.  

---

<h2>🛠️ Tech Stack</h2>

| Technology          | Description                          |
|---------------------|--------------------------------------|
| **Java 17+**        | Core programming language            |
| **Spring Boot 3**   | Backend framework (MVC architecture) |
| **Spring Data JPA** | ORM for database operations          |
| **MySQL**           | Relational database                  |
| **Thymeleaf**       | Template engine for views            |
| **Lombok**          | To reduce boilerplate code           |
| **Maven**           | Build and dependency management      |

---

<h2>📂 Project Structure</h2>


Mini-Project-1
│── src/main/java/com/khowal
│   ├── controller      # Handles HTTP requests
│   ├── dto             # Data Transfer Objects
│   ├── entities        # JPA entities (Counsellor, Enquiry)
│   ├── repository      # DAO layer (JPA Repositories)
│   ├── service         # Business logic
│── src/main/resources
│   ├── templates       # Thymeleaf HTML pages
│   ├── application.properties
└── pom.xml

---

<h2>⚙️ Setup Instructions</h2>

### 1️⃣ Clone the repository
git clone https://github.com/ChaitanyaKhowal/CounselNet.git

cd CounselNet

### 2️⃣ Configure MySQL Database
Create a database in MySQL:
CREATE DATABASE jrtp28;
Update credentials in `application.properties`:
spring.datasource.url=jdbc:mysql://localhost:3306/jrtp28
spring.datasource.username=root
spring.datasource.password=root
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

### 3️⃣ Build and Run the Application
mvn clean install
mvn spring-boot:run

### 4️⃣ Access the Application
Open in browser: http://localhost:8080/

---

<h2>📌 Usage Flow</h2>

1️⃣ Register a Counsellor → `/register`  
2️⃣ Login → `/`  
3️⃣ View Dashboard → `/dashboard`  
4️⃣ Add New Enquiry → `/enq`  
5️⃣ View & Filter Enquiries → `/view-enquiry`  
6️⃣ Edit Enquiry Details → `/edit-enquiry`  
7️⃣ Logout → `/logout`  

---

<h2>📸 Screenshots (Optional)</h2>

*(Add screenshots of your login, dashboard, and view-enquiry pages here for a professional touch.)*

---

<h2>🚧 Future Enhancements</h2>

- 🔒 Password encryption using **BCrypt** for improved security.  
- 📩 Email notifications on enquiry updates.  
- 📊 Export enquiries to **Excel/PDF**.  
- 🌐 REST API version for external integration.  

---

<h2>👨‍💻 Author</h2>

**Chaitanya Khowal**  
📧 Email: [chaitanyakhowal8@gmail.com](mailto:chaitanyakhowal8@gmail.com)  
🔗 LinkedIn: [linkedin.com/in/chaitanya-khowal](https://linkedin.com/in/chaitanya-khowal)
