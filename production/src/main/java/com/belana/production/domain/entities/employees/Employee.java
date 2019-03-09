package com.belana.production.domain.entities.employees;

import com.belana.production.domain.entities.base.UUIDStringEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

//@Getter
//@Setter
//@NoArgsConstructor
//@Entity
//@Table(name = "employees", schema = "belana_employees_db")
public class Employee extends UUIDStringEntity {

    private String firstName;
    private String middleName;
    private String familyName;
    private String position;
    private Date startedAt;
    private Date leaveAt;
    private int individualNumber;
    private BigDecimal salary;

}
