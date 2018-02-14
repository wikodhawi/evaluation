package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.PoDetail;
import entity.PoDetailPK;

public interface PoDetailDao extends JpaRepository<PoDetail, PoDetailPK> {
	@Query("select p,t.itemName from PoDetail p,Item t where p.itemId=t.itemId and p.poNo=?")
	public List<Object[]> findAllPoDetail(String poNo);
}
