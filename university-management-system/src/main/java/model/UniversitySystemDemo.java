package model;

public class UniversitySystemDemo {
    public static void main(String[] args) {

        University myUniversity = new University("University of Economics", 100, 10);

        Student student1 = new Student("S001", "John Doe", 20, "Computer Science");
        Student student2 = new Student("S002", "Jane Doe", 21, "Computer Science");
        Professor professor1 = new Professor("P001", "Dr. John Doe", 40, "Computer Science");
        Course course1 = new Course("CS101", "Introduction to Computer Science", professor1);

        professor1.addSubjects("Calculus");

        student1.enrollCourses(course1);
        student2.enrollCourses(course1);
        course1.addStudents(student1);
        course1.addStudents(student2);

        myUniversity.addPeople(student1);
        myUniversity.addPeople(student2);
        myUniversity.addPeople(professor1);
        myUniversity.addCourses(course1);

        System.out.println(myUniversity.getPeople());

    }
}
