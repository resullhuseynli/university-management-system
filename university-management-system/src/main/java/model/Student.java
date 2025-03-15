package model;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person {

    private String major;

    private Course[] courses;

    private Double[] grades;

    public Student() {
    }

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
            grades = new Double[1];
        } else {
            Course[] newCourses = new Course[courses.length + 1];
            Double[] newGrades = new Double[grades.length + 1];
            for (int i = 0; i < courses.length; i++) {
                newCourses[i] = courses[i];
                newGrades[i] = grades[i];
            }
            newCourses[courses.length] = course;
            this.courses = newCourses;
            this.grades = newGrades;
        }
    }

    public void updateGrades(int courseCode, Double newGrade) {

        for (int i = 0; i < courses.length; i++) {
            if (courses[i].getCourseCode() == courseCode) {
                grades[i] = newGrade;
                return;
            }
        }
        System.out.println("Course not found");
    }


    public void updateGrades(String courseName, Double newGrade) {

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                System.out.println("Course not found");
                break;
            }
            if (courses[i].getCourseName().equalsIgnoreCase(courseName.trim())) {
                grades[i] = newGrade;
                break;
            }
        }
    }

    public Double getGPA() {
        double sum = 0.0;
        for (Double grade : grades) {
            if (grade == null) {
                break;
            }
            sum += grade;
        }
        return sum / grades.length;
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(major, student.major) && Objects.deepEquals(courses, student.courses) && Arrays.equals(grades, student.grades);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), major, Arrays.hashCode(courses), Arrays.hashCode(grades));
    }

    @Override
    public String toString() {
        return "\nStudent:" + '\n' +
                "Name: " + getFullName() + '\n' +
                "Age: " + getAge() + '\n' +
                "Major: " + major + '\n' +
                "Courses: " + (courses==null ? "There is no course!" : getCourseList()) +
                "Grades: " + (grades==null ? "There is no grade!" : Arrays.toString(grades));
    }

    private String getCourseList() {
        StringBuilder result = new StringBuilder();
        for (Course course : courses) {
            if (course == null) {
                break;
            }
            result.append(course.getCourseName()).append("\n");
        }
        return result.toString();
    }
}
