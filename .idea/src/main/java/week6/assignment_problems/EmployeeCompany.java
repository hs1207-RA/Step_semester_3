package week6.assignment_problems;

public class EmployeeCompany {
    String empName;
    double salary;

    static String companyName = "Bright Horizon Technologies";
    static int employeeCount = 0;

    public EmployeeCompany(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }

    public static void main(String[] args) {
        new EmployeeCompany("Ravi", 50000);
        new EmployeeCompany("Anitha", 60000);
        new EmployeeCompany("Karthik", 55000);

        EmployeeCompany.printCompanyInfo();
    }
}
