package ru.rti.inform;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.rti.inform.entity.Assignment;
import ru.rti.inform.entity.Person;
import ru.rti.inform.entity.Position;
import ru.rti.inform.entity.Struct;
import ru.rti.inform.pbd.entity.PbdAssignment;
import ru.rti.inform.pbd.entity.PbdPerson;
import ru.rti.inform.pbd.entity.PbdPosition;
import ru.rti.inform.pbd.entity.PbdStruct;
import ru.rti.inform.pbd.repository.PbdAssignmentRepository;
import ru.rti.inform.pbd.repository.PbdPersonRepository;
import ru.rti.inform.pbd.repository.PbdPositionRepository;
import ru.rti.inform.pbd.repository.PbdStructRepository;
import ru.rti.inform.repository.AssignmentRepository;
import ru.rti.inform.repository.PersonRepository;
import ru.rti.inform.repository.PositionRepository;
import ru.rti.inform.repository.StructRepository;
import ru.rti.inform.schedule.ScheduledTasks;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class PbdLoader {
    @Autowired
    PbdPersonRepository pbdPersonRepository;

    @Autowired
    PbdAssignmentRepository pbdAssignmentRepository;

    @Autowired
    PbdPositionRepository pbdPositionRepository;

    @Autowired
    PbdStructRepository pbdStructRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    AssignmentRepository asignmentRepository;

    @Autowired
    PositionRepository positionRepository;

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

    public void loadPositionsFromPbd(){
        List<PbdPosition> pbdPositions = (List<PbdPosition>) pbdPositionRepository.findAll();
        log.info("pbdPositions.size(): {}", pbdPositions.size());

        for (PbdPosition pbdPosition : pbdPositions) {
            Position position = new Position();
            position.setId(pbdPosition.getId());
            position.setName(pbdPosition.getName());
            positionRepository.save(position);
        }

        List<Position> positions = (List<Position>) positionRepository.findAll();
        log.info("positions.size(): {}", positions.size());
    }

    public void loadAssignmentsFromPbd(){
        List<PbdAssignment> pbdAssignments = (List<PbdAssignment>) pbdAssignmentRepository.findAll();
        log.info("pbdAssignments.size(): {}", pbdAssignments.size());

        for (PbdAssignment pbdAssignment : pbdAssignments) {
            Assignment assignment = new Assignment();
            assignment.setId(pbdAssignment.getId());
            try {
                assignment.setPerson(personRepository.findById(pbdAssignment.getPersonId()).get());
                assignment.setPosition(positionRepository.findById(pbdAssignment.getPositionId()).get());
                assignment.setStruct(structRepository.findById(pbdAssignment.getOrganizationId()).get());
                asignmentRepository.save(assignment);
            } catch (NoSuchElementException e) {
                log.error(e.getMessage());
                log.info("assignment: {}", assignment.getId());
            }
        }

        List<Assignment> assignments = (List<Assignment>) asignmentRepository.findAll();
        log.info("positions.size(): {}", assignments.size());
    }
}
