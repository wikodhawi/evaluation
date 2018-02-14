package main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.CityDao;
import dao.ItemDao;
import dao.PoDao;
import dao.PoDetailDao;
import dao.ProvinceDao;
import dao.SupplierDao;
import entity.City;
import entity.Item;
import entity.Po;
import entity.PoDetail;
import entity.Province;
import entity.Supplier;
import entity.SupplierPK;

public class tes {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("/META-INF/spring/app-config.xml");				
		System.out.println("Success");
		
		CityDao cityDao = ctx.getBean(CityDao.class);
		
		List<City> cities= cityDao.findAllCityByProv("1");
		for(City x:cities)
		{
			System.out.println(x.getCityName());
			
		}
		
//		System.out.println();
//	 	System.out.println("Supplier");
//	 	System.out.println();
//	 	
//	 	SupplierDao supplierDao = ctx.getBean(SupplierDao.class);
//	 	SupplierPK supplierPK=new SupplierPK();
//	 	supplierPK.setSupId("1");
//	 	
//	 	Supplier supplier=supplierDao.findOne(supplierPK);
//	 	System.out.println(supplier.getSupId());
//	 	System.out.println(supplier.getSupName());
	 	
//	 	List<Supplier> suppliers= supplierDao.findAll();
//	 	
//	 	for(Supplier x:suppliers)
//	 		
//	 	{
//	 		System.out.println(x.getSupAddress());
//	 		System.out.println(x.getSupId());
//	 		System.out.println(x.getSupName());
// 		}
		
		/*
		PoDao poDao = ctx.getBean(PoDao.class);
		List<Object[]> all=poDao.findAllPo();
		for(Object[] x: all)
		{
			System.out.println(x[0]);
			System.out.println(x[1]);
			
		}
		
		List<Object[]> allSearch=poDao.findAllPoByPONoSupName("%%", "%%");
		for(Object[] x: allSearch)
		{
			System.out.println(x[0]);
			System.out.println(x[1]);
			
		}
		*/
		
		/*
		CityDao cityDao = ctx.getBean(CityDao.class);
	 	List<City> citys= cityDao.findAll();
	 	
	 	
	 	System.out.println();
	 	System.out.println("City");
	 	System.out.println();
	 	for(City x:citys)
	 		
	 	{
	 		System.out.println(x.getCityId());
	 		System.out.println(x.getCityName());
	 		System.out.println(x.getProvId());
 		}
	 	
	 	System.out.println();
	 	System.out.println("Item");
	 	System.out.println();
	 	
	 	ItemDao itemDao = ctx.getBean(ItemDao.class);
	 	List<Item> items= itemDao.findAll();
	 	
	 	for(Item x:items)
	 		
	 	{
	 		System.out.println(x.getItemId());
	 		System.out.println(x.getItemName());
	 		System.out.println(x.getItemPrice());
	 		System.out.println(x.getSupId());
 		}
	 	
	 	System.out.println();
	 	System.out.println("Po");
	 	System.out.println();
	 	
	 	PoDao poDao = ctx.getBean(PoDao.class);
	 	List<Po> pos= poDao.findAll();
	 	
	 	for(Po x:pos)
	 		
	 	{
	 		System.out.println(x.getCityId());
	 		System.out.println(x.getDiscount());
	 		System.out.println(x.getPoAddress());
	 		System.out.println(x.getPoNo());
	 		System.out.println(x.getPoNo());
	 		System.out.println(x.getPoNotes());
	 		System.out.println(x.getPoShipment());
	 		System.out.println(x.getSupId());
	 		System.out.println(x.getTotal());
	 		System.out.println(x.getPoDate());
	 		System.out.println(x.getPoExpDate());
 		}
	 	
	 	System.out.println();
	 	System.out.println("Province");
	 	System.out.println();
	 	
	 	ProvinceDao provinceDao = ctx.getBean(ProvinceDao.class);
	 	List<Province> provinces= provinceDao.findAll();
	 	
	 	for(Province x:provinces)
	 		
	 	{
	 		System.out.println(x.getProvId());
	 		System.out.println(x.getProvName());
	 		
 		}
	 	
	 	System.out.println();
	 	System.out.println("Supplier");
	 	System.out.println();
	 	
	 	SupplierDao supplierDao = ctx.getBean(SupplierDao.class);
	 	List<Supplier> suppliers= supplierDao.findAll();
	 	
	 	for(Supplier x:suppliers)
	 		
	 	{
	 		System.out.println(x.getSupAddress());
	 		System.out.println(x.getSupId());
	 		System.out.println(x.getSupName());
 		}
	 	
	 	System.out.println();
	 	System.out.println("PoDetail");
	 	System.out.println();
	 	
	 	
	 	PoDetailDao poDetailDao = ctx.getBean(PoDetailDao.class);
	 	List<PoDetail> poDetails= poDetailDao.findAll();
	 	
	 	for(PoDetail x:poDetails)
	 		
	 	{
	 		System.out.println(x.getItemId());
	 		System.out.println(x.getItemPrice());
	 		System.out.println(x.getItemQty());
	 		System.out.println(x.getPoNo());
	 		System.out.println(x.getSubTotal());
 		}
 		*/
	}

}
