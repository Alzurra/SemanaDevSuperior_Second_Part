package com.thiagocostafatec.dsvendas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.thiagocostafatec.dsvendas.dto.SaleSuccessDTO;
import com.thiagocostafatec.dsvendas.dto.SaleSumDTO;
import com.thiagocostafatec.dsvendas.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
	
	@Query("SELECT new com.thiagocostafatec.dsvendas.dto.SaleSumDTO(obj.seller, "
			+ "SUM(obj.amount))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSumDTO> amountGroupedBySeller();
	
	@Query("SELECT new com.thiagocostafatec.dsvendas.dto.SaleSuccessDTO(obj.seller, SUM(obj.visited),"
			+ "SUM(obj.deals))"
			+ "FROM Sale AS obj GROUP BY obj.seller")
	List<SaleSuccessDTO> successGroupedBySeller();

}
