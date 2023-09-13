package com.igloosyrup.paimonquests.controllers;

import com.igloosyrup.paimonquests.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4000")
@RequestMapping("/admin")
public class AdminController {

    public AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @DeleteMapping("/user/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Boolean> deleteUser(@PathVariable Integer userId){
        return  adminService.deleteUser(userId)
                .map(isDeleted -> ResponseEntity.status(HttpStatus.OK).body(isDeleted))
                .orElse(ResponseEntity.status(HttpStatus.CONFLICT).build());
    }


}
