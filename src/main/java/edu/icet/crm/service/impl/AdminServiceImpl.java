package edu.icet.crm.service.impl;

import edu.icet.crm.entity.AdminEntity;
import edu.icet.crm.model.Admin;
import edu.icet.crm.repository.AdminRepositoryJpa;
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
}
