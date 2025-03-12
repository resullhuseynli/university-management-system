package model;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {

    private String major;

    private Course[] courses;

    private Double grades;

    public Student() {}

    public Student(String id, String fullName, int age, String major) {
        super(id, fullName, age);
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        if (this.major != null) {
            return;
        } else {
            this.major = major;
        }
    }

    public Course[] getCourses() {
        return courses;
    }

    public void enrollCourses(Course course) {

        if (courses == null) {
            courses = new Course[1];
            courses[0] = course;
        } else {
            Course[] newCourses = new Course[courses.length + 1];
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(major, student.major) && Objects.deepEquals(courses, student.courses) && Objects.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major, Arrays.hashCode(courses), grades);
    }

    @Override
    public String toString() {
        return "Student:" + '\n' +
                "Major: " + major + '\n' +
                "Courses: " + Arrays.toString(courses) + '\n' +
                "Grades: " + grades;
    }
}
