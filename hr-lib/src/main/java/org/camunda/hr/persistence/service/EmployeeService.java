package org.camunda.hr.persistence.service;

import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.ibatis.session.SqlSession;
import org.camunda.hr.persistence.MyBatisUtil;
import org.camunda.hr.persistence.entity.Employee;
import org.camunda.hr.persistence.mapper.EmployeeMapper;

@Path("/{engine}/employee")
public class EmployeeService {

	private static final Logger LOGGER = Logger.getLogger(EmployeeService.class.getName());

	@GET
	@Path("/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Employee selectByUserId(@PathParam("userId") String userId) throws Exception {

		SqlSession objSqlSession;
		EmployeeMapper employeeMapper;
		Employee objEmployee = null;

		if (userId != null) {

			objSqlSession = MyBatisUtil.getPESqlSessionFactory().openSession();

			try {

				employeeMapper = objSqlSession.getMapper(EmployeeMapper.class);

				objEmployee = employeeMapper.selectByUserId(userId);

				objSqlSession.commit();

			} catch (Exception e) {

				objSqlSession.rollback();

				LOGGER.severe("selectByUserId (Exception): " + e.getMessage());

				throw e;

			} finally {

				objSqlSession.close();
			}

		}

		return objEmployee;
	}
}
