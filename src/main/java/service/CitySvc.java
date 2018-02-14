package service;

import java.util.List;

import dto.CityDto;
import dto.SupplierDto;

public interface CitySvc {
	public List<CityDto> findAll();
	public CityDto findOne(String cityId);
	public List<CityDto> findCityByProvId(String provId);
}
