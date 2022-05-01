package cl.acabrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.acabrera.DTO.StocksQueryDTO;
@Service
public class StockServiceImpl implements StockService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<StocksQueryDTO> stockListParams(String storeIdService, String categoryIdService,
			String brandIdService) {

		String url="http://localhost:8081/api/response/stocks/v1/stockListParams?storeIdController="+storeIdService+"&categoryIdController="+categoryIdService+"&brandIdController="+brandIdService;
		ResponseEntity<List<StocksQueryDTO>> response = restTemplate.exchange(
			url, //ruta o url
			HttpMethod.GET, //metodo 
			null, //objeto o parametro necesario
			new ParameterizedTypeReference<List<StocksQueryDTO>>(){} //retorno de la respuesta
			);
	return response.getBody();	
	}

}
