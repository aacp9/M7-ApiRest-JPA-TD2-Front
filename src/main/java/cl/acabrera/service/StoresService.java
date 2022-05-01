package cl.acabrera.service;

import java.util.List;

import cl.acabrera.DTO.StoresDTO;

public interface StoresService {
	public List<StoresDTO> findByAllStoresName();
}
