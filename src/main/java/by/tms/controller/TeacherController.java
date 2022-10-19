package by.tms.controller;

import by.tms.entity.Teacher;
import by.tms.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("newTeacher") Teacher teacher) {
        return "teacherRegistration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("newTeacher") Teacher teacher, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "teacherRegistration";
        }
        teacherService.save(teacher);
        return "homepage";
    }
}
