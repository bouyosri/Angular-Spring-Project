package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Rayon;
import tn.esprit.spring.repository.RayonRepository;

@Service
public class RayonServiceImpl implements RayonService{

	@Autowired
	RayonRepository Rayonrepo;

	
	@Override
	public List<Rayon> retrieveAllRayons() {
		// TODO Auto-generated method stub
		return (List<Rayon>) Rayonrepo.findAll();
	}

	@Override
	public Rayon retrieveRayon(Long idrayon) {
		// TODO Auto-generated method stub
		return Rayonrepo.findById(idrayon).orElse(null);
	}

}
