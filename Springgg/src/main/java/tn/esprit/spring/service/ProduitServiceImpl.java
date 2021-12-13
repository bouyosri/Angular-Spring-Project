package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.ProduitRepository;


@Repository
public class ProduitServiceImpl implements ProduitService {
	@Autowired
	ProduitRepository produitRepository;
	

	@Autowired
	StockService stockService;
	
	
	@Autowired
	RayonService rayonService;
	
	@Autowired
	DetailProduitService detailProduitService;
	

	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) produitRepository.findAll();
	}

	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		p.setRayonproduit(rayonService.retrieveRayon(idRayon));
		p.setStockproduit(stockService.retrieveStock(idStock));
		DetailProduit d=detailProduitService.addDetailProduit(p.getDetailproduit());
		p.setDetailproduit(d);
		return produitRepository.save(p);
	}
	
	
	public Produit test(Produit p, Long idRayon, Long idStock) {
		p.setRayonproduit(rayonService.retrieveRayon(idRayon));
		p.setStockproduit(stockService.retrieveStock(idStock));
		System.out.println(p.getRayonproduit().getLibelle());
		DetailProduit d=p.getDetailproduit();
		d.setProduit(p);
		detailProduitService.addDetailProduit(d);
		p.setDetailproduit(d);
		return produitRepository.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return produitRepository.findById(id).orElse(null);
	}

}
