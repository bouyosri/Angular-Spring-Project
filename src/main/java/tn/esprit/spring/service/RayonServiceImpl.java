package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;

@Service
public class RayonServiceImpl implements RayonService {
	@Autowired
	RayonRepository RR;

	@Override
	public List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return (List<Rayon>) RR.findAll(); 
	}

	@Override
	public Rayon addRayon(Rayon r) {
		// TODO Auto-generated method stub
		return RR.save(r);
		
	}

	@Override
	public void deleteRayon(Long id) {
		// TODO Auto-generated method stub
		RR.deleteById(id);
		
	}

	@Override
	public Rayon updateRayon(Rayon r) {
		// TODO Auto-generated method stub
		return RR.save(r);
	}

	@Override
	public Rayon retrieveRayon(Long id) {
		// TODO Auto-generated method stub
		return this.RR.findById(id).orElse(null);
	}


}
