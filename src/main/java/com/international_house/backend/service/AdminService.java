package com.international_house.backend.service;

import com.international_house.backend.domain.Admin;
import com.international_house.backend.repos.AdminRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }


    @GetMapping
    public List<Admin> getAdmins() {
        return adminRepository.findAll();
    }

    public void createAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    public void deleteAdminById(UUID adminNumber) {
        adminRepository.deleteById(adminNumber);
    }

    @Transactional
    public void updateAdmin(UUID adminNumber, Admin updatedAdmin) {
        Admin existingAdmin = adminRepository.findById(adminNumber)
                .orElseThrow(() -> new IllegalArgumentException("Admin with ID " + adminNumber + " not found."));
        existingAdmin.setFirstName(updatedAdmin.getFirstName());
        existingAdmin.setLastName(updatedAdmin.getLastName());
        existingAdmin.setPasswordHash(updatedAdmin.getPasswordHash());
        adminRepository.save(existingAdmin);
    }

}
