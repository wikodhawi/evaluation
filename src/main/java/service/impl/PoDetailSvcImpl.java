package service.impl;

import java.util.ArrayList;
import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PoDetailDao;
import dto.CityDto;
import dto.PoDetailDto;
import dto.PoDto;
import entity.Po;
import entity.PoDetail;
import entity.PoDetailPK;
import service.PoDetailSvc;

@Service("poDetailSvc") // copy nama interface dan buat jadi huruf kecil nama servicenya
@Transactional
public class PoDetailSvcImpl implements PoDetailSvc {

	@Autowired
	private PoDetailDao poDetailDao;

	@Override
	public List<PoDetailDto> findAllPoDetail(String poNo) {
		// TODO Auto-generated method stub
		List<PoDetailDto> poDetailDtos=new ArrayList<PoDetailDto>();
		List<Object[]> objects=poDetailDao.findAllPoDetail(poNo);
		for(Object[] x:objects)
		{
			PoDetailDto poDetailDto=new PoDetailDto();
			PoDetail poDetail=(PoDetail) x[0];
			poDetailDto.setItemId(poDetail.getItemId());
			poDetailDto.setItemPrice(poDetail.getItemPrice());
			poDetailDto.setItemQty(poDetail.getItemQty());
			poDetailDto.setPoNo(poDetail.getPoNo());
			poDetailDto.setSubTotal(poDetail.getSubTotal());
			poDetailDto.setItemName((String) x[1]);
			poDetailDtos.add(poDetailDto);
			
		}
		return poDetailDtos;
		
	}

	@Override
	public List<PoDetailDto> findAll() {
		List<PoDetailDto> poDetailDtos=new ArrayList<PoDetailDto>();
		List<PoDetail> objects=poDetailDao.findAll();
		for(PoDetail poDetail:objects)
		{
			PoDetailDto poDetailDto=new PoDetailDto();
			poDetailDto.setItemId(poDetail.getItemId());
			poDetailDto.setItemPrice(poDetail.getItemPrice());
			poDetailDto.setItemQty(poDetail.getItemQty());
			poDetailDto.setPoNo(poDetail.getPoNo());
			poDetailDto.setSubTotal(poDetail.getSubTotal());
			poDetailDtos.add(poDetailDto);
			
		}
		return poDetailDtos;
	}

	@Override
	public void delete(PoDetailDto poDetailDto) {
		PoDetailPK poDetailPK=new PoDetailPK();
		poDetailPK.setItemId(poDetailDto.getItemId());
		poDetailPK.setPoNo(poDetailDto.getPoNo());
		poDetailDao.delete(poDetailPK);
		
	}

	@Override
	public void save(PoDetailDto poDetailDto) {
		PoDetail poDetail=new PoDetail();
		
		poDetail.setItemId(poDetailDto.getItemId());
		poDetail.setItemPrice(poDetailDto.getItemPrice());
		poDetail.setItemQty(poDetailDto.getItemQty());
		poDetail.setPoNo(poDetailDto.getPoNo());
		poDetail.setSubTotal(poDetailDto.getSubTotal());
		poDetailDao.save(poDetail);
		
	}
	

}
