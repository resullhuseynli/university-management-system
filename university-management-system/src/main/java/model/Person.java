package model;

import java.util.Objects;

public abstract class Person {

    private String id;
    private String fullName;
    private int age;

    public Person() {
    }

    public Person(String id, String fullName, int age) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age <= 0) {
            System.out.println("Age cannot be negative.");
        } else {
            this.age = age;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) && age == person.age && Objects.equals(fullName, person.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, age);
    }

    @Override
    public String toString() {
        return "Person: " + '\n' +
                "ID: " + id + '\n' +
                "Full Name: " + fullName + '\n' +
                "Age: " + age;
    }
}
