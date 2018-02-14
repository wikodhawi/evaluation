package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.Item;
import entity.ItemPK;

public interface ItemDao extends JpaRepository<Item, ItemPK> {
	
}
