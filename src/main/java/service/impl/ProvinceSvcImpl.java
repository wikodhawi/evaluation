package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.ProvinceDao;
import dto.ProvinceDto;
import entity.Province;
import service.ProvinceSvc;

@Service("provinceSvc") // copy nama interface dan buat jadi huruf kecil nama servicenya
@Transactional
public class ProvinceSvcImpl implements ProvinceSvc {

	@Autowired
	private ProvinceDao provinceDao;
	
	@Override
	public List<ProvinceDto> findAll() {
		List<ProvinceDto> provinceDtos=new ArrayList<ProvinceDto>();
		List<Province> provinces=provinceDao.findAll();
		for(Province province:provinces)
		{
			ProvinceDto provinceDto=new ProvinceDto();
			provinceDto.setProvId(province.getProvId());
			provinceDto.setProvName(province.getProvName());
			provinceDtos.add(provinceDto);
			
		}
		return provinceDtos;
	}

}
