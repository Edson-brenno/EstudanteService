package com.spring.Controller;

import com.spring.Client.SalaClient;
import com.spring.Dto.SalasDto;
import com.spring.Entity.Student;
import com.spring.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private SalaClient salaClient;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok().body(studentService.findAll());
    }

    @GetMapping(value = "/salas")
    public ResponseEntity<List<SalasDto>> getAllStudentsSala() {
        try{
              // Uso sem o feign
//            SalasDto[] salas = new RestTemplate().getForObject("http://localhost:8081/salas", SalasDto[].class);
//
//            return ResponseEntity.ok().body(Arrays.asList(salas));

            return ResponseEntity.ok().body(salaClient.getAllSalas());
        }catch (ResourceAccessException e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping(value = "/sala/{id}")
    public ResponseEntity<SalasDto> getStudentSalaById(@PathVariable Long id) {
        return ResponseEntity.ok().body(salaClient.getSalasById(id));
    }
}
