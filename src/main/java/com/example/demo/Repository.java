package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/index")
public class Repository {
    private Map<String, Student> studentList = new HashMap<String, Student>() {
        {
            put("Angela", new Student("Angela", '女', "12"));
            put("Cindy", new Student("Cindy", '男', "13"));
        }
    };

    @PostMapping("/post")
    public String addStudent(@RequestParam String name, char gender, String classId) {
        Student student = new Student(name, gender, classId);
        if (this.studentList.containsKey(name)) {
            return "姓名重复";
        } else {
            this.studentList.put(name, student);
            return "添加成功";
        }
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    public String QueryAll() {
        StringBuilder sb = new StringBuilder();
        for (Object studentName : this.studentList.keySet()) {
            sb.append(this.studentList.get(studentName).toString()).append("\n");
        }
        return sb.toString();
    }

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public String getInfoByName(@RequestParam(value = "name", required = false) String name) {
        return this.studentList.get(name).toString();
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.DELETE)
    public String deleteStudent(@RequestParam(value = "name", required = false) String name) {
        if (this.studentList.containsKey(name)) {
            this.studentList.remove(name);
            return "删除成功";
        }
        return "该学生不存在";
    }


}