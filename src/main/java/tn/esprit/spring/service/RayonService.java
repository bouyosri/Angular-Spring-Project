package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entity.Rayon;

public interface RayonService {
	
	List<Rayon> retrieveAllRayons();
	Rayon retrieveRayon(Long idrayon);

}
