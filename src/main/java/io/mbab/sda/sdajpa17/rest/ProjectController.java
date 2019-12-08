package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Project;
import io.mbab.sda.sdajpa17.repository.ProjectRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("projects")
public class ProjectController extends AbstractController<Project, Long> {

    public ProjectController(ProjectRepository projectRepository) {

        super(projectRepository);
    }
}
