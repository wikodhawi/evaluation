package vmd;

import java.util.List;

import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.ExecutionArgParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.Window;

import dto.ItemDto;
import dto.PoDetailDto;
import dto.PoDto;
import service.ItemSvc;
import service.PoDetailSvc;
import service.SupplierSvc;


@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ItemVmd {
	@WireVariable
	private ItemSvc itemSvc;
	
	@WireVariable
	private PoDetailSvc poDetailSvc;
	
	private String poNo;
	
	
	private List<ItemDto> itemDtos;
	private ItemDto itemDto;
	private List<PoDetailDto> poDetailDtos;
	private PoDetailDto poDetailDto;
	private int quantity;
	private int subTotal;
	
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSubTotal() {
		return subTotal;
	}
	public void setSubTotal(int subTotal) {
		this.subTotal = subTotal;
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
	public String getPoNo() {
		return poNo;
	}
	public void setPoNo(String poNo) {
		this.poNo = poNo;
	}
	public List<ItemDto> getItemDtos() {
		return itemDtos;
	}
	public void setItemDtos(List<ItemDto> itemDtos) {
		this.itemDtos = itemDtos;
	}
	public ItemDto getItemDto() {
		return itemDto;
	}
	public void setItemDto(ItemDto itemDto) {
		this.itemDto = itemDto;
	}
	

	@Init
	@NotifyChange({"quantity","subTotal"})
	public void load(@ExecutionArgParam("poNo") String poNo)
	{
		this.poNo=poNo;
		itemDtos=itemSvc.findAll();
		
		
		poDetailDtos = (List<PoDetailDto>) Sessions.getCurrent().getAttribute("poDetailDtos");
//		subTotal=itemDto.getItemPrice();
//		for(ProductDto productDto:productDtos)
//		{
//			subTotal=quantity*productDto.getProdPrice();
//			
//		}
//		try {
//			subTotal=quantity*productDto.getProdPrice();
//		} catch (Exception e) {
//			quantity=0;
//			subTotal=0;
//		}
	}
	
	@Wire
	private Window window;
	
	@Command
    public void back() {
        window.onClose();
    }
	
	@NotifyChange({"subTotal","quantity"})
	@Command
	public void change() {
		subTotal=itemDto.getItemPrice();
		quantity=1;

    }
	
	@NotifyChange({"subTotal","quantity"})
	@Command
	public void calculate() {
		subTotal=quantity*itemDto.getItemPrice();

    }
	
	@Command
	public void saveProduct() {
		
		System.out.println(poNo);
		PoDetailDto poDetailDto=new PoDetailDto();
		poDetailDto.setItemId(itemDto.getItemId());
		poDetailDto.setItemName(itemDto.getItemName());
		poDetailDto.setItemPrice(itemDto.getItemPrice());
		poDetailDto.setItemQty(quantity);
		poDetailDto.setPoNo(poNo);
		poDetailDto.setSubTotal(subTotal);
		
		poDetailDtos.add(poDetailDto);
		poDetailSvc.save(poDetailDto);
		Sessions.getCurrent().setAttribute("poDetailDtos", poDetailDtos);
		Executions.sendRedirect("purchase_order_detail.zul");
	
	}	
	
	
	
}
