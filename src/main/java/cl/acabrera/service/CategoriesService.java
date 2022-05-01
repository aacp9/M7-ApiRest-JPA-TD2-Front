package cl.acabrera.service;

import java.util.List;

import cl.acabrera.DTO.CategoriesDTO;

public interface CategoriesService {
	public List<CategoriesDTO> findByAllCategoriesName();
}
