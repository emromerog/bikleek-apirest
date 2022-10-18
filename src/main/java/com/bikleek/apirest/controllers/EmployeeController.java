package com.bikleek.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bikleek.apirest.models.Employee;
import com.bikleek.apirest.services.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	/*public EmployeeController(EmployeeService employeeService){
		this._employeeService = employeeService;
	}*/
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findAll());
		} catch (Exception ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> get(@PathVariable Long id){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.findById(id));
		} catch (Exception ex){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
	
	@PostMapping("")
	public ResponseEntity<?> save(@RequestBody Employee employee){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.save(employee));
		} catch (Exception ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Employee entity){
		try{
			return ResponseEntity.status(HttpStatus.OK).body(employeeService.update(id, entity));
		} catch (Exception ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		try{
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(employeeService.delete(id));
		} catch (Exception ex){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error. Por favor intente más tarde.\"}");
		}
	}
}
