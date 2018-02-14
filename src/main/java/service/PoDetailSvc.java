package service;

import java.util.List;

import dto.PoDetailDto;

public interface PoDetailSvc {
	public List<PoDetailDto> findAllPoDetail(String poNo);
	public List<PoDetailDto> findAll();
	public void delete (PoDetailDto poDetailDto);
	public void save (PoDetailDto poDetailDto);
}
