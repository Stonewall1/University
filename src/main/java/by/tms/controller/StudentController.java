package by.tms.controller;

import by.tms.domain.Student;
import by.tms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/studentRegistration")
    public String registration(@ModelAttribute("newStudent") Student student) {
        return "studentRegistration";
    }

    @PostMapping("/studentRegistration")
    public String registration(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "studentRegistration";
        }
        studentService.save(student);
        return "startpage";
    }
}
