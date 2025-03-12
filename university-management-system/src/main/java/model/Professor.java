package model;

import java.util.Arrays;
import java.util.Objects;

public class Professor extends Person {

    private String department;
    private String[] subjects;

    public Professor() {
    }

    public Professor(String id, String fullName, int age, String department) {
        super(id, fullName, age);
        this.department = department;
    }

    public void addSubjects(String subject) {

        if (subjects == null) {
            subjects = new String[1];
            subjects[0] = subject;
        } else {
            String[] newSubjects = new String[subjects.length + 1];
            for (int i = 0; i < subjects.length; i++) {
                newSubjects[i] = subjects[i];
            }
            newSubjects[subjects.length] = subject;
            subjects = newSubjects;
        }
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String[] getSubjects() {
        return subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Professor professor = (Professor) o;
        return Objects.equals(department, professor.department) && Objects.deepEquals(subjects, professor.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department, Arrays.hashCode(subjects));
    }

    @Override
    public String toString() {
        return "Professor:" + '\n' +
                "Department: " + department + '\n' +
                "Subjects: " + Arrays.toString(subjects);
    }
}
