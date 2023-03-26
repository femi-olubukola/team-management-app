package com.example.persistence.model;

import java.time.LocalDate;
import java.util.Random;

@Entity
public class Project {

    @Id
    private Long id;
    private String name;
    private LocalDate dateCreated;

    public Project() {

    }
    public Project(String name, LocalDate dateCreated) {
        this.id = new Random().nextLong();
        this.name = name;
        this.dateCreated = dateCreated;
    }

    public Project(Project project) {
        this(project.getName(), project.getDateCreated());
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        if (!id.equals(project.id)) return false;
        if (!name.equals(project.name)) return false;
        return dateCreated.equals(project.dateCreated);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + dateCreated.hashCode();
        return result;
    }
}
