package io.mbab.sda.sdajpa17.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
public class Employee extends AbstractEntity <Long>{

    private Integer age;

    @Column ( nullable = false)
    private String firstName;

    @Column ( nullable = false) // nie może być pusty
    private String lastName;

    @ManyToOne // tworzy nam obiekt position i od razu podstawia, adnotacja wiele do jednego.
    //@ManyToOne(fetch = )eager  zaciągnie dwa obiekty, czyli Employ
    // lezy - najpierw emloy zostanie wyciągnieę wtedy kiegy będzie potrzebne
    private Position position;

    @ManyToOne
    private Project project;

    @OneToMany(
            mappedBy = "employee",//ustalamy co jest rodzicem tej relacji
             cascade = CascadeType.ALL, // jak usuwamy praconwika, to i jego sprzęty zostaną usunięte, jak aktulizuje pracownika to sprzę też się aktualizuje
            orphanRemoval = true // usunie sieroty, tzn jeśli bedzie wpis który nie ma przydzielonego praconwika to usunie taki sprzęt
    )
    private List<Equipment> equipments;

    @ManyToMany() // jak usuniemy skille to wpisy w tabeli łączonej też sie usunął
    @JoinTable(// robimy tabelę łączącą
            name="employee_skill",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")

    )
    private Set<Skill> skills; // w relacji many to many musi być użyty set i ma unikalne wartości. Lista moze zawierać duplikaty


    public void setEquipments (List <Equipment> equipments){
        this.equipments = equipments.stream()
                .peek (  e-> e.setEmployee(this))
                .collect(Collectors.toList());
    }

    public Set<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set<Skill> skills) {
        this.skills = skills;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", position=" + position +
                ", project=" + project +
                '}';
    }
}
