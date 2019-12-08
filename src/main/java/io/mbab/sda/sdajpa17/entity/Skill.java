package io.mbab.sda.sdajpa17.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Skill extends AbstractEntity<Long> {
    @Column  (unique = true)
    private String name;

    @Override
    public String toString() {
        return "Skill{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
