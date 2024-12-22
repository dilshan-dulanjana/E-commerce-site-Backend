package edu.icet.crm.repository;

import edu.icet.crm.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepositoryJpa extends JpaRepository<AdminEntity,Long> {
}
