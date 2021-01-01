package Reporting;

import domain.Employee;

public class EmployeeReportFormatter extends ReportingFormatter{

    public EmployeeReportFormatter(Employee employee, FormatType formatType){
        super(employee, formatType);
    }


    public String getFormattedEmployee(){
        return getFormattedValue();
    }
}
