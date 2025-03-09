package model;

public class Professor {
    private String department;
    private String[] subject;

    public Professor(int id, String name,String surname,int age, String department,String[] subject){
        this.department=department;
        this.subject=subject;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}

