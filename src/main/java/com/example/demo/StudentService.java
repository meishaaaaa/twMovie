package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student getInfo(String name) {
        if (studentRepository.findStudentId(name) != null) {
            return studentRepository.findById(studentRepository.findStudentId(name)).get();
        } else {
            throw new ExistOrNotException("找不到该学生");
        }
    }

    public void save(String name, String gender, String classId) {
        if (studentRepository.findStudentId(name) == null) {
            studentRepository.save(new Student(null, name, gender, classId));
        } else {
            throw new ExistOrNotException("姓名已存在");
        }
    }

    public Iterable<Student> students() {
        return studentRepository.findAll();
    }

    public void delete(String name) {
        if (studentRepository.findStudentId(name) != null) {
            studentRepository.delete(studentRepository.findById(studentRepository.findStudentId(name)).get());
        } else {
            throw new ExistOrNotException("该学生不存在");
        }
    }
}
