package com.step.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/test", "postgresSQL", "password");
        return connection;
    }


    public Employee create(Employee employee) throws SQLException {
        String insert = "INSERT INTO s.qqq(name, surname) values(?,?)";
        try (
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS)
        ) {
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());

            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Error: " + row + " row modified!");
            } else {
                ResultSet result = statement.getGeneratedKeys();
                while (result.next()) {
                    int idEmployee = result.getInt(1);
                    employee.setId(idEmployee);
                    System.out.println("Generated key: " + idEmployee);
                }
            }
        }
        return employee;
    }

    // get all from DB
    public List<Employee> readAll(String name) {
        String sql = "SELECT id, name, surname where name like '%?%'";
        return null;
    }
    //get all employee data from DB
    public List<Employee> readAll() throws SQLException {
        List<Employee> employees = new ArrayList<>();

        Connection connection = getConnection();
        String select = "SELECT id, name, surname FROM s.qqq order by id asc";

        PreparedStatement statement = connection.prepareStatement(select);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next()){
            int id          = resultSet.getInt("id");
            String name     = resultSet.getString("name");
            String surname  = resultSet.getString("surname");
            employees.add(new Employee(id, name, surname));
        }
        statement.close();
        connection.close();
        return employees;
    }


    // update employee by id
    public void update(int id, String name, String surname ) throws SQLException {
        String update = "Update s.qqq set name=?, surname = ? where id = ?";
        try(
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setInt   (3, id);


            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Eroare: " + row + " randuri au fost modificate");
            }else{
                ResultSet result = statement.getGeneratedKeys();
                while( result.next() ){
                    int idEmployee = result.getInt(1);
                    System.out.println("Generated key: "+ idEmployee);
                    System.out.println("successful update");
                }
            }
        }
    }

    public void update(Employee employee ) throws SQLException {
        String update = "Update s.qqq set name = ?, surname = ? where id = ?";
        try(
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(update, Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setInt   (3, employee.getId());

            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("Eroare: " + row + " randuri au fost modificate");
            }else{
                ResultSet result = statement.getGeneratedKeys();
                while( result.next() ){
                    int idEmployee = result.getInt(1);
                    employee.setId(idEmployee);
                    System.out.println("Generated key: "+ idEmployee);
                    System.out.println("successful update");
                }
            }
        }
    }

    // delete employee by id
    public void delete(int id)  throws SQLException {
        String delete = "delete from s.qqq where id = ?";
        try(
            Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(delete, Statement.RETURN_GENERATED_KEYS)
        ){
            statement.setInt   (1, id);
            int row = statement.executeUpdate();
            if (row == 0) {
                System.out.println("unsuccessful delete " + row+" rows modified");

            }else{
                ResultSet result = statement.getGeneratedKeys();
                while( result.next() ){
                    int idEmployee = result.getInt(1);
                    System.out.println("successful delete of id: "+ idEmployee);
                }
            }
        }
    }
}
