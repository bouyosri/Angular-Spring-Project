package tn.esprit.spring.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Stock;



public interface StockService {
	List<Stock> retrieveAllStocks();

	public Stock addStock(Stock s);

	public Stock updateStock(Stock u);

	public Stock retrieveStock(Long id);
	
	public void assignProduitToStock(Long idProduit, Long idStock);

}
