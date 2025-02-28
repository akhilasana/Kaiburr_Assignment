# Task 1: Java Backend & REST API Example

This **Spring Boot** project implements a REST API to **create**, **search**, **delete**, and **execute** tasks.  
Tasks are stored in **MongoDB**, and each task has:
- **id** (String)
- **name** (String)
- **owner** (String)
- **command** (String)
- **taskExecutions** (List of TaskExecution objects)

---

## **1. Prerequisites**

1. **Java 17** (or higher)  
2. **Maven**  
3. **MongoDB** (running locally on port 27017 or updated in `application.properties`)

---

## **2. How to Run**

1. mvn clean install
2. mvn spring-boot:run
3. **Verify the API is running** at http://localhost:8080

---

## **3. Usage Examples**
## **Create/Update a Task (PUT):**.
curl -X PUT "http://localhost:8080/tasks" \.
     -H "Content-Type: application/json" \.
     -d '{.
       "id": "123",
       "name": "Print Hello",
       "owner": "John Smith",
       "command": "echo Hello World!"
     }'
Response:

![Response of a PUT Task](https://github.com/user-attachments/assets/116209e7-c0d2-4979-8876-871ee4a78c17)

---

## **Get All Tasks (GET):** 
curl -X GET "http://localhost:8080/tasks".
Response:

![Response of a GET Task](https://github.com/user-attachments/assets/d6c08a97-42d9-4837-a446-f46d5758c060)

---

## **Delete a Task (DELETE):**
curl -X PUT "http://localhost:8080/tasks/123/execute".
Response (Example):


## **Showing all tasks in local host:**
![Displaying all tasks in localhost](https://github.com/user-attachments/assets/55c33bba-b167-412f-aacb-063eceb8b2f3)


