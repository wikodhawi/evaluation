package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Supplier;
import entity.SupplierPK;

public interface SupplierDao extends JpaRepository<Supplier, SupplierPK> {
	
}
