package ru.rti.inform.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.rti.inform.entity.Employee;
import ru.rti.inform.pbd.PbdPerson;
import ru.rti.inform.pbd.repository.PbdPersonRepository;
import ru.rti.inform.repository.EmployeeRepository;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    PbdPersonRepository pbdPersonRepository;

    @Autowired
    EmployeeRepository employeeRepository;

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

    @Scheduled(cron="0 0 0-23 * * *")
    public void loadPersonsFromPbd() {
        log.info("Scheduled task loadPersonsFromPbd started");
        List<PbdPerson> persons = (List<PbdPerson>) pbdPersonRepository.findAll();
        log.info("persons.size(): {}", persons.size());

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
        log.info("employees.size(): {}", employees.size());
        log.info("Scheduled task loadPersonsFromPbd ended");
    }
}