package com.bikleek.apirest.services;

import com.bikleek.apirest.models.Employee;
import com.bikleek.apirest.repositories.EmployeeRepository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements BaseService<Employee>{
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	/*public EmployeeService(IEmployeeRepository employeeRepository){
		this.employeeRepository = employeeRepository;
	}*/

	@Override
	@Transactional
	public List<Employee> findAll() throws Exception {
		try{
			List<Employee> entities = employeeRepository.findAll();
			return entities;
		} catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public Employee findById(Long id) throws Exception {
		try{
			Optional<Employee> entityOptional = employeeRepository.findById(id);
			return entityOptional.get();
		} catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public Employee save(Employee entity) throws Exception {
		try{
		entity = employeeRepository.save(entity);
		return entity;
		} catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public Employee update(Long id, Employee entity) throws Exception {
		try{
			Optional<Employee> entityOptional = employeeRepository.findById(id);
			Employee employee = entityOptional.get();
			employee =employeeRepository.save(entity);
			return employee;
		} catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
	}

	@Override
	@Transactional
	public boolean delete(Long id) throws Exception {
		try{
			if(employeeRepository.existsById(id)) {
				employeeRepository.deleteById(id);
				return true;
			}
			else {
				throw new Exception();
			}
		} catch (Exception ex){
			throw new Exception(ex.getMessage());
		}
	}
}
