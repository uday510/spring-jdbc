package com.app.jdbc;

import com.app.jdbc.model.Student;
import com.app.jdbc.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);

        Student s = context.getBean(Student.class);
        s.setRollNo(10);
        s.setName("Alan Turing");
        s.setMarks(70);

        StudentService service = context.getBean(StudentService.class);

        service.addStudent(s);

        List<Student> students = service.getStudents();

        students.forEach(System.out::println);
    }
}
