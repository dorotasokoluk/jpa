package io.mbab.sda.sdajpa17.repository;

import io.mbab.sda.sdajpa17.entity.Employee;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import java.util.List;


@Repository
public class EmployeeRepository extends AbstractCustomCrudRepository<Employee, Long> {
    public EmployeeRepository(EntityManager em) {
        super(em, Employee.class);
    }

    //nadpisujemy metodę findAll po to żeby było mniej zapytań do bazy danych. Opymalizacja
    @Override
    public List<Employee> findAll() {
        return em.createQuery("SELECT e FROM Employee e left join fetch e.position join fetch e.project")
                .getResultList();

    }

    @Override
    public Employee findById(Long id) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> query = criteriaBuilder.createQuery(Employee.class);
        Root<Employee> from = query.from(Employee.class);
        from.fetch("position", JoinType.LEFT);
        from.fetch("project", JoinType.LEFT);// łaczymy, żeby zminiejszyć liczbę zapytań


        Employee employee = em.createQuery(
                query.select(from)
                        .where(criteriaBuilder.equal(from.get("id"), id)))
                .getSingleResult();

        // pobiera dla pracownika jego listę sprzętu i umiejętności
        Hibernate.initialize(employee.getEquipments());
        Hibernate.initialize(employee.getSkills());

        return employee;
    }
}
