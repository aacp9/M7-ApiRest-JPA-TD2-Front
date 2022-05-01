package cl.acabrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.acabrera.DTO.BrandsDTO;
@Service
public class BrandsServiceImpl implements BrandsService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<BrandsDTO> findByAllBrandsName() {
		ResponseEntity<List<BrandsDTO>> response = restTemplate.exchange(
				"http://localhost:8081/api/brands/v1/findAllByBrandsName", //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<List<BrandsDTO>>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

}
