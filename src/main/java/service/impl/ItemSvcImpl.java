package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.CityDao;
import dao.ItemDao;
import dto.CityDto;
import dto.ItemDto;
import dto.PoDetailDto;
import entity.Item;
import entity.PoDetail;
import service.CitySvc;
import service.ItemSvc;

@Service("itemSvc") // copy nama interface dan buat jadi huruf kecil nama servicenya
@Transactional
public class ItemSvcImpl implements ItemSvc {

	@Autowired
	private ItemDao itemDao;
	
	@Override
	public List<ItemDto> findAll() {
		List<ItemDto> itemDtos=new ArrayList<ItemDto>();
		List<Item> objects=itemDao.findAll();
		for(Item item:objects)
		{
			ItemDto itemDto=new ItemDto();
			itemDto.setItemId(item.getItemId());
			itemDto.setItemName(item.getItemName());
			itemDto.setItemPrice(item.getItemPrice());
			itemDto.setSupId(item.getSupId());
			itemDtos.add(itemDto);
			
		}
		return itemDtos;
	}


}
