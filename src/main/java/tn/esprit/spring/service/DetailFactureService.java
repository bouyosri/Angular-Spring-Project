package tn.esprit.spring.service;
import java.util.List;

import tn.esprit.spring.entity.DetailFacture;

public interface DetailFactureService {

	List<DetailFacture> retrieveAllFctDetails();

	DetailFacture addFctDetail(DetailFacture df);

	void deleteFctDetail(Long id);

	public DetailFacture updateFctDetail(DetailFacture df);

	DetailFacture retrieveFctDetail(Long id);

}