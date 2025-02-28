# Task 3: Web UI (React 19 + TypeScript + Ant Design)

This **React** project provides a **Web UI** for the **Task Manager** application created in **Task 1** (Java Backend). It allows you to **create**, **show**, **search**, **delete** records from your UI.

---

## **1. Prerequisites**

1. **Node.js** (v16 or higher recommended)
2. **npm** (comes with Node.js)
3. **Backend API** (Spring Boot + MongoDB) running at `http://localhost:8080/api/tasks`.

---

## **2. How It Works**

**AddTaskForm:** Allows you to create a new task.
**TaskTable:** Displays the list of tasks from the backend, with buttons to delete tasks or run commands.
**api.ts:** Contains the Axios calls to the Spring Boot API.
**GET /api/tasks** → Retrieve tasks
**POST /api/tasks** → Create task
**DELETE /api/tasks/:id** → Delete task
**PUT /api/tasks/:id/execute** → Run command

## **3. How to Run**
1. npm start in Terminal.
2. Open http://localhost:3000 in browser.

## **4. Screenshots**

![Home UI](https://github.com/user-attachments/assets/a085db2a-f147-4bd1-a4ce-a5543686286c)
The above image show the Frondend of the Web form. 

---

![After a TASK is ADDED](https://github.com/user-attachments/assets/ee663b6e-3766-4e4a-9e5f-9d77e29cdf01)
The above image is after adding a task

---

![Deleted a Task](https://github.com/user-attachments/assets/d970780f-84b3-44c8-a204-38afc60fecc9)
The image is after removing a task
