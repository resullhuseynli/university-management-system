package model;

public class University {

    private String name;

    private Person[] people;

    private Course[] courses;

    public University() {
    }

    public University(String name, Integer peopleCount, Integer courseCount) {
        this.name = name;
        this.people = new Person[peopleCount];
        this.courses = new Course[courseCount];
    }

    public void addPeople(Person person) {

        if (people == null) {
            people = new Person[1];
            people[0] = person;
        } else {
            Person[] newPeople = new Person[people.length + 1];
            for (int i = 0; i < people.length; i++) {
                newPeople[i] = people[i];
            }
            newPeople[people.length] = person;
            people = newPeople;
        }
    }

    public String getPeople() {
        StringBuilder result = new StringBuilder();
        for (Person person : people) {
            result.append(person.getName()).append(" ").append(person.getSurname()).append("\n");
        }
        return result.toString();
    }

    public void addCourses(Course course) {

        if (courses == null) {
            courses = new Course[1];
            courses[0] = course;
        } else {
            Course[] newCourses = new Course[courses.length + 1];
            for (int i = 0; i < courses.length; i++) {
                newCourses[i] = courses[i];
            }
            newCourses[courses.length] = course;
            courses = newCourses;
        }
    }

    public String getName() {
        return name;
    }
}
