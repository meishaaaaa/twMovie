package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class Repository {
    private Map<String, Student> studentList = new HashMap<>();

    @PostMapping("/post")
    public String addStudent(@RequestBody Student student) {
        if (studentList.containsKey(student.getName())) {
            return "姓名重复";
        } else {
            studentList.put(student.getName(), student);
            return "添加成功";
        }
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public String QueryAll() {
        StringBuilder sb = new StringBuilder();
        for (String studentName : studentList.keySet()) {
            sb.append(studentList.get(studentName).toString()).append("\n");
        }
        return sb.toString();
    }

    @RequestMapping(value = "/getInfo", params = {"name"}, method = RequestMethod.GET)
    public String getInfoByName(@RequestBody String name) {
        return studentList.get(name).toString();
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam(value = "name") String name) {
        if (studentList.remove(name) != null) {
            return "删除成功";
        } else {
            return "该学生不存在";
        }
    }


}