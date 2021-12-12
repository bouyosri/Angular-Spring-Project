package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.StockRepository;


@Service
public class StockServiceImpl implements StockService{
	
	@Autowired
	StockRepository Stockrepo;
	ProduitRepository prodrep;

	@Override
	public List<Stock> retrieveAllStocks() {
		return (List<Stock>) this.Stockrepo.findAll();
	}

	@Override
	public Stock addStock(Stock c) {
        return this.Stockrepo.save(c);
	}

	@Override
	public Stock updateStock(Stock c) {
		Stock Stock = Stockrepo.findById(c.getIdStock()).orElse(null);
		if(Stock != null)
			Stockrepo.save(c);
        return c;
	}

	@Override
	public Stock retrieveStock(Long id) {
		return this.Stockrepo.findById(id).orElse(null);
	}
	
	@Scheduled(cron = "*/60 * * * * *" )
	public void cronMethod() {
		List<Stock> stocks = this.retrieveAllStocks();
		for (Object stock2 : stocks) {
			Stock stock = (Stock) stock2;
			if (stock.getQteMin()>stock.getQte())
				System.out.print(" le produit "+stock.getIdStock()+" est en repture de stock");	 
		}
	}
	
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit p = prodrep.findById(idProduit).orElse(null);
		Stock s = Stockrepo.findById(idStock).orElse(null);
		p.setStock(s);
	}

}
