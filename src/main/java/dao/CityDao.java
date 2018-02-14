package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.City;
import entity.CityPK;

public interface CityDao extends JpaRepository<City, CityPK> {
	@Query("select c from City c where c.provId = ? ")
	public List<City> findAllCityByProv(String provId);
}
