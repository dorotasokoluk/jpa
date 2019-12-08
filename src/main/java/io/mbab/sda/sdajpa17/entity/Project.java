package io.mbab.sda.sdajpa17.entity;

import javax.persistence.*;

@Entity
public class Project extends AbstractEntity<Long> {

    @Column(unique = true, nullable = false)
    private String name;

    @Column(length = 31)
    private String type;

    private String client;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", client='" + client + '\'' +
                '}';
    }
}
