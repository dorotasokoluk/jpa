package io.mbab.sda.sdajpa17.entity;

import javax.persistence.*;

@Entity
public class Position extends AbstractEntity<Long> {

    @Column(unique = true, nullable = false, length = 64)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                '}';
    }
}
