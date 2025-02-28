import React, { useState } from "react";
import { Form, Input, Button, message } from "antd";
import { createTask } from "../services/api";

const AddTaskForm: React.FC = () => {
  const [loading, setLoading] = useState(false);

  const onFinish = async (values: { name: string; command: string }) => {
    setLoading(true);
    try {
      await createTask(values);
      message.success("Task created!");
      window.location.reload();
    } catch (error) {
      message.error("Failed to create task");
    } finally {
      setLoading(false);
    }
  };

  return (
    <Form layout="inline" onFinish={onFinish}>
      <Form.Item name="name" rules={[{ required: true, message: "Task Name required!" }]}>
        <Input placeholder="Task Name" />
      </Form.Item>
      <Form.Item name="command" rules={[{ required: true, message: "Command required!" }]}>
        <Input placeholder="Command" />
      </Form.Item>
      <Form.Item>
        <Button type="primary" htmlType="submit" loading={loading}>Add Task</Button>
      </Form.Item>
    </Form>
  );
};

export default AddTaskForm;
