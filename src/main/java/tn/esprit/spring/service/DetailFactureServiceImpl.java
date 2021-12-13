package tn.esprit.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import tn.esprit.spring.entity.DetailFacture;
import tn.esprit.spring.entity.Facture;
import tn.esprit.spring.repository.DetailFactureRepository;
import tn.esprit.spring.repository.FactureRepository;

@Service
public class DetailFactureServiceImpl implements DetailFactureService{

	@Autowired
	DetailFactureRepository detailrepo;
	@Autowired
	FactureRepository facturerepo;
    
	
	

	@Override
	public ArrayList<DetailFacture> retrieveDetailFacturesbyFacture(Long idFacture) {
		ArrayList<DetailFacture> df = this.retrieveAllDetailFactures();
		ArrayList<DetailFacture> inventory = new ArrayList();
		
		System.out.println("eeeeee="+df.size());
		DetailFacture[] e = null;
		Long y;
		
		if (df.size()>0) {
			for (int i = 0; i < df.size(); i++) {
				y=df.get(i).getFacture().getIdFacture();
				
				if (y==idFacture)
				{
					inventory.add(df.get(i));
				}
				
			}
			
		}
		
		
		return (ArrayList<DetailFacture>) inventory;
	}

	@Override
	public DetailFacture addDetailFacture(DetailFacture c, Long idFacture)
	{
		
		
		Facture f =facturerepo.findById(idFacture).orElse(null);
		
		
		
		int qte =c.getQte();
		float prix = c.getProduit().getPrixUnitaire();
		float montant = qte*prix;
		float montantRemise = (montant*c.getPourcentageRemise())/100;
		float prixFinal = montant - montantRemise;
		c.setPrixTotal(prixFinal);
		c.setMontantRemise(montantRemise);
		c.setFacture(f);
		detailrepo.save(c);
		
		
		
		CalculTotal(f);
		facturerepo.save(f);
			
		return c;
	}

	@Override
	public boolean deleteDetailFacture(Long id) {
		DetailFacture c =detailrepo.findById(id).orElse(null);
		
		int qte =c.getQte();
		float prix = c.getPrixTotal();
		float montant = c.getMontantRemise();
		
		Facture f =c.getFacture();
		float total=f.getMontantFacture()-prix;
		float remisetotal=f.getMontantRemise()-montant;
		f.setMontantFacture(total);
		f.setMontantRemise(remisetotal);
		facturerepo.save(f);
		detailrepo.deleteById(id);
		if(detailrepo.findById(id) != null)
			return true;
		else 
			return false;
		// TODO Auto-generated method stub
		
	}

	@Override
	public DetailFacture updateDetailFacture(DetailFacture c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void CalculTotal(Facture f) {
		float total2 = 0;
		float Remise2=0;
		for (Object element : f.getDetailFactures()) {
			DetailFacture detail = (DetailFacture) element;
			total2+=detail.getPrixTotal();
			
			Remise2+=detail.getMontantRemise();
			
			
		}
		f.setMontantFacture(total2);
		f.setMontantRemise(Remise2);
		facturerepo.save(f);
		
		
		
	}

	@Override
	public ArrayList<DetailFacture> retrieveAllDetailFactures() {
		// TODO Auto-generated method stub
		
		return (ArrayList<DetailFacture>) detailrepo.findAll();
	}

	@Override
	public DetailFacture retrieveDetailFactures(Long idDFacture) {
		// TODO Auto-generated method stub
		return detailrepo.findById(idDFacture).orElse(null);
	}

}
