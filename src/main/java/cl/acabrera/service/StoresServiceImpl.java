package cl.acabrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.acabrera.DTO.StoresDTO;
@Service
public class StoresServiceImpl implements StoresService {

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<StoresDTO> findByAllStoresName() {
		ResponseEntity<List<StoresDTO>> response = restTemplate.exchange(
				"http://localhost:8081/api/stores/v1/findAllByStoresName", //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<List<StoresDTO>>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

}
