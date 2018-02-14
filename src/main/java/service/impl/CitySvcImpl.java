package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import service.CitySvc;
import service.CitySvc;
import dao.CityDao;
import dao.CityDao;
import dto.CityDto;
import dto.CityDto;
import entity.City;
import entity.City;
import entity.CityPK;


@Service("citySvc") // copy nama interface dan buat jadi huruf kecil nama servicenya
@Transactional
public class CitySvcImpl implements CitySvc {

	@Autowired
	private CityDao cityDao;

	@Override
	public List<CityDto> findAll() {
		
		List<CityDto> cityDtos= new ArrayList<CityDto>();
		List<City> citys=cityDao.findAll();
		for(City city:citys)
		{
			CityDto cityDto=new CityDto();
			cityDto.setCityId(city.getCityId());
			cityDto.setCityName(city.getCityName());
			cityDto.setProvId(city.getProvId());
			cityDtos.add(cityDto);
			
		}
		
		return cityDtos;
	}

	@Override
	public CityDto findOne(String cityId) {
		CityDto cityDto=new CityDto();
		CityPK cityPK=new CityPK();
		cityPK.setCityId(cityId);
		City city=cityDao.findOne(cityPK);
		if(city!=null)
		{
			cityDto.setCityId(city.getCityId());
			cityDto.setCityName(city.getCityName());
			cityDto.setProvId(city.getProvId());
			
		}
		return cityDto;
	}

	@Override
	public List<CityDto> findCityByProvId(String provId) {
		List<CityDto> cityDtos=new ArrayList<CityDto>();
		List<City> cities=cityDao.findAllCityByProv(provId);
		for(City city:cities)
		{
			CityDto cityDto=new CityDto();
			cityDto.setCityId(city.getCityId());
			cityDto.setCityName(city.getCityName());
			cityDto.setProvId(city.getProvId());
			cityDtos.add(cityDto);
			
		}
		return cityDtos;
	}

}
