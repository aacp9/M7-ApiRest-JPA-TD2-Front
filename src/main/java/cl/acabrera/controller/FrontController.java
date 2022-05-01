package cl.acabrera.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.acabrera.service.BrandsService;
import cl.acabrera.service.CategoriesService;
import cl.acabrera.service.StockService;
import cl.acabrera.service.StoresService;

@Controller
public class FrontController {

	@Autowired
	private StoresService storesService;
	@Autowired
	private CategoriesService categoriesService;
	@Autowired
	private BrandsService brandsService;
	@Autowired
	private StockService stockService;
	
	@GetMapping("/")
	public ModelAndView home() {
		
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("stores", storesService.findByAllStoresName());
		modelAndView.addObject("categories", categoriesService.findByAllCategoriesName());
		modelAndView.addObject("brands", brandsService.findByAllBrandsName());
		
		modelAndView.setViewName("home");
		return modelAndView;

	}
	
	@RequestMapping(value = "showStocks", method = RequestMethod.POST)
	public ModelAndView showStocks(@RequestParam ("store") String store, @RequestParam ("category") String category, @RequestParam ("brand") String brand) {

		ModelAndView modelAndView = new ModelAndView();

		if (!store.isEmpty() && !category.isEmpty() && !brand.isEmpty()) {
			modelAndView.addObject("stocks", stockService.stockListParams(store, category, brand));
		}		
		
		//para rellenar últimos datos en prueba
//		modelAndView.addObject("store",store);
//		modelAndView.addObject("state",category);
//		modelAndView.addObject("dateFrom",brand);

		//Validación DATOS PARA ComboBox
		modelAndView.addObject("stores", storesService.findByAllStoresName());
		if (modelAndView.isEmpty()) {
			modelAndView.setViewName("/");
		} else {
			modelAndView.setViewName("home");
		}

		//Validación DATOS PARA ComboBox
		modelAndView.addObject("categories", categoriesService.findByAllCategoriesName());
		if (modelAndView.isEmpty()) {
			modelAndView.setViewName("/");
		} else {
			modelAndView.setViewName("home");
		}

		//Validación DATOS PARA ComboBox
		modelAndView.addObject("brands", brandsService.findByAllBrandsName());
		if (modelAndView.isEmpty()) {
			modelAndView.setViewName("/");
		} else {
			modelAndView.setViewName("home");
		}
	
		return modelAndView;
 
	}
	
}
