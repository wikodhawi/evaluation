package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import entity.Po;
import entity.PoPK;

public interface PoDao extends JpaRepository<Po, PoPK> {
	
//	@Query("select o,p.prodName from OrderDetail o, Product p where o.prodId = p.prodId and o.orderId= ? ")
	
	@Query("select p,s.supName from Po p, Supplier s where p.supId=s.supId")
	public List<Object[]> findAllPo();
	
	@Query("select p,s.supName from Po p, Supplier s where p.supId=s.supId and p.poNo like ? and s.supName like ? ")
	public List<Object[]> findAllPoByPONoSupName(String search, String search2);
}
