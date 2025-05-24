package com.fullstack.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack.model.Employee;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

	List<Employee> employees = Stream.of(new Employee(121, "SWARA", 97000.96), new Employee(122, "POOJA", 17000.96),
			new Employee(123, "LAKSHMI", 91000.96), new Employee(124, "RAJESH", 99000.96),
			new Employee(125, "POOJA", 96000.96)).toList();

	
	
	@GetMapping("/findall")
	public ResponseEntity<List<Employee>> findAll() {
		return ResponseEntity.ok(employees);
	}

	@GetMapping("/sortbyname")
	public ResponseEntity<List<Employee>> sortByName() {
		return ResponseEntity.ok(employees.stream().sorted(Comparator.comparing(Employee::getEmpName)).toList());
	}

	@GetMapping("/sortbysalary")
	public ResponseEntity<List<Employee>> sortBySalary() {
		return ResponseEntity
				.ok(employees.stream().sorted(Comparator.comparing(Employee::getEmpSalary).reversed()).toList());
	}

	@GetMapping("/filterbyname")
	public ResponseEntity<List<Employee>> filterByName(@RequestParam String empName) {
		return ResponseEntity.ok(employees.stream().filter(emp -> emp.getEmpName().equals(empName)).toList());
	}

}
