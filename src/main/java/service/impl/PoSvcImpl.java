package service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PoDao;
import dto.PoDto;
import entity.Po;
import entity.PoPK;
import service.PoSvc;

@Service("poSvc") // copy nama interface dan buat jadi huruf kecil nama servicenya
@Transactional
public class PoSvcImpl implements PoSvc {

	@Autowired
	private PoDao poDao;
	
	@Override
	public List<PoDto> findAllPoByPONoSupName(String search, String search2) {
		List<PoDto> poDtos= new ArrayList<PoDto>();
		List<Object[]> pos=poDao.findAllPoByPONoSupName("%"+search+"%","%" +search2+"%");
		for(Object[] x:pos)
		{
			Po po= (Po) x[0];
			PoDto poDto=new PoDto();
			poDto.setCityId(po.getCityId());
			poDto.setDiscount(po.getDiscount());
			poDto.setPoAddress(po.getPoAddress());
			poDto.setPoDate(po.getPoDate());
			poDto.setPoExpDate(po.getPoExpDate());
			poDto.setPoNo(po.getPoNo());
			poDto.setPoNotes(po.getPoNotes());
			poDto.setPoShipment(po.getPoShipment());
			poDto.setSupId(po.getSupId());
			poDto.setTotal(po.getTotal());
			poDto.setSupName((String) x[1]);
			poDtos.add(poDto);
			
		}
		
		return poDtos;
	}

	@Override
	public List<PoDto> findAllPo() {
		List<PoDto> poDtos= new ArrayList<PoDto>();
		List<Object[]> pos=poDao.findAllPo();
		for(Object[] x:pos)
		{
			Po po= (Po) x[0];
			PoDto poDto=new PoDto();
			poDto.setCityId(po.getCityId());
			poDto.setDiscount(po.getDiscount());
			poDto.setPoAddress(po.getPoAddress());
			poDto.setPoDate(po.getPoDate());
			poDto.setPoExpDate(po.getPoExpDate());
			poDto.setPoNo(po.getPoNo());
			poDto.setPoNotes(po.getPoNotes());
			poDto.setPoShipment(po.getPoShipment());
			poDto.setSupId(po.getSupId());
			poDto.setTotal(po.getTotal());
			poDto.setSupName((String) x[1]);
			poDtos.add(poDto);
			
		}
		
		return poDtos;
	}

	@Override
	public void delete(PoDto poDto) {
		// TODO Auto-generated method stub
		PoPK poPK=new PoPK();
		poPK.setPoNo(poDto.getPoNo());
		poDao.delete(poPK);
		
	}

	@Override
	public void save(PoDto poDto) {
		Po po=new Po();
		po.setCityId(poDto.getCityId());
		po.setDiscount(poDto.getDiscount());
		po.setPoAddress(poDto.getPoAddress());
		po.setPoDate(poDto.getPoDate());
		po.setPoExpDate(poDto.getPoExpDate());
		po.setPoNo(poDto.getPoNo());
		po.setPoNotes(poDto.getPoNotes());
		po.setPoShipment(poDto.getPoShipment());
		po.setSupId(poDto.getSupId());
		po.setTotal(poDto.getTotal());
		poDao.save(po);
		
	}
		


}
