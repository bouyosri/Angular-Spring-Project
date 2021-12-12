package tn.esprit.spring.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.DetailFacture;
//import tn.esprit.spring.repository.DetailFactRepository;
import tn.esprit.spring.repository.DetailFactureRepository;

@Service
public class DetailFactureImpl implements DetailFactureService {


	
	@Autowired
	private DetailFactureRepository detailFactRepository;

	@Override
	public List<DetailFacture> retrieveAllFctDetails() {
		return (List<DetailFacture>) detailFactRepository.findAll();
	}

	@Override
	public DetailFacture addFctDetail(DetailFacture df) {
		return detailFactRepository.save(df);
	}

	@Override
	public void deleteFctDetail(Long id) {
		detailFactRepository.deleteById(id);
		
	}

	@Override
	public DetailFacture updateFctDetail(DetailFacture df) {
		return detailFactRepository.save(df);
	}

	@Override
	public DetailFacture retrieveFctDetail(Long id) {
		return detailFactRepository.findById(id).orElse(null);
	}
	

}