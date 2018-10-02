package ru.rti.inform;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.rti.inform.entity.Person;
import ru.rti.inform.entity.Struct;
import ru.rti.inform.loader.PbdLoader;
import ru.rti.inform.pbd.entity.PbdPerson;
import ru.rti.inform.pbd.entity.PbdStruct;
import ru.rti.inform.pbd.repository.PbdPersonRepository;
import ru.rti.inform.pbd.repository.PbdStructRepository;
import ru.rti.inform.repository.PersonRepository;
import ru.rti.inform.repository.StructRepository;

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
	PbdStructRepository pbdStructRepository;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	StructRepository structRepository;

	@Autowired
	PbdLoader pbdLoader;

	@Test
	public void contextLoads() {
	}

	@Test
	public void findAllPbdPersons() {
		List<PbdPerson> result = (List<PbdPerson>) pbdPersonRepository.findAll();
		System.out.println("PbdPerson count: " + result.size());
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

	@Test
	public void findAllPbdStructs() {
		List<PbdStruct> result = (List<PbdStruct>) pbdStructRepository.findAll();
		System.out.println("PbdStruct count: " + result.size());
		assertNotNull(result);
		assertTrue(result.size() > 0);
	}

	@Test
	public void createAndFindPerson(){
		Person person = new Person();
		person.setId(1L);
		person.setFirstName("Иван");
		person.setLastName("Иванов2");
		person.setBirthDate(LocalDate.of(2005, 1, 1));
		person.setEmail("test@mail.ru");
		person.setHireDate(LocalDate.now());
		person.setTabNum("12345678");

		personRepository.save(person);
		List<Person> persons = (List<Person>) personRepository.findAll();
		System.out.println("persons.size(): " + persons.size());
		assertNotNull(persons);
		assertTrue(persons.size() > 0);
		personRepository.deleteAll();
		assertTrue(((List<Person>) personRepository.findAll()).size() == 0);
	}

	@Test
	public void loadPersonsFromPbd(){
		List<PbdPerson> persons = (List<PbdPerson>) pbdPersonRepository.findAll();
		System.out.println("persons.size(): " + persons.size());

		for (PbdPerson pbdPerson : persons) {
			Person person = new Person();
			person.setId(pbdPerson.getId());
			person.setTabNum(pbdPerson.getTabNum());
			person.setEmail(pbdPerson.getEmail());
			person.setFirstName(pbdPerson.getFirstName());
			person.setLastName(pbdPerson.getLastName());
			personRepository.save(person);
		}

		List<Person> employees = (List<Person>) personRepository.findAll();
		System.out.println("employees.size(): " + employees.size());
		assertTrue(employees.size() == persons.size());
	}

	@Test
	public void loadStructsFromPbd(){
		List<PbdStruct> pbdStructs = (List<PbdStruct>) pbdStructRepository.findAll();
		System.out.println("structs.size(): " + pbdStructs.size());

		for (PbdStruct pbdStruct : pbdStructs) {
			Struct struct = new Struct();
			struct.setId(pbdStruct.getId());
			struct.setName(pbdStruct.getName());
			structRepository.save(struct);
		}

		List<Struct> structs = (List<Struct>) structRepository.findAll();
		System.out.println("structs.size(): " + structs.size());
		assertTrue(pbdStructs.size() == structs.size());
	}

	@Test
	public void loadFromPbd() {
		pbdLoader.loadPersonsFromPbd();
		pbdLoader.loadStructsFromPbd();
	}

}
