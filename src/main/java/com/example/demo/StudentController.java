package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/index")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/student/{name}")
    public String getStu(@PathVariable String name) {
        try {
            return studentService.getInfo(name).toString();
        } catch (ExistOrNotException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/save")
    public String addStudent(@RequestParam String name, @RequestParam String gender, @RequestParam String classId) {
        try {
            studentService.save(name, gender, classId);
            return "添加成功";
        } catch (ExistOrNotException e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/students")
    public Iterable<Student> students() {
        return studentService.students();
    }


    @PostMapping(value = "/delete")
    public String deleteStudent(@RequestParam(value = "name", required = false) String name) {
        try {
            studentService.delete(name);
            return "删除成功";
        } catch (ExistOrNotException e) {
            return e.getMessage();
        }
    }

}