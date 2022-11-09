package controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Citta;
import services.CittaService;

@RestController
public class CittaController {
	
	@Autowired
	CittaService cs;

	@GetMapping("citta/")
	public List<Citta> findAll() {
		return cs.findAll();
	}
	
	@GetMapping("/{id}")
	public Citta getById(@PathVariable Long id) {
//		if(cs.findById(id) == null) {
//			return "NESSUNA CITTA TROVATA";
//		}
		return cs.findById(id);
	}

	@PostMapping("/")
	public void save(@RequestBody Citta c) {
		cs.save(c);
	}
	
}
