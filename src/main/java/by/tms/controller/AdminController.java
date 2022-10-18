package by.tms.controller;

import by.tms.entity.Admin;
import by.tms.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
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
        System.out.println(admin);
        return "homepage";
    }
}
