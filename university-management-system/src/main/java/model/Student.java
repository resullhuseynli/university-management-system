package model;

public class Student extends Person {

    private String major;

    private String[] courses;

    private Double grades;

    public Student() {}

    public Student(int id, String name, String surname, int age, Double grades,String major) {
        super(id, name, surname, age);
        this.grades = grades;
        this.major = major;
    }

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

    public void enrollCourses(String course) {

        if (courses == null) {
            courses = new String[1];
            courses[0] = course;
        } else {
            String[] newCourses = new String[courses.length + 1];
            for (int i = 0; i < courses.length; i++) {
                newCourses[i] = courses[i];
            }
            newCourses[courses.length] = course;
            this.courses = newCourses;
        }
    }

    public Double getGrades() {
        return grades;
    }

    public void setGrades(Double grades) {
        this.grades = grades;
    }
}
