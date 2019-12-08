package io.mbab.sda.sdajpa17.repository;

import io.mbab.sda.sdajpa17.entity.Skill;
import io.mbab.sda.sdajpa17.rest.AbstractController;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class SkillRepository extends AbstractCustomCrudRepository<Skill, Long> {
    public SkillRepository(EntityManager em ) {

        super(em, Skill.class);
    }
}
