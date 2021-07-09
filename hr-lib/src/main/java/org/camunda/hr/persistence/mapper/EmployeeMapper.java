package org.camunda.hr.persistence.mapper;

import org.camunda.hr.persistence.entity.Employee;

public interface EmployeeMapper {

	public Employee selectByUserId(String userId);
}
