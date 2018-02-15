package vmd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Messagebox.ClickEvent;
import org.zkoss.zul.Window;

import dto.CityDto;
import dto.PoDetailDto;
import dto.PoDto;
import dto.ProvinceDto;
import dto.SupplierDto;
import service.CitySvc;
import service.PoDetailSvc;
import service.PoSvc;
import service.ProvinceSvc;
import service.SupplierSvc;



@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PurchaseOrderDetailVmd {

	@WireVariable
	private SupplierSvc supplierSvc;
	
	@WireVariable
	private CitySvc citySvc;
	
	@WireVariable
	private PoSvc poSvc;
	
	@WireVariable
	private PoDetailSvc poDetailSvc;
	
	@WireVariable
	private ProvinceSvc provinceSvc;
	
	private PoDetailDto poDetailDto;
	private PoDto poDto;
	private List<SupplierDto> supplierDtos;
	private SupplierDto supplierDto;
	private List<CityDto> cityDtos;
	private CityDto cityDto;
	private List<PoDetailDto> poDetailDtos = new ArrayList<PoDetailDto>();
	private int aging;
	private List<ProvinceDto> provinceDtos;
	private ProvinceDto provinceDto;
	
	
	public List<ProvinceDto> getProvinceDtos() {
		return provinceDtos;
	}



	public void setProvinceDtos(List<ProvinceDto> provinceDtos) {
		this.provinceDtos = provinceDtos;
	}



	public ProvinceDto getProvinceDto() {
		return provinceDto;
	}



	public void setProvinceDto(ProvinceDto provinceDto) {
		this.provinceDto = provinceDto;
	}



	public int getAging() {
		return aging;
	}



	public void setAging(int aging) {
		this.aging = aging;
	}



	public PoDetailDto getPoDetailDto() {
		return poDetailDto;
	}



	public void setPoDetailDto(PoDetailDto poDetailDto) {
		this.poDetailDto = poDetailDto;
	}



	public List<PoDetailDto> getPoDetailDtos() {
		return poDetailDtos;
	}



	public void setPoDetailDtos(List<PoDetailDto> poDetailDtos) {
		this.poDetailDtos = poDetailDtos;
	}



	public List<CityDto> getCityDtos() {
		return cityDtos;
	}



	public void setCityDtos(List<CityDto> cityDtos) {
		this.cityDtos = cityDtos;
	}



	public CityDto getCityDto() {
		return cityDto;
	}



	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}



	public SupplierDto getSupplierDto() {
		return supplierDto;
	}



	public void setSupplierDto(SupplierDto supplierDto) {
		this.supplierDto = supplierDto;
	}



	public List<SupplierDto> getSupplierDtos() {
		return supplierDtos;
	}



	public void setSupplierDtos(List<SupplierDto> supplierDtos) {
		this.supplierDtos = supplierDtos;
	}



	public PoDto getPoDto() {
		return poDto;
	}



	public void setPoDto(PoDto poDto) {
		this.poDto = poDto;
	}


	@NotifyChange({"poDto","provinceDto","cityDtos","cityDto","poDto"})
	@Init
	public void load()
	{
		poDto= (PoDto) Sessions.getCurrent().getAttribute("dto");
		if(poDto.getPoDate()!=null && poDto.getPoExpDate()!=null)
		{
//			aging=Math.abs(poDto.getPoDate().getDate()-poDto.getPoExpDate().getDate());
			aging=(int) Math.abs((poDto.getPoDate().getTime()-poDto.getPoExpDate().getTime())/86400000);
//			aging=poDto.getPoExpDate().compareTo(poDto.getPoDate());
//			aging=Math.abs(poDto.getPoDate().getTimezoneOffset()-poDto.getPoExpDate().getTimezoneOffset());
//			aging=(int) Math.abs(poDto.getPoDate().getTime()-poDto.getPoExpDate().getTime())/86400000;
		}
		
		if(poDto.getPoNo()!=null)
		{
			poDetailDtos=poDetailSvc.findAllPoDetail(poDto.getPoNo());
			Sessions.getCurrent().setAttribute("poDetailDtos", poDetailDtos);
//			System.out.println(poDto.getPoNo());
//			poDetailDtos=poDetailSvc.findAll();
			
		}
		else {
			poDetailDtos=poDetailSvc.findAllPoDetail(poDto.getPoNo());
			Sessions.getCurrent().setAttribute("poDetailDtos", poDetailDtos);
		}
		
		provinceDtos=provinceSvc.findAll();
		supplierDtos=supplierSvc.findAll();
//		cityDtos=citySvc.findAll();
		
		
		if(poDto.getSupId() != null){
			supplierDto= supplierSvc.findOne(poDto.getSupId());
			poDto.setPoAddress(supplierDto.getSupAddress());
			
		}
		if(poDto.getCityId() != null){
			cityDto= citySvc.findOne(poDto.getCityId());
			provinceDto=provinceSvc.findOne(cityDto.getProvId());
		}
		if(poDto!=null)
		{
			poDetailDtos= (List<PoDetailDto>) Sessions.getCurrent().getAttribute("poDetailDtos");
			int total=0;
			for(PoDetailDto x: poDetailDtos)
			{
				total=total+x.getSubTotal();
				
			}
			total=(int) (total-total*(poDto.getDiscount()*1.0/100));
			poDto.setTotal(total);
			
		}
		
	}
	
	@Command()
	public void save()
	{
		poDto.setCityId(cityDto.getCityId());
		poDto.setSupId(supplierDto.getSupId());
		poDto.setPoAddress(supplierDto.getSupAddress());
		poSvc.save(poDto);
		Messagebox.show("Data berhasil disimpan");
		Executions.sendRedirect("purchase_order.zul");
	}
	
	@Command()
	public void back()
	{
		Executions.sendRedirect("purchase_order.zul");
		
	}
	
	@Command
	@NotifyChange("poDetailDtos")
	public void deleteProduct()
	{
		if(poDto!=null)
		{
			Messagebox.show("Apakah yakin mau di hapus?"," Perhatian",
			new Button[]{Button.YES,Button.NO}, 
			Messagebox.QUESTION,
			Button.NO,
			new EventListener<Messagebox.ClickEvent>()
			{
				public void onEvent(ClickEvent event)
				{
					if(Messagebox.ON_YES.equals(event.getName()))
					{
						
						poDetailSvc.delete(poDetailDto);
						poDetailDtos.remove(poDetailDto);
						poDetailDto=null;
						BindUtils.postNotifyChange(null, null, PurchaseOrderDetailVmd.this, "poDetailDtos");
						Messagebox.show("Data berhasil di hapus");
						Executions.sendRedirect("purchase_order_detail.zul");
					}
					
					
				}
				
			});
			
		}
		else {
			Messagebox.show("Silahkan pilih data");
		}
		
		
	}
	
	
	@Command
	@NotifyChange("poDetailDtos")
	public void addProduct() {
        // TOS should be checked before accepting order
//        if(tosCheckbox.isChecked()) {
//            carService.order(((ListModelList<OrderItem>)orderItemsModel));
            // show result
//            Map<String, Object> arguments = new HashMap<String, Object>();
//            arguments.put("orderItems", orderItemsModel);
//            arguments.put("totalPrice", getTotalPrice());
		Map<String, Object> arguments = new HashMap<String, Object>();
        arguments.put("poNo", poDto.getPoNo());
		String template = "/item_add.zul";
        Window window = (Window)Executions.createComponents(template, null, arguments);
        window.doModal();
        
        
    }
	
	@NotifyChange("aging")
	@Command
	public void changeAging() {
//		aging=Math.abs(poDto.getPoDate().getDate()-poDto.getPoExpDate().getDate());
		
		
		aging=(int) Math.abs((poDto.getPoDate().getTime()-poDto.getPoExpDate().getTime())/86400000);
		
		
//		aging=Math.abs(poDto.getPoDate().compareTo(poDto.getPoExpDate()));
//		aging=poDto.getPoExpDate()..compareTo(poDto.getPoDate());
//		aging=poDto.getPoExpDate().compareTo(poDto.getPoDate());
	}
	
	
	
	@NotifyChange({"supplierDtos","supplierDto"})
	@Command
	public void changeAddress() {
		poDto.setPoAddress(supplierDto.getSupAddress());
	}
	
	@NotifyChange({"poDto","cityDtos","cityDto"})
	@Command
	public void changeCity() {
		cityDtos=citySvc.findCityByProvId(provinceDto.getProvId());
		for(CityDto cityDto:cityDtos)
		{
			System.out.println(cityDto.getCityName());
			
		}
	}
	
	@NotifyChange("poDto")
	@Command
	public void getTotal() {
		int total=0;
		for(PoDetailDto x: poDetailDtos)
		{
			total=total+x.getSubTotal();
			
		}
		total=(int) (total-total*(poDto.getDiscount()*1.0/100));
		poDto.setTotal(total);
		
    }
}
