package com.thiagocostafatec.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thiagocostafatec.dsvendas.dto.SaleDTO;
import com.thiagocostafatec.dsvendas.dto.SaleSuccessDTO;
import com.thiagocostafatec.dsvendas.dto.SaleSumDTO;
import com.thiagocostafatec.dsvendas.entities.Sale;
import com.thiagocostafatec.dsvendas.repositories.SaleRepository;
import com.thiagocostafatec.dsvendas.repositories.SellerRepository;

@Service
public class SaleServices {

	@Autowired
	private SaleRepository repository;

	@Autowired
	private SellerRepository sellerRepository;

	// Método para buscar a Page(Paginação) de Sellers
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pageable) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x -> new SaleDTO(x));
	}

	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGroupedBySeller() {
		return repository.amountGroupedBySeller();
	}

	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGroupedBySeller() {
		return repository.successGroupedBySeller();
	}
}
