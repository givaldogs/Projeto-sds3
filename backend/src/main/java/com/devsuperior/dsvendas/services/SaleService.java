package com.devsuperior.dsvendas.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsvendas.dto.SaleDTO;
import com.devsuperior.dsvendas.entities.Sale;
import com.devsuperior.dsvendas.repositories.SaleRepository;
import com.devsuperior.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@org.springframework.transaction.annotation.Transactional(readOnly = true)
	public Page<SaleDTO> findAll(Pageable pagealbe) {
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pagealbe);
		return result.map(x -> new SaleDTO(x));
	}

}
