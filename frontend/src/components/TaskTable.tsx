import React, { useEffect, useState } from "react";
import { Table, Button, message } from "antd";
import { getTasks, deleteTask } from "../services/api";

const TaskTable: React.FC = () => {
  const [tasks, setTasks] = useState([]);

  useEffect(() => {
    loadTasks();
  }, []);

    const loadTasks = async () => {
        try {
        const data = await getTasks();
        console.log("Fetched Tasks:", data); // Debugging line
        setTasks(data);
        } catch (error) {
        console.error("Error fetching tasks:", error);
        message.error("Failed to load tasks");
        }
    };
  

  const handleDelete = async (id: string) => {
    try {
      await deleteTask(id);
      message.success("Task deleted!");
      loadTasks();
    } catch (error) {
      message.error("Failed to delete task");
    }
  };

  const columns = [
    { title: "Name", dataIndex: "name", key: "name" },
    { title: "Command", dataIndex: "command", key: "command" },
    {
      title: "Actions",
      render: (task: any) => (
        <Button danger onClick={() => handleDelete(task.id)}>Delete</Button>
      ),
    },
  ];

  return <Table dataSource={tasks} columns={columns} rowKey="id" />;
};

export default TaskTable;
