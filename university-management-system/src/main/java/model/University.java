package model;

import java.util.Arrays;
import java.util.Objects;

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
            } else if (people[i].getId().equals(person.getId())) {
                System.out.println("Person with this ID already exists");
            }
        }
    }

    public String getPeople() {
        StringBuilder result = new StringBuilder();
        for (Person person : people) {
            if (person == null) {
                break;
            }
            result.append(person.getFullName()).append("\n");
        }
        return result.toString();
    }

    public String getPeopleById(String id) {

        for (Person person : people) {
            if (person == null) {
                break;
            }
            if (person.getId().equals(id)) {
                return person.getFullName();
            }
        }
        return "Person not found";
    }

    public void addCourses(Course course) {

        for (int i = 0; i < courses.length; i++) {
            if (courses[i] == null) {
                courses[i] = course;
                break;
            } else if (courses[i].getCourseCode() == course.getCourseCode()) {
                System.out.println("Course with this code already exists");
                break;
            }
        }
    }

    public String getUniversityName() {
        return universityName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        University that = (University) o;
        return Objects.equals(universityName, that.universityName) && Objects.deepEquals(people, that.people) && Objects.deepEquals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(universityName, Arrays.hashCode(people), Arrays.hashCode(courses));
    }

    @Override
    public String toString() {
        return "University: " + '\n' +
                "University Name: " + universityName + '\n' +
                "People: " + Arrays.toString(people) + '\n' +
                "Courses: " + Arrays.toString(courses);
    }
}
