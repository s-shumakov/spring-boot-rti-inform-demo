package ru.rti.inform.schedule;

import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.rti.inform.PbdLoader;
import ru.rti.inform.pbd.repository.PbdPersonRepository;
import ru.rti.inform.repository.PersonRepository;

@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    PbdPersonRepository pbdPersonRepository;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    PbdLoader pbdLoader;

//    @Scheduled(fixedRate = 5000)
//    public void reportCurrentTime() {
//        log.info("The time is now {}", dateFormat.format(new Date()));
//    }

    @Scheduled(cron="0 0 0-23 * * *")
    public void loadPersonsFromPbd() {
        log.info("Scheduled task loadPersonsFromPbd started");

        pbdLoader.loadPersonsFromPbd();
        pbdLoader.loadPositionsFromPbd();
        pbdLoader.loadStructsFromPbd();
        pbdLoader.loadAssignmentsFromPbd();

        log.info("Scheduled task loadPersonsFromPbd ended");
    }
}