package model;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String id;

    public Student() {
    }

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return " Name = '" + name + '\'' +
                " , StudentID = '" + id + '\'' +
                " }";
    }
}
