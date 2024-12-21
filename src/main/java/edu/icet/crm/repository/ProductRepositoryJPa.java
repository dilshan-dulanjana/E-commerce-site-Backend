package edu.icet.crm.repository;

import edu.icet.crm.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepositoryJPa extends JpaRepository<ProductEntity,Long> {
}
