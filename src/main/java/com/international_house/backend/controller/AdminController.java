package com.international_house.backend.controller;

import com.international_house.backend.domain.Admin;
import com.international_house.backend.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/admin")
public class AdminController {

    private final AdminService adminService;


    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public List<Admin> getAdmins() {
        return adminService.getAdmins();
    }
    @PostMapping
    public void registerNewAdmin(@RequestBody Admin admin) {
        adminService.addNewAdmin(admin);
    }

    @DeleteMapping
    public void deleteAdmin(@RequestBody Admin admin) {
        adminService.deleteAdminById(admin.getAdminNumber());
    }

    @PutMapping
    public void updateAdmin(@RequestBody Admin admin) {
        adminService.updateAdmin(admin.getAdminNumber(),admin);
    }



}
