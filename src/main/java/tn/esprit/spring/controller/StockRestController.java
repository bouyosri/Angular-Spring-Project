package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.service.StockServiceImpl;
import tn.esprit.spring.service.StockServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Stocks management")
@RequestMapping("/Stocks")
public class StockRestController {
	@Autowired
	
	StockServiceImpl StockService;
	
	@ApiOperation(value = "Récupérer la liste des Stocks")
	@GetMapping("/retrieve-all-Stocks")
	@ResponseBody
	public List<Stock> getAllStocks() {
		List<Stock> Stocks = StockService.retrieveAllStocks();
		return Stocks;
	}
	
	@ApiOperation(value = "Récupérer un Stock")
	@GetMapping("/retrieve-Stock/{Stock-id}")
	@ResponseBody
		public Stock retrieveStock(@PathVariable("Stock-id") Long StockId) {
		return StockService.retrieveStock(StockId);
	}
	
	@ApiOperation(value = "Ajouter un Stock")
	@PostMapping("/add-Stock")
	@ResponseBody
	public Stock addStock(@RequestBody Stock c)
	{
		Stock Stock = StockService.addStock(c);
		return Stock;
	}
	
	@ApiOperation(value = "Modifier un Stock")
	@PutMapping("/modify-Stock")
	@ResponseBody
	public Stock modifyStock(@RequestBody Stock Stock) {
	return StockService.updateStock(Stock);
	}
	

}
