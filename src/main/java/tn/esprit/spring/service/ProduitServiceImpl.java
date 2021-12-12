package tn.esprit.spring.service;
import java.util.Date;
 

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import tn.esprit.spring.entity.Produit;
import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.entity.Stock;
import tn.esprit.spring.entity.DetailProduit;
import tn.esprit.spring.entity.Fournisseur;
import tn.esprit.spring.repository.ProduitRepository;
import tn.esprit.spring.repository.RayonRepository;
import tn.esprit.spring.repository.StockRepository;



@Service

public  class ProduitServiceImpl implements ProduitService{
	
	@Autowired
	private ProduitRepository PR;
	
	@Autowired
	private RayonServiceImpl RS;
	
	@Autowired
	private StockServiceImpl SS;
	
	@Autowired
	private FournisseurServiceImpl FS;
	
    @Autowired
	private DetailProduitServiceImlp DPS;

	@Override
	public List<Produit> retrieveAllProduits() {
		return (List<Produit>) PR.findAll();
	}
	
	@Transactional
	@Override
	public Produit addProduit(Produit p, Long idRayon, Long idStock) {
		p.setRayon(RS.retrieveRayon(idRayon));
		Stock s=SS.retrieveStock(idStock);
		p.setStock(s);
		s.setQte(s.getQte()+1);
		SS.updateStock(s);
		
		DetailProduit dp = p.getDetailProduit();
		dp.setProduit(p);
		DPS.addProdDetail(dp);
		return PR.save(p);
	}

	@Override
	public Produit retrieveProduit(Long id) {
		return PR.findById(id).orElse(null);

	}
	
	@Transactional
	@Override
	public Produit updateProduit(Produit p) {
		
		DetailProduit dp = p.getDetailProduit();
		Date date = new Date(System.currentTimeMillis());
		dp.setDateDerniereModification(date);
		p.setDetailProduit(dp);
		return PR.save(p);
	}
	
	@Transactional
	@Override
	 public void deleteProduit (Long idProduit) {
		
		Stock oldStock = retrieveProduit(idProduit).getStock();
		oldStock.setQte(oldStock.getQte()-1);
		PR.deleteById(idProduit);
		SS.updateStock(oldStock);
	}
	
	@Transactional
	@Override
	public void assignProduitToStock(Long idProduit, Long idStock) {
		Produit produit = retrieveProduit(idProduit);
		if(produit!= null && produit.getStock().getIdStock()!=idStock) {
			Stock oldStock = produit.getStock();
			oldStock.setQte(oldStock.getQte()-1);
			System.out.print("oldStock before"+oldStock.getQte());
			Stock newStock = SS.retrieveStock(idStock);
			produit.setStock(newStock);
			updateProduit(produit);
			SS.updateStock(oldStock);
			SS.updateStock(newStock);
			System.out.print("oldStock after  "+oldStock.getQte());
		}
	}
		
	


	@Override
	public void assignFournisseurToProduit(Long fournisseurId, Long produitId) {
		Fournisseur f = FS.retrieveFournisseur(fournisseurId);
		if(f!=null) {
			Produit p = retrieveProduit(produitId);
			p.getFournisseur().add(f);
			updateProduit(p);
		
	}
	}
}



