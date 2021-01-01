package Clients;

import Reporting.EmployeeReportFormatter;
import Reporting.FormatType;
import domain.DAO.EmployeeDAO;
import domain.Employee;

public class ClientModule {

    public static void main(String args[]){
        Employee peggy = new Employee(1, "peggy", "accounting", true);
        ClientModule.hireNewEmployee(peggy);
        printEmployeeReport(peggy, FormatType.XML);
    }


    public static void hireNewEmployee(Employee employee){
         EmployeeDAO employeeDAO = new EmployeeDAO();
         employeeDAO.saveEmployee(employee);

     }

     public static void printEmployeeReport(Employee employee, FormatType formatType){
         EmployeeReportFormatter formatter = new EmployeeReportFormatter(employee, formatType);
         System.out.println(formatter.getFormattedEmployee());


     }
}
