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

    public void addNewStudent(Student student) {
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

    public void addStudents(Student student) {

        if (students == null) {
            students = new Student[1];
            students[0] = student;
        } else {
            for (Student s : students) {
                if (s != null && s.getId().equals(student.getId())) {
                    System.out.println("Student with this ID already exists");
                    return;
                }
            }
            Student[] newStudents = new Student[students.length + 1];
            for (int i = 0; i < students.length; i++) {
                newStudents[i] = students[i];
            }
            newStudents[students.length] = student;
            students = newStudents;
        }
        student.addNewCourse(this);
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

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public double getGPA() {
        double sum = 0.0;
        if (students == null) {
            return 0.0;
        }
        for (Student student : students) {
            if (student == null) {
                break;
            }
            if (student.getCourses() == null) {
                System.out.println("Student has no courses");
                return 0.0;
            }
            for (int i = 0; i < student.getCourses().length; i++) {

                if (student.getCourses()[i] == null) {
                    break;
                }
                if (student.getCourses()[i].getCourseCode() == courseCode) {
                    if (student.getGrades()[i] == null) {
                        System.out.println("Student has no grades");
                        return 0.0;
                    }
                    sum += student.getGrades()[i];
                }
            }
        }
        return sum / students.length;
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
                "Students: " + getStudentNames() + '\n' +
                "Professor: " + professor.getFullName();
    }

    public String getStudentNames() {
        StringBuilder result = new StringBuilder();
        if (students == null) {
            return "No students enrolled";
        }
        for (Student student : students) {
            if (student == null) {
                break;
            }
            result.append(student.getFullName()).append("\n");
        }
        return result.toString();
    }
}
