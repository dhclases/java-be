
package com.dh.institute;

import com.dh.institute.model.Course;
import com.dh.institute.model.Student;
import com.dh.institute.model.Subject;
import com.dh.institute.repository.ICourseRepository;
import com.dh.institute.repository.IStudentRepository;
import com.dh.institute.repository.ISubjectRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final Logger logger = LogManager.getLogger(CommandLineRunnerImpl.class);

    private final IStudentRepository studentRepository;
    private final ISubjectRepository subjectRepository;
    private final ICourseRepository courseRepository;

    public CommandLineRunnerImpl(IStudentRepository studentRepository, ISubjectRepository subjectRepository, ICourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("*** Iniciando el proceso **** ");

        Subject m1 = Subject.builder()
                .name("Fisica I")
                .leader("Albert Einstein")
                .build();
        subjectRepository.save(m1);

        Student s1 = Student.builder()
                .name("Andres")
                .lastname("Lopez")
                .build();

        studentRepository.save(s1);


        Course c1 = Course.builder()
                .nota(14)
                .subject(m1)
                .student(s1)
                .build();

        courseRepository.save(c1);

        logger.info("*** Fin del proceso **** ");
    }
}

