package com.sample.controller.impl;

import com.sample.dto.EmployeeDTO;
import com.sample.entity.Employee;
import com.sample.mapper.EmployeeMapper;
import com.sample.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/employee")
@RestController
public class EmployeeControllerImpl  {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeControllerImpl(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDTO save(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.save(employee));
    }


    @GetMapping("/{id}")
    public EmployeeDTO findById(@PathVariable("id") Integer id) {
        Employee employee = employeeService.findById(id).orElse(null);
        return employeeMapper.asDTO(employee);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
    }


    @GetMapping
    public List<EmployeeDTO> list() {
        return employeeMapper.asDTOList(employeeService.findAll());
    }


    @GetMapping("/page-query")
    public Page<EmployeeDTO> pageQuery(Pageable pageable) {
        Page<Employee> employeePage = employeeService.findAll(pageable);
        List<EmployeeDTO> dtoList = employeePage
                .stream()
                .map(employeeMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, employeePage.getTotalElements());
    }


    @PutMapping("/{id}")
    public EmployeeDTO update(@RequestBody EmployeeDTO employeeDTO, @PathVariable("id") Integer id) {
        Employee employee = employeeMapper.asEntity(employeeDTO);
        return employeeMapper.asDTO(employeeService.update(employee, id));
    }
}