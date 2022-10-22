package by.tms.controller;

import by.tms.dto.ResultDto;
import by.tms.entity.*;
import by.tms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final SubjectService subjectService;
    private final StudentService studentService;
    private final LessonService lessonService;
    private final ResultService resultService;

    public TeacherController(TeacherService teacherService, SubjectService subjectService, StudentService studentService, LessonService lessonService, ResultService resultService) {
        this.teacherService = teacherService;
        this.subjectService = subjectService;
        this.studentService = studentService;
        this.lessonService = lessonService;
        this.resultService = resultService;
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

    @GetMapping("/addSubjects")
    public String addSubjects(Model model) {
        List<Subject> allSubjects = subjectService.findAll();
        model.addAttribute("allSubjects", allSubjects);
        return "teacherAddSubjects";
    }

    @PostMapping("/addSubjects")
    public String addSubjects(HttpSession session, String subjectName) {
        Teacher currentTeacher = (Teacher) session.getAttribute("currentTeacher");
        Subject bySubjectName = subjectService.findBySubjectName(subjectName);
        currentTeacher.getSubjects().add(bySubjectName);
        Teacher update = teacherService.update(currentTeacher);
        session.setAttribute("currentTeacher", update);
        return "redirect:/teacher/addSubjects";
    }

    @GetMapping("/createLesson")
    public String createLesson(@ModelAttribute("newLesson") Lesson lesson, HttpSession session, Model model) {
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        List<Subject> teacherSubjects = teacher.getSubjects();
        model.addAttribute("teacherSubjects", teacherSubjects);
        return "createLesson";
    }

    @PostMapping("/createLesson")
    public String createLesson(@ModelAttribute("newLesson") Lesson lesson, HttpSession session) {
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        Subject bySubjectName = subjectService.findBySubjectName(lesson.getSubject().getSubjectName());

        lesson.setTeacher(teacher);
        lesson.setSubject(bySubjectName);
        lesson.setStudents(new ArrayList<>());

        lessonService.save(lesson);
        session.setAttribute("lesson", lesson);
        return "redirect:/teacher/fillStudents";
    }

    @GetMapping("/fillStudents")
    public String fillStudents(Model model) {
        List<Student> allStudents = studentService.findAll();
        model.addAttribute("allStudents", allStudents);
        return "fillStudents";
    }

    @PostMapping("/fillStudents")
    public String fillStudents(String studentSurname , HttpSession session) {
        Student student = studentService.bySurname(studentSurname);
        Lesson lesson = (Lesson) session.getAttribute("lesson");
        lesson.getStudents().add(student);
        lessonService.update(lesson);
        return "redirect:/teacher/fillStudents";
    }

    @GetMapping("/rateStudent")
    public String rateStudent(@ModelAttribute("result") ResultDto resultDto, HttpSession session , Model model){
        Teacher teacher = (Teacher) session.getAttribute("currentTeacher");
        List<Lesson> lessonsByTeacherSurname = lessonService.findLessonsByTeacherSurname(teacher.getSurname());
        model.addAttribute("teacherLessons" , lessonsByTeacherSurname);
        return "rateStudent";
    }
    @PostMapping("/rateStudent")
    public String rateStudent(@Valid @ModelAttribute("result") ResultDto resultDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "rateStudent";
        }
        Lesson byLessonTheme = lessonService.findByLessonTheme(resultDto.getLessonTheme());
        Student student = studentService.bySurname(resultDto.getStudentSurname());

        Result result = new Result();
        result.setLesson(byLessonTheme);
        result.setStudent(student);
        result.setPerformance(resultDto.getPerformance());
        resultService.save(result);

        student.getResults().add(result);
        studentService.update(student);
        return "redirect:/teacher/teacherPage";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
