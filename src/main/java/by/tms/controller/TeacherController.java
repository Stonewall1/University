package by.tms.controller;

import by.tms.entity.Subject;
import by.tms.entity.Teacher;
import by.tms.service.SubjectService;
import by.tms.service.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final SubjectService subjectService;

    public TeacherController(TeacherService teacherService, SubjectService subjectService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("newTeacher") Teacher teacher, Model model) {
        List<Subject> allSubjects = subjectService.findAll();
        model.addAttribute("allSubjects", allSubjects);
        return "teacherRegistration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("newTeacher") Teacher teacher, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "teacherRegistration";
        }
        if (teacherService.isInBase(teacher)) {
            model.addAttribute("message", "Teacher already in base");
            return "teacherRegistration";
        }
        teacherService.save(teacher);
        return "homepage";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("newTeacher") Teacher teacher) {
        return "teacherLogin";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newTeacher") Teacher teacher, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "teacherLogin";
        }
        Teacher t = teacherService.bySurname(teacher.getSurname());
        session.setAttribute("currentTeacher", t);
        return "redirect:/";
    }

    @GetMapping("/teacherPage")
    public String teacherPage(Model model, HttpSession session) {
        if (session.getAttribute("currentTeacher") != null) {
            Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
            model.addAttribute("teacherSubjects", teacher.getSubjects());
            return "teacherPage";
        }
        return "redirect:/teacher/login";
    }

    @PostMapping("/teacherPage")
    public String teacherPage() {
        return "teacherPage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
