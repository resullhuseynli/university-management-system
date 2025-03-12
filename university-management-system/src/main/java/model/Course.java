package model;

public class Course {

    private Integer courseCode;

    private String courseName;

    private Student[] students;

    private Professor professor;

    public Course() {

    }

    public Course(Integer courseCode, String courseName, Student[] students, Professor professor) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.students = students;
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


}
