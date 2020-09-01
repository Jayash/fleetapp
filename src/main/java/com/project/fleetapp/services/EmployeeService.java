package com.project.fleetapp.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.fleetapp.dto.EmployeeDto;
import com.project.fleetapp.exceptions.FleetappException;
import com.project.fleetapp.models.Country;
import com.project.fleetapp.models.Employee;
import com.project.fleetapp.models.EmployeeType;
import com.project.fleetapp.models.JobTitle;
import com.project.fleetapp.models.State;
import com.project.fleetapp.repositories.CountryRepository;
import com.project.fleetapp.repositories.EmployeeRepository;
import com.project.fleetapp.repositories.EmployeeTypeRepository;
import com.project.fleetapp.repositories.JobTitleRepository;
import com.project.fleetapp.repositories.StateRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	private final EmployeeTypeRepository employeeTypeRepository;
	private final JobTitleRepository jobTitleRepository;
	private final StateRepository stateRepository;
	private final CountryRepository countryRepository;
	
	/*
	 * Return All employee
	 */
	@Transactional
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}
	
	/*
	 * add a new employee
	 */
	@Transactional
	public void save(EmployeeDto employeeDto) {
		
		EmployeeType employeeType = employeeTypeRepository.findById(employeeDto.getEmployeetypeid())
								.orElseThrow(() -> new FleetappException("employeeType not found"));
		
		JobTitle jobTitle = jobTitleRepository.findById(employeeDto.getJobTitleid())
								.orElseThrow(() -> new FleetappException("jobTitle not found"));

		State state = stateRepository.findById(employeeDto.getStateid())
				.orElseThrow(() -> new FleetappException("state not found"));

		Country country = countryRepository.findById(employeeDto.getCountryid())
				.orElseThrow(() -> new FleetappException("country not found"));
		
		Employee employee = mapDtoToObject(employeeDto);
		employee.setCountryid(country);
		employee.setStateid(state);
		employee.setJobTitleid(jobTitle);
		employee.setEmployeetypeid(employeeType);
		employeeRepository.save(employee);
	}
	
	/*
	 * find employee by id
	 */
	@Transactional
	public EmployeeDto findById(Long id) {
		Employee employee = employeeRepository.findById(id).
				orElseThrow(() -> new FleetappException("employee not found"));
		
		return mapObjectToDto(employee);
	}
	
	/*
	 * update employee by id
	 */
	@Transactional
	public void update(EmployeeDto employeeDto) {
		
		LocalDate hire = LocalDate.parse(employeeDto.getHireDate());
		Instant hireDate = hire.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		LocalDate dob = LocalDate.parse(employeeDto.getDateOfBirth());
		Instant dateOfBirth = dob.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		Employee employee = employeeRepository.findById(employeeDto.getId()).
				orElseThrow(() -> new FleetappException("employee not found"));
		
		EmployeeType employeeType = employeeTypeRepository.findById(employeeDto.getEmployeetypeid())
				.orElseThrow(() -> new FleetappException("employeeType not found"));

		JobTitle jobTitle = jobTitleRepository.findById(employeeDto.getJobTitleid())
						.orElseThrow(() -> new FleetappException("jobTitle not found"));
		
		State state = stateRepository.findById(employeeDto.getStateid())
		.orElseThrow(() -> new FleetappException("state not found"));
		
		Country country = countryRepository.findById(employeeDto.getCountryid())
		.orElseThrow(() -> new FleetappException("country not found"));
		
		employee.setEmployeetypeid(employeeType);
		employee.setJobTitleid(jobTitle);
		employee.setCountryid(country);
		employee.setStateid(state);
		employee.setFirstName(employeeDto.getFirstName());
		employee.setLastName(employeeDto.getLastName());
		employee.setOtherName(employeeDto.getOtherName());
		employee.setTitle(employeeDto.getTitle());
		employee.setInitials(employeeDto.getInitials());
		employee.setAadharNumber(employee.getAadharNumber());
		employee.setGender(employeeDto.getGender());
		employee.setMaritalStatus(employeeDto.getMaritalStatus());
		employee.setDateOfBirth(dateOfBirth);
		employee.setCity(employeeDto.getCity());
		employee.setAddress(employeeDto.getAddress());
		employee.setPhone(employeeDto.getPhone());
		employee.setMobile(employeeDto.getMobile());
		employee.setEmail(employeeDto.getEmail());
		employee.setPhoto(employeeDto.getPhoto());
		employee.setHireDate(hireDate);
		
		employeeRepository.save(employee);
	}
	
	public EmployeeDto mapObjectToDto(Employee employee) {
		return EmployeeDto.builder()
				.id(employee.getId())
				.countryid(employee.getCountryid().getId())
				.stateid(employee.getStateid().getId())
				.city(employee.getCity())
				.address(employee.getAddress())
				.phone(employee.getPhone())
				.mobile(employee.getMobile())
				.email(employee.getEmail())
				.employeetypeid(employee.getEmployeetypeid().getId())
				.jobTitleid(employee.getJobTitleid().getId())
				.firstName(employee.getFirstName())
				.lastName(employee.getLastName())
				.otherName(employee.getOtherName())
				.maritalStatus(employee.getMaritalStatus())
				.gender(employee.getGender())
				.dateOfBirth(employee.getDateOfBirth().toString())
				.hireDate(employee.getHireDate().toString())
				.initials(employee.getInitials())
				.aadharNumber(employee.getAadharNumber())
				.photo(employee.getPhoto())
				.title(employee.getTitle())
				.build();
	}
	
	public Employee mapDtoToObject(EmployeeDto employeeDto) {
		
		LocalDate hire = LocalDate.parse(employeeDto.getHireDate());
		Instant hireDate = hire.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		LocalDate dob = LocalDate.parse(employeeDto.getDateOfBirth());
		Instant dateOfBirth = dob.atStartOfDay(ZoneId.of("Europe/Paris")).toInstant();
		
		return Employee.builder()
				.city(employeeDto.getCity())
				.address(employeeDto.getAddress())
				.phone(employeeDto.getPhone())
				.mobile(employeeDto.getMobile())
				.email(employeeDto.getEmail())
				.firstName(employeeDto.getFirstName())
				.lastName(employeeDto.getLastName())
				.otherName(employeeDto.getOtherName())
				.maritalStatus(employeeDto.getMaritalStatus())
				.gender(employeeDto.getGender())
				.dateOfBirth(dateOfBirth)
				.hireDate(hireDate)
				.initials(employeeDto.getInitials())
				.aadharNumber(employeeDto.getAadharNumber())
				.photo(employeeDto.getPhoto())
				.title(employeeDto.getTitle())
				.build();
	}
	
	/*
	 * delete Employee by id
	 */
	@Transactional
	public void delete(Long id) {
		employeeRepository.deleteById(id);
	}
}
