package model;

import java.util.Arrays;
import java.util.Objects;

public class Course {

    private int courseCode;

    private String courseName;

    private Student[] students;

    private Professor professor;

    public Course() {
    }

    public Course(int courseCode, String courseName, Professor professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.professor = professor;
    }

    public void addStudents(Student student) {

        if (students == null) {
            students = new Student[1];
            students[0] = student;
        } else {
            Student[] newStudents = new Student[students.length + 1];
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }
            newStudents[students.length] = student;
            students = newStudents;
        }
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Student[] getStudents() {
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(courseCode, course.courseCode) && Objects.equals(courseName, course.courseName) && Objects.deepEquals(students, course.students) && Objects.equals(professor, course.professor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, Arrays.hashCode(students), professor);
    }

    @Override
    public String toString() {
        return "Course: " + '\n' +
                "Course Code: " + courseCode + '\n' +
                "Course Name: " + courseName + '\n' +
                "Students: " + Arrays.toString(students) + '\n' +
                "Professor: " + professor;
    }
}
