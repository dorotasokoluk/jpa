package io.mbab.sda.sdajpa17.rest;

import io.mbab.sda.sdajpa17.entity.Employee;
import io.mbab.sda.sdajpa17.repository.CustomCrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController extends AbstractController <Employee, Long>  {

    public EmployeeController(CustomCrudRepository<Employee, Long> crudRepository) {

        super(crudRepository);
    }
}
