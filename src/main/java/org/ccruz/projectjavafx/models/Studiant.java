package org.ccruz.projectjavafx.models;

public class Studiant {
    private int id;
    private String name;
    private String email;
    private String enrollment;

    public Studiant() {}

    public Studiant(String name, String email, String enrollment) {
        this.name = name;
        this.email = email;
        this.enrollment = enrollment;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(String enrollment) {
        this.enrollment = enrollment;
    }

    @Override
    public String toString() {
        return "Studiant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", enrollment='" + enrollment + '\'' +
                '}';
    }
}
