package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/index")
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/student/{name}")
    public Student getStu(@PathVariable String name) {
        return studentRepository.findById(studentRepository.findStudentId(name)).orElse(null);
    }

    @PostMapping("/save")
    public String addStudent(@RequestParam String name, @RequestParam String gender, @RequestParam String classId) {

        if (studentRepository.findStudentId(name)!=null) {
            return "姓名重复";
        } else {
            studentRepository.save(new Student(null,name,gender,classId));
            return "添加成功";
        }
    }

    @RequestMapping(value = "/students")
    public Iterable<Student> students() {
        return studentRepository.findAll();
    }


    @PostMapping(value = "/delete")
    public String deleteStudent(@RequestParam(value = "name", required = false) String name) {
        if (studentRepository.findStudentId(name)!=null) {
            studentRepository.delete(studentRepository.findById(studentRepository.findStudentId(name)).get());
            return "删除成功";
        } else {
            return "姓名不存在";
        }
    }


}