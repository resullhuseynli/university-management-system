package model;

public class University {

    private String universityName;

    private Person[] people;

    private Course[] courses;

    public University() {
    }

    public University(String universityName, Integer peopleCount, Integer courseCount) {
        this.universityName = universityName;
        this.people = new Person[peopleCount];
        this.courses = new Course[courseCount];
    }

    public void addPeople(Person person) {

        for (int i = 0; i < people.length; i++) {

            if (people[i] == null) {
                people[i] = person;
                break;
            }
            if (people[i].getId().equals(person.getId())) {
                System.out.println("Person with this ID already exists");
            }
        }
    }

    public void getPeople() {
        StringBuilder result = new StringBuilder();
        for (Person person : people) {
            if (person == null) {
                break;
            }
            result.append(person.getFullName()).append("\n");
        }
        System.out.println(result);
    }

    public void getPeopleById(String id) {

        for (Person person : people) {
            if (person == null) {
                break;
            }
            if (person.getId().equals(id)) {
                System.out.println(person.getFullName());
            }
        }
        System.out.println("Person not found");
    }

    public void addCourses(Course course) {

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                break;
            }
        }
    }

    public String getUniversityName() {
        return universityName;
    }
}
