package service;

import java.util.List;

import dto.PoDto;
import dto.SupplierDto;
import entity.Supplier;

public interface SupplierSvc {
	public List<SupplierDto> findAll();
	public SupplierDto findOne(String supId);
}
