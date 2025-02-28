import React from "react";
import { Layout, Typography } from "antd";
import TaskTable from "./components/TaskTable";
import AddTaskForm from "./components/AddTaskForm";

const { Header, Content } = Layout;

const App: React.FC = () => {
  return (
    <Layout style={{ minHeight: "100vh", padding: "20px" }}>
      <Header style={{ color: "white", fontSize: "24px" }}>Task Manager</Header>
      <Content style={{ padding: "20px" }}>
        <AddTaskForm />
        <TaskTable />
      </Content>
    </Layout>
  );
};

export default App;
