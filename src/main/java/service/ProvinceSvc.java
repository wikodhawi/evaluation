package service;

import java.util.List;

import dto.ProvinceDto;

public interface ProvinceSvc {
	public List<ProvinceDto> findAll();
	public ProvinceDto findOne(String provId);
}
