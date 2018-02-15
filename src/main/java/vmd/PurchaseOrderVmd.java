package vmd;

import java.util.List;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Messagebox.Button;
import org.zkoss.zul.Messagebox.ClickEvent;

import dto.PoDetailDto;
import dto.PoDto;
import service.PoSvc;



@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class PurchaseOrderVmd {
	@WireVariable
	private PoSvc poSvc;
	
	private List<PoDto> poDtos;
	private PoDto poDto;
	private List<PoDetailDto> poDetailDtos;
	private PoDetailDto poDetailDto;
	private String search;
	
	
	
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




	public List<PoDto> getPoDtos() {
		return poDtos;
	}




	public void setPoDtos(List<PoDto> poDtos) {
		this.poDtos = poDtos;
	}




	public PoDto getPoDto() {
		return poDto;
	}




	public void setPoDto(PoDto poDto) {
		this.poDto = poDto;
	}

	
	


	public String getSearch() {
		return search;
	}




	public void setSearch(String search) {
		this.search = search;
	}




	@Init
	public void load()
	{
		poDtos=poSvc.findAllPo();
		
		
	}
	
	@Command
	public void add()
	{
		PoDto poDto= new PoDto();
		
//		poDetailDtos= (List<PoDetailDto>) Sessions.getCurrent().getAttribute("poDetailDtos");
//		poDetailDtos.clear();
//		Sessions.getCurrent().setAttribute("poDetailDtos", poDetailDtos);
		Sessions.getCurrent().setAttribute("dto", poDto);
		Executions.sendRedirect("purchase_order_detail.zul");
		
	}
	
	@Command
	public void search()
	{
//		Messagebox.show(search);
		List<PoDto> poDtoSearch=poSvc.findAllPoByPONoSupName(search, search);
		if (poDtoSearch.size()>0) {
			poDtos=poDtoSearch;
			BindUtils.postNotifyChange(null, null, this, "poDtos");// sama seperti notify change secara program
		} else {
			Messagebox.show("Not found");
//			productDtos=productSvc.findAll();
//			BindUtils.postNotifyChange(null, null, this, "productDtos");
		}
		
		
		
	}
	
	@Command()
	public void edit()
	{
		if(poDto==null)
		{
			Messagebox.show("Silahkan pilih data");
			
		}
		else {
			Sessions.getCurrent().setAttribute("dto", poDto);
			Executions.sendRedirect("purchase_order_detail.zul");
		}
		
	}
	
	@Command
	public void delete()
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
						poSvc.delete(poDto);
						poDtos.remove(poDto);
						poDto=null;
						BindUtils.postNotifyChange(null, null, PurchaseOrderVmd.this, "poDtos");
						Messagebox.show("Data berhasil di hapus");
						
					}
					
					
				}
				
			});
			
		}
		else {
			Messagebox.show("Silahkan pilih data");
		}
		
	}
}
