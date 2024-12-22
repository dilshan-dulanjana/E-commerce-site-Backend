package edu.icet.crm.controller.admin;


import edu.icet.crm.model.Admin;
import edu.icet.crm.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class AdminController {

    private final AdminService service;


    @PostMapping("/add-admin")
    public Admin persist(@RequestBody Admin admin){
        return service.persist(admin);

    }

    @GetMapping("/get-admin")
    public List<Admin> getAdmins(){
        return service.getAdmins();
    }

    @DeleteMapping("/delete-admin/{id}")
    public void deleteAdmin(@PathVariable Long id){
        service.deleteAdmin(id);
    }
    @PutMapping("update-admin")
    public Admin updateAdmin(@RequestBody Admin admin){
       return service.updateAdmin(admin);
    }

}
