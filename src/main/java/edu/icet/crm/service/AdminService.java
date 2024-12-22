package edu.icet.crm.service;

import edu.icet.crm.model.Admin;

import java.util.List;

public interface AdminService {
    Admin persist(Admin admin);

    List<Admin> getAdmins();

    void deleteAdmin(Long id);

    Admin updateAdmin(Admin admin);
}
