package com.sample.util;

import com.sample.dto.EmployeeDTO;
import com.sample.entity.Employee;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class EmployeeBuilder {
   public static List<EmployeeDTO> getListDTO(){


       return Arrays.asList(new EmployeeDTO(1,"zaid","ENG",22.34),
               new EmployeeDTO(2,"shaikh","mech",224.34)
               );

    }
    public static List<Employee> getListEntities(){


        return Arrays.asList(new Employee(1,"zaid","ENG",22.34),
                new Employee(2,"shaikh","mech",224.34)
        );

    }

    public static EmployeeDTO getDTO() {
       return new EmployeeDTO(1,"zaid","ENG",22.34);
    }

    public static Employee getEntity() {
       return new Employee(1,"zaid","ENG",22.34);
    }
}
