
# Hostel Management System (Java, Hibernate, MySQL)
The Hostel Management System is a Java application designed to streamline hostel management operations, facilitating efficient management of hostels and Customers. It allows Admin to approve landlords and landlords to list their available properties based on preferences such as location and rental options where Customers can get details of Hostels, Rooms, book and cancel room. It utilizes Hibernate as an Object-Relational Mapping (ORM) tool and MySQL as the database management system. The application defines Hibernate CRUD operations with all entities and Object-Relational Mapping such as @OneToMany, @ManyToOne between all entities.
# Features
<b>Hostel Management : </b> Maintain records of hostel residents, including personal information, room allocation, and checkIn checkOut status.<br>
<b>Admin Role : </b> Admin can review and approve landlords who have available hostels and rooms for rent.<br>
<b>Landlord Role : </b> Landlords can add details of their available hostels and rooms, rent, and occupancy status.<br>
<b>Hostel Entity : </b> Store information about hostels, including name, location, number of rooms and ratings.<br>
<b>Customer Role : </b> Upon approval by the landlord, customers can complete the booking process and check-in and check-out to the hostel.<br>
<b>Room Allocation : </b> Automatically assign rooms to customers based on availability and preferences like room price, status.<br>
<b>Booking : </b> Admin can access all Booking details related to Hostels, Rooms and Customers.
# Technologies Used
<ul>
  <li>Java</li>
  <li>Hibernate</li>
  <li>MySQL</li>
</ul>

# Installation

1. **Install Prerequisites**: Ensure you have JDK, Maven, and MySQL database server installed on your system.

2. **Configure Database Connection**: Modify the `persistence.xml` file located in `src/main/resources/META-INF` to configure your database connection settings. Update the `<property>` tags with your database URL, username, and password.

3. **Include Dependencies**: Make sure to include the necessary dependencies for Hibernate and MySQL in the `pom.xml` file. Here's an example snippet:

    ```xml
    <!-- Hibernate ORM with JPA EntityManager -->
    <dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.6.15.Final</version>
	 </dependency>
    <!-- MySQL Connector -->
    <dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.28</version>
		</dependency>
    ```

    Replace `<!-- Your Hibernate version -->` and `<!-- Your MySQL Connector version -->` with the appropriate version numbers.

4. **Build the Project**: Use Maven to build the project:

    ```
    mvn clean install
    ```

5. **Clone the Repository**: Clone the repository to your local machine:

    ```
    git clone https://github.com/your-username/hostel-management-system.git
    ```

6. **Navigate to Project Directory**: Change directory to the project folder:

    ```
    cd hostel-management-system
    ```

Once you've followed these steps, your Hostel Management System should be set up and ready to use.
# ER Diagram
![HostelmgtsystmERdigm](https://github.com/DivyaKanapuriya/HostelManagementSystem/assets/130472104/15a005b1-49fe-4ba0-a425-2e5a88d2b8b0)

# Usage and Functionality
<ul>
 <li>CRUD Operations with All Entity</li>
 <li>Read All Entity List</li>
 <li>Admin login</li>
 <li>Customer register/login</li>
 <li>Admin - approve landlord</li>
 <li>Admin - Read Booking Details </li>
 <li>Customer - Read Landlords, Hostels and Rooms details </li>
 <li>Customer - Book Room and save Booking details</li>
 <li>Customer - Cancel Booking</li>
</ul>

# Future Scope
The application will have an enhanced authentication system, advanced user interface, and rental fee payment integration. In addition, future enhancements may include implementing additional features for room management, such as room availability notifications and other advance features and functionality.

