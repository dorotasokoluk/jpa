package io.mbab.sda.sdajpa17.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"code", "type"}
        )
) // daje nam to, że możemy dodać takie same typy z róznymi kodami
public class Equipment extends AbstractEntity<Long> {


    @Column(nullable = false, updatable = false)
    private String code;

    @Column(nullable = false, updatable = false)
    private String type;

    @Override
    public String toString() {
        return "Equipment{" +
                "code='" + code + '\'' +
                ", type='" + type + '\'' +
                ", employee=" + employee +
                ", id=" + id +
                ", version=" + version +
                '}';
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    @JsonBackReference
    @ManyToOne
    private Employee employee;


    public void setCode(String code) {
        this.code = code;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }



    public String getType() {
        return type;
    }

}
