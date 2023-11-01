package com.example.sampleweb.controller;

import com.example.sampleweb.model.Student;
import com.example.sampleweb.model.StudentDto;
import com.example.sampleweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String getAllStudents(Model model){
        List<Student> allStudents = studentService.getAllStudents();
        model.addAttribute("students", allStudents);
        return "student/studentList";
    }

    @GetMapping("/addstudent")
    public String addstudent(){
        return "student/studentForm";
    }

    @PostMapping("/addstudent")
    public String addstudent(@ModelAttribute Student student){
        studentService.addStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/studentInfo/{studentId}")
    public String getstudentInfo(@PathVariable int studentId,
                              Model model){
        Student student = studentService.getStudentInfo(studentId);
        model.addAttribute("student", student);
        return "student/studentInfo";
    }

    @GetMapping("/updatestudent/{studentId}")
    public String updatestudent(@PathVariable int studentId,
                             Model model){
        Student student = studentService.getStudentInfo(studentId);
        model.addAttribute("student", student);
        return "student/studentUpdateForm";
    }

    @PostMapping("/updatestudent/{studentId}")
    public String updatestudent(@PathVariable int studentId,
                             @ModelAttribute StudentDto studentDto){
        System.out.println("updatestudent 호출됨");
        studentService.updateStudent(studentId, studentDto);
        return "redirect:/students";
    }

    @GetMapping("/deletestudent/{studentId}")
    public String deletestudent(@PathVariable int studentId){
        studentService.removeStudent(studentId);
        return "redirect:/students";
    }
}
