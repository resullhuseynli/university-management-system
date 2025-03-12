package model;

public class Professor extends Person {

    public String department;
    private String[] subjects;

    public String[] getSubjects() {
        return subjects;
    }

    public Professor() {

    }

    public String[] getSubjectList() {
        return subjects;
    }

    public String[] addSubjects(String subject) {

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
            return subjects;
        }

        return subjects;
    }

}
