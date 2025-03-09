package model;

public class Student extends Person {

    private String major;

    public Student(int id, String name, String surname, int age, Double grades, String[] courses, String major) {
        super(id, name, surname, age);
        this.grades = grades;
        this.courses = courses;
        this.major = major;
    }

    private String[] courses;

    private Double grades;

    public Student(int id, String name, String surname, int age) {
        super(id, name, surname, age);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String[] getCourses() {
        return courses;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }
}
