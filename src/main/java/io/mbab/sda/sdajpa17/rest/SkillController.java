package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Skill;
import io.mbab.sda.sdajpa17.repository.CustomCrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("skills")
public class SkillController extends AbstractController<Skill, Long> {

    public SkillController(CustomCrudRepository<Skill, Long> crudRepository) {
        super(crudRepository);
    }


}
