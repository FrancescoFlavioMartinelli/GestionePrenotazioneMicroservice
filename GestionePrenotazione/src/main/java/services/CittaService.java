package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Citta;

import java.util.List;
import java.util.Optional;

import reposistories.CittaRepository;

@Service
public class CittaService {
	
	@Autowired
	CittaRepository repo;
	
	public List<Citta> findAll() {
		return repo.findAll();
	}
	public Citta findById(Long id) {
		Optional<Citta> c = repo.findById(id);
		if(c.isPresent()) {
			return c.get();
		}
		return null;
	}
	
	public void save(Citta c) {
		repo.save(c);
	}

}
