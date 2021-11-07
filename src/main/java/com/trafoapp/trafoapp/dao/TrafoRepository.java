package com.trafoapp.trafoapp.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trafoapp.trafoapp.entity.Trafo;
import com.trafoapp.trafoapp.entity.Work;

public interface TrafoRepository extends JpaRepository<Trafo, Integer> {

	public List<Trafo> findAllByOrderByNumberAsc();
	
	@Query(
			  value = "SELECT * FROM TRAFO t WHERE t.power =?1 ", 
			  nativeQuery = true)
	public List<Trafo> findByPower(int power);
	
	@Query(
			  value = "SELECT * FROM TRAFO t WHERE lower(t.type) like lower(?1)",
					
			  nativeQuery = true)
	public List<Trafo> findByType(String type);
	
	@Query(
			  value = "SELECT * FROM TRAFO t JOIN battery b ON t.battery_id=b.id  WHERE LOWER(b.type) LIKE LOWER(?1)",
					
			  nativeQuery = true)
	public List<Trafo> findByBattery(String battery);
	
	@Query(
			  value = ("SELECT * FROM TRAFO t JOIN disconnector d ON t.disconnector_id=d.id WHERE d.trafo_quantity_type LIKE %:disconnector%"),
					
			  nativeQuery = true)
	public List<Trafo> findByTrafoDisconnector(String disconnector);

     @Query(
		  value = ("SELECT * FROM TRAFO t JOIN disconnector d ON t.disconnector_id=d.id WHERE d.others_quantity_type LIKE %:disconnector%"),
				
		  nativeQuery = true)
   public List<Trafo> findByDisconnector(String disconnector);

}



 

