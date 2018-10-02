package ru.rti.inform.loader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rti.inform.entity.Person;
import ru.rti.inform.entity.Position;
import ru.rti.inform.entity.Struct;
import ru.rti.inform.pbd.entity.PbdPerson;
import ru.rti.inform.pbd.entity.PbdStruct;
import ru.rti.inform.pbd.repository.PbdPersonRepository;
import ru.rti.inform.pbd.repository.PbdStructRepository;
import ru.rti.inform.repository.PersonRepository;
import ru.rti.inform.repository.StructRepository;
import ru.rti.inform.schedule.ScheduledTasks;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PbdLoader {
    @Autowired
    PbdPersonRepository pbdPersonRepository;

    @Autowired
    PbdStructRepository pbdStructRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    StructRepository structRepository;

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    public void loadPersonsFromPbd(){
        List<PbdPerson> pbdPersons = (List<PbdPerson>) pbdPersonRepository.findAll();
        log.info("pbdPersons.size(): {}", pbdPersons.size());

        for (PbdPerson pbdPerson : pbdPersons) {
            Person person = new Person();
            person.setId(pbdPerson.getId());
            person.setTabNum(pbdPerson.getTabNum());
            person.setEmail(pbdPerson.getEmail());
            person.setFirstName(pbdPerson.getFirstName());
            person.setLastName(pbdPerson.getLastName());
            personRepository.save(person);
        }

        List<Person> persons = (List<Person>) personRepository.findAll();
        log.info("persons.size(): {}", persons.size());
    }

    public void loadStructsFromPbd(){
        List<PbdStruct> pbdStructs = (List<PbdStruct>) pbdStructRepository.findAll();
        log.info("pbdStructs.size(): {}", pbdStructs.size());

        for (PbdStruct pbdStruct : pbdStructs) {
            Struct struct = new Struct();
            struct.setId(pbdStruct.getId());
            struct.setName(pbdStruct.getName());
            structRepository.save(struct);
        }

        List<Struct> structs = (List<Struct>) structRepository.findAll();
        log.info("structs.size(): {}", structs.size());
    }

}
