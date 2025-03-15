package model;

import java.util.Arrays;

public class UniversitySystemDemo {
    public static void main(String[] args) {

        University myUniversity = new University("UNEC", 100, 5);

        Student s1 = new Student("S002", "Turkan Basirli", 21, "Information Security");
        Student s2 = new Student("S003", "Mansura Badalova", 19, "Computer Science");
        Student s3 = new Student("S001", "Rasul Huseynli", 20, "Information Security");

        Professor p1 = new Professor("P001", "Ramal Cabbarov", 40, "Digital Economy");
        Professor p2 = new Professor("P002", "Roza Misirli", 65, "Digital Economy");

        Course c1 = new Course(1, "Java Programming", p1);
        Course c2 = new Course(2, "Python Programming", p2);

        myUniversity.addPeople(s1);
        myUniversity.addPeople(s2);
        myUniversity.addPeople(s3);
        myUniversity.addPeople(p1);
        myUniversity.addPeople(p2);

        myUniversity.addCourses(c1);
        myUniversity.addCourses(c2);

        s1.enrollCourses(c1);
        s1.enrollCourses(c2);

        c1.addStudents(s1);
        c2.addStudents(s1);

        System.out.println(Arrays.toString(c1.getStudents()));


    }
}
