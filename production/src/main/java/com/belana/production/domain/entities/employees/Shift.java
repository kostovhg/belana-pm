package com.belana.production.domain.entities.employees;


import com.belana.production.domain.entities.base.UUIDStringEntity;

import java.util.List;

//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "shifts", schema = "belana_employees_db")
public class Shift extends UUIDStringEntity {

    private String name;
    private List<Employee> employeeList;
    private Employee shiftLeader;
}
