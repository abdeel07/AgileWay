package com.stdev.AgileWay.mappers;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.stdev.AgileWay.entities.Employee;
import com.stdev.AgileWay.models.requests.EmployeeRequest;
import com.stdev.AgileWay.models.responses.EmployeeResponse;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);
	
	Employee employeeRequestToEmployee(EmployeeRequest employeeRequest);
	
	EmployeeResponse employeeToEmployeeResponse(Employee employee);
	
	List<EmployeeResponse> mapEmployee(List<Employee> employees);
}
