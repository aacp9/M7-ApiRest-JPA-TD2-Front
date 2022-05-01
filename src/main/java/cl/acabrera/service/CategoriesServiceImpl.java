package cl.acabrera.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.acabrera.DTO.CategoriesDTO;
@Service
public class CategoriesServiceImpl implements CategoriesService {
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public List<CategoriesDTO> findByAllCategoriesName() {
		ResponseEntity<List<CategoriesDTO>> response = restTemplate.exchange(
				"http://localhost:8081/api/categories/v1/findAllByCategoriesName", //ruta o url
				HttpMethod.GET, //metodo 
				null, //objeto o parametro necesario
				new ParameterizedTypeReference<List<CategoriesDTO>>(){} //retorno de la respuesta
				);
		return response.getBody();	
	}

}
