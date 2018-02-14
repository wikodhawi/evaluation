package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.Province;
import entity.ProvincePK;

public interface ProvinceDao extends JpaRepository<Province, ProvincePK> {
	
}
