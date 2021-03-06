package br.com.hrs.core.validator.employee;

import br.com.hrs.core.common.error.Error;
import br.com.hrs.core.common.error.FIELD;
import br.com.hrs.core.exception.HrsNotFoundException;
import br.com.hrs.core.model.Employee;
import br.com.hrs.core.repository.EmployeeRepository;
import br.com.hrs.core.validator.SaveValidator;
import br.com.hrs.core.validator.UpdateValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Objects;

@Named
public class ExistentManagerEmployeeValidator implements SaveValidator<Employee>, UpdateValidator<Employee> {

	private static final Logger logger = LogManager.getLogger(ExistentManagerEmployeeValidator.class);

	private EmployeeRepository employeeRepository;

	@Inject
	public ExistentManagerEmployeeValidator(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void validate(Employee employee) {
		logger.debug("Validating if employee's manager is existent");

		if (Objects.isNull(employee)) {
			Error.of("Employee").when(FIELD.MANDATORY).trows();
		}

		if(!this.employeeRepository.existsById(employee.getManager().getId())){
			throw new HrsNotFoundException("Manager does not exist");
		}
	}
}