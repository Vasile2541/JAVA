package com.step.jdbc;

import java.sql.SQLException;
import java.util.List;

public class App {
    public static void main(String[] args) throws SQLException {
        EmployeeDao dao = new EmployeeDao();

        // save to DB
        System.out.println( dao.create(new Employee("Vasile", "Codreanu")) );

        //read all from DB
        List<Employee> employeeList = dao.readAll();

        // update using employee obj
        Employee emp = employeeList.get(0);
        System.out.println(emp);
        emp.setName("Jim");
        emp.setSurname("Smith");
        dao.update( emp );
        // update using fields of obj
        dao.update( 2, "nick", "Jonson" );

        // delete employee by id
        dao.delete(4);

        // read all from DB
        for(Employee e: dao.readAll()){
            System.out.println(e);
        };
    }
}
