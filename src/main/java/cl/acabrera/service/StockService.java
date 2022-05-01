package cl.acabrera.service;

import java.util.List;

import cl.acabrera.DTO.StocksQueryDTO;

public interface StockService {
	
	public List<StocksQueryDTO> stockListParams(String storeIdService, String categoryIdService, String brandIdService);

}
