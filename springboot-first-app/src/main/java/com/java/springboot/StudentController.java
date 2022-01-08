package com.java.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class StudentController {
@Autowired
        StudentService service;
        //IOC - Inversion of control



    @PostMapping("/student")
    public ArrayList<Student> createStudent(@RequestBody Student student) throws Exception {
        return service.createStudent(student);

    }

    @GetMapping("/student/{input}")
    public Student studentList(@PathVariable int input){
        return service.studentList(input);
    }

    @DeleteMapping("/student/{delete}")
    public ArrayList<Student> studentListDelete(@PathVariable int delete){
        return service.studentListDelete(delete);
    }

    @GetMapping("/count")
    public long studentCount(){
        return service.studentCount();
    }

    @GetMapping("/list")
    public ArrayList<Student> studentList(){
        return service.studentList();
    }

    @DeleteMapping("/delete/{student_ID}")
    public String studentDeleteList(@PathVariable int student_ID) throws Exception {
       return service.studentDelete(student_ID);
    }

    @GetMapping("/deleteList")
    public ArrayList<Student> deleteStudentList(){
        return service.deleteStudentList();
    }

    @GetMapping("/studentList/{num}")
    public String studentListCheck(@PathVariable int num){
        return service.studentListCheck(num);
    }

    @PutMapping("/update")
    public Student updateStudentList(@RequestBody Student student){
        return service.updateStudentList(student);
    }

}
