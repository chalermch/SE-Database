package model;

public class Employee {
    
    private int employeeid;
    private String filename;
    private String lastname;
    private String password;
    private int age;
    private String address;
    private String workstatus;
    private int employeelevel;
    
    public Employee(){

    }

    public Employee(int employeeid , String filename , String lastname , String password , int age , String address , String workstatus , int employeelevel){
        this.employeeid = employeeid;
        this.filename = filename;
        this.lastname = lastname;
        this.password = password;
        this.age = age;
        this.address = address;
        this.workstatus = workstatus;
        this.employeelevel = employeelevel;
    }

    public int getEmployeeID() {
        return employeeid;
    }

    public void setEmployeeID(int employeeid) {
        this.employeeid = employeeid;
    }

    public String getFileName() {
        return filename;
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }

    public String getLastName() {
        return lastname;
    }

    public void setLastName(String lastname) {
        this.lastname = lastname;
    }

    public String getPasswordEmp() {
        return password;
    }

    public void setPasswordEmp(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWorkStatus() {
        return workstatus;
    }

    public void setWorkStatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public int getEmployeeLevel() {
        return employeelevel;
    }

    public void setEmployeeLevel(int employeelevel) {
        this.employeelevel = employeelevel;
    }
}
