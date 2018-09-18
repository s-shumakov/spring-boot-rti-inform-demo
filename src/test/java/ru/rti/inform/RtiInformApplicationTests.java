package ru.rti.inform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.rti.inform.entity.Employee;
import ru.rti.inform.pbd.PbdPerson;
import ru.rti.inform.pbd.repository.PbdPersonRepository;
import ru.rti.inform.repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.List;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RtiInformApplicationTests {
	@Autowired
	PbdPersonRepository pbdPersonRepository;

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllPbdPersons() {
		List<PbdPerson> persons = (List<PbdPerson>) pbdPersonRepository.findAll();
		System.out.println("persons.size(): " + persons.size());
		assertNotNull(persons);
		assertTrue(persons.size() > 0);
	}

	@Test
	public void createAndFindEmployee(){
		Employee employee = new Employee();
		employee.setId(1);
		employee.setFirstName("Иван");
		employee.setLastName("Иванов2");
		employee.setBirthDate(LocalDate.of(2005, 1, 1));
		employee.setEmail("test@mail.ru");
		employee.setHireDate(LocalDate.now());
		employee.setTabNum("12345678");

		employeeRepository.save(employee);
		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		System.out.println("employees.size(): " + employees.size());
		assertNotNull(employees);
		assertTrue(employees.size() > 0);
		employeeRepository.deleteAll();
		assertTrue(((List<Employee>) employeeRepository.findAll()).size() == 0);
	}

	@Test
	public void loadPersonsFromPbd(){
		List<PbdPerson> persons = (List<PbdPerson>) pbdPersonRepository.findAll();
		System.out.println("persons.size(): " + persons.size());

		for (PbdPerson pbdPerson : persons) {
			Employee employee = new Employee();
			employee.setId(pbdPerson.getId());
			employee.setTabNum(pbdPerson.getTabNum());
			employee.setEmail(pbdPerson.getEmail());
			employee.setFirstName(pbdPerson.getFirstName());
			employee.setLastName(pbdPerson.getLastName());
			employeeRepository.save(employee);
		}

		List<Employee> employees = (List<Employee>) employeeRepository.findAll();
		System.out.println("employees.size(): " + employees.size());
		assertTrue(employees.size() == persons.size());
	}
}
