package com.thiagocostafatec.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thiagocostafatec.dsvendas.dto.SellerDTO;
import com.thiagocostafatec.dsvendas.entities.Seller;
import com.thiagocostafatec.dsvendas.repositories.SellerRepository;

@Service
public class SellerServices {

	@Autowired
	private SellerRepository repository;

	// Método para buscar a List(Lista) de Sellers
	public List<SellerDTO> findAll() {
		List<Seller> result = repository.findAll();
		return result.stream().map(x -> new SellerDTO(x)).collect(Collectors.toList());
	}
}
