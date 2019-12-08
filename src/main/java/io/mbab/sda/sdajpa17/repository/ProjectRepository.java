package io.mbab.sda.sdajpa17.repository;

import io.mbab.sda.sdajpa17.entity.Project;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class ProjectRepository extends AbstractCustomCrudRepository<Project, Long> {

    public ProjectRepository(EntityManager em) {
        super(em, Project.class);
    }

}
