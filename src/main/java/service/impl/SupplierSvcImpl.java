package service.impl;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.PoDao;
import dao.SupplierDao;
import dto.PoDto;
import dto.SupplierDto;
import entity.Po;
import entity.Supplier;
import entity.SupplierPK;
import service.PoSvc;
import service.SupplierSvc;

@Service("supplierSvc") // copy nama interface dan buat jadi huruf kecil nama servicenya
@Transactional
public class SupplierSvcImpl implements SupplierSvc {

	@Autowired
	private SupplierDao supplierDao;

	@Override
	public List<SupplierDto> findAll() {
		List<SupplierDto> supplierDtos= new ArrayList<SupplierDto>();
		List<Supplier> suppliers=supplierDao.findAll();
		for(Supplier supplier:suppliers)
		{
			SupplierDto supplierDto=new SupplierDto();
			supplierDto.setSupId(supplier.getSupId());
			supplierDto.setSupName(supplier.getSupName());
			supplierDtos.add(supplierDto);
			
		}
		
		return supplierDtos;
	}

	@Override
	public SupplierDto findOne(String supId) {
		SupplierDto supplierDto=new SupplierDto();
		SupplierPK supplierPK=new SupplierPK();
		supplierPK.setSupId(supId);
		Supplier supplier=supplierDao.findOne(supplierPK);
		if(supplier!=null)
		{
			supplierDto.setSupId(supplier.getSupId());
			supplierDto.setSupName(supplier.getSupName());
			supplierDto.setSupAddress(supplier.getSupAddress());
			
		}
		return supplierDto;
		
	}
	

}
