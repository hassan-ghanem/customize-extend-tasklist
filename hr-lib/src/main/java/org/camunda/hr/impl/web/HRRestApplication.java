package org.camunda.hr.impl.web;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import org.camunda.hr.persistence.service.EmployeeService;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class HRRestApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();

		classes.add(EmployeeService.class);

		classes.add(JacksonJsonProvider.class);

		return classes;
	}
}
