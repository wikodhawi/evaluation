package service;

import java.util.List;

import dto.PoDto;

public interface PoSvc {
	public List<PoDto> findAllPo();
	public List<PoDto> findAllPoByPONoSupName(String search, String search2);
	public void delete(PoDto poDto);
	public void save(PoDto poDto);
}
