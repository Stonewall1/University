package by.tms.controller;

import by.tms.entity.Admin;
import by.tms.entity.Subject;
import by.tms.service.AdminService;
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
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;
    private final SubjectService subjectService;

    public AdminController(AdminService adminService, SubjectService subjectService) {
        this.adminService = adminService;
        this.subjectService = subjectService;
    }

    @GetMapping("/registration")
    public String registration(@ModelAttribute("newAdmin") Admin admin) {
        return "adminRegistration";
    }

    @PostMapping("/registration")
    public String registration(@Valid @ModelAttribute("newAdmin") Admin admin, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "adminRegistration";
        }
        adminService.save(admin);
        return "homepage";
    }

    @GetMapping("/login")
    public String login(@ModelAttribute("newAdmin") Admin admin) {
        return "adminLogin";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newAdmin") Admin admin, BindingResult bindingResult, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "adminLogin";
        }
        session.setAttribute("currentAdmin", admin);
        return "redirect:/";
    }

    @GetMapping("/adminPage")
    public String adminPage(Model model , HttpSession session) {
        if(session.getAttribute("currentAdmin") != null){
            List<Subject> allSubjects = subjectService.findAll();
            model.addAttribute("allSubjects", allSubjects);
            return "adminPage";
        }
        return "redirect:/admin/login";
    }

    @PostMapping("/adminPage")
    public String adminPage() {
       return "adminPage";
    }
    @GetMapping("/addSubject")
    public String addSubject(){
        return "addSubject";
    }
    @PostMapping("/addSubject")
    public String addSubject(String subjectName){
        subjectService.save(new Subject(subjectName));
        return "addSubject";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
