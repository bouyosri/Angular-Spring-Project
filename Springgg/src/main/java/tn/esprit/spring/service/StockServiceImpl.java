package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	
	@Autowired
	StockRepository stockRepository;
	
	@Override
	public List<Stock> retrieveAllStocks() {
		// TODO Auto-generated method stub
		return (List<Stock>) stockRepository.findAll();
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock u) {
		// TODO Auto-generated method stub
		return stockRepository.save(u);
	}

	@Override
	public Stock retrieveStock(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteStock(Long id) {
		stockRepository.deleteById(id);
		
	}
	@Override
	public List<Stock> SoldOutStock() {
		return stockRepository.SoldOutStock();
	}
	
	@Scheduled(cron = "*/60 * * * * *" )
	public void checkSoldOutStock() {
		
			List<Stock> stockList = SoldOutStock();
			for (Stock stock : stockList) {
				System.out.print("rupture de stock "+stock.getLibelleStock());
			}
			
		
	}

}
