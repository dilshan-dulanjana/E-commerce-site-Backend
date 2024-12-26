package edu.icet.crm.service.impl;

import edu.icet.crm.entity.AdminEntity;
import edu.icet.crm.model.Admin;
import edu.icet.crm.repository.AdminRepositoryJpa;
import edu.icet.crm.repository.repo.AdminRepository;
import edu.icet.crm.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService  {
     private final AdminRepositoryJpa adminRepositoryJpa;
     private final ModelMapper mapper;
     private final AdminRepository adminRepository;
    @Override
    public Admin persist(Admin admin) {
        return mapper.map(adminRepositoryJpa.save(
                mapper.map(admin, AdminEntity.class)),Admin.class) ;

    }

    @Override
    public List<Admin> getAdmins() {

        List<Admin>adminList =new ArrayList<>();
         adminRepositoryJpa.findAll().forEach(entity->{
             adminList.add(mapper.map(entity,Admin.class));
         });
         return adminList;
    }

    @Override
    public void deleteAdmin(Long id) {
        adminRepositoryJpa.deleteById(id);
    }

    @Override
    public Admin updateAdmin(Admin admin) {
       return mapper.map(adminRepositoryJpa.save(mapper.map(admin,AdminEntity.class)),Admin.class) ;
    }

    @Override
    public Admin getAdminByID(Long id) {
       return mapper.map(adminRepositoryJpa.findById(id),Admin.class);
    }

    @Override
    public boolean logingCheck(String email, String password) {
        return adminRepository.logingCheck(email,password);
    }
}
