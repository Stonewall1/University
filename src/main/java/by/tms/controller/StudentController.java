package by.tms.controller;

import by.tms.entity.Student;
import by.tms.entity.Subject;
import by.tms.service.StudentService;
import by.tms.service.SubjectService;
import org.springframework.stereotype.Controller;
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
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;
    private final SubjectService subjectService;

    public StudentController(StudentService studentService, SubjectService subjectService) {
        this.studentService = studentService;
        this.subjectService = subjectService;
    }


    @GetMapping("/registration")
    public String registration(@ModelAttribute("newStudent") Student student) {
        return "studentRegistration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "studentRegistration";
        }
        if (studentService.isInBase(student)) {
            model.addAttribute("message", "Student already in base");
            return "studentRegistration";
        }
        studentService.save(student);
        return "homepage";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("newStudent") Student student) {
        return "studentLogin";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newStudent") Student student, BindingResult bindingResult, HttpSession session, Model model) {
        if (bindingResult.hasErrors()) {
            return "studentLogin";
        }
        Student s = studentService.bySurname(student.getSurname());
        session.setAttribute("currentStudent", s);
        return "redirect:/";
    }

    @GetMapping("/studentPage")
    public String studentPage(Model model, HttpSession session) {
        if (session.getAttribute("currentStudent") != null) {
            Student student = (Student) session.getAttribute("currentStudent");
            model.addAttribute("studentSubjects", student.getSubjects());
            model.addAttribute("studentResults" , student.getResults());
            return "studentPage";
        }
        return "redirect:/student/login";
    }

    @GetMapping("/addSubjects")
    public String addSubjects(Model model){
        List<Subject> allSubjects = subjectService.findAll();
        model.addAttribute("allSubjects", allSubjects);
        return "studentAddSubjects";
    }
    @PostMapping("/addSubjects")
    public String addSubjects(HttpSession session , String subjectName){
        Student currentStudent = (Student) session.getAttribute("currentStudent");
        Subject bySubjectName = subjectService.findBySubjectName(subjectName);
        currentStudent.getSubjects().add(bySubjectName);
        Student update = studentService.update(currentStudent);
        session.setAttribute("currentStudent", update);
        return "redirect:/student/addSubjects";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
