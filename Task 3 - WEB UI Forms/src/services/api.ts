import axios from "axios";

const API_URL = "http://localhost:8080/api/tasks"; 
 // Change this if backend URL differs

// Fetch all tasks
export const getTasks = async () => {
  const response = await axios.get(API_URL);
  return response.data;
};

// Create a new task
export const createTask = async (task: { name: string; command: string }) => {
  const response = await axios.post(API_URL, task);
  return response.data;
};

// Delete a task
export const deleteTask = async (id: string) => {
  await axios.delete(`${API_URL}/${id}`);
};
