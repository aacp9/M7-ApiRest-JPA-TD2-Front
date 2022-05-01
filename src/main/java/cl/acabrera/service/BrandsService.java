package cl.acabrera.service;

import java.util.List;

import cl.acabrera.DTO.BrandsDTO;

public interface BrandsService {
	public List<BrandsDTO> findByAllBrandsName();
}
