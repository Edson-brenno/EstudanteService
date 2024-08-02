package com.spring.Config;

import com.spring.Entity.Student;
import com.spring.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class StudentsConfig implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {

        Student student1 = new Student("brenno");
        Student student2 = new Student("caio");
        Student student3 = new Student("isaque");

        studentRepository.saveAll(Arrays.asList(student1, student2, student3));
    }
}
