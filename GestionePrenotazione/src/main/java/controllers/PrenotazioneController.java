package controllers;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exceptions.PostazionePrenotazioneException;
import exceptions.UtentePrenotazioneException;
import model.Prenotazione;
import services.PrenotazioneService;

@RestController
@RequestMapping("/prentozione")
public class PrenotazioneController {
	
	@Autowired PrenotazioneService ps;

	@PostMapping("/")
	public ResponseEntity<Prenotazione> savePrenotazione(@RequestBody Prenotazione p){
		Prenotazione newP = ps.save(p);
		return new ResponseEntity(newP, HttpStatus.OK);
	}
	
	@PostMapping("/prenota")
	public ResponseEntity<Prenotazione> prenota(@RequestParam("data") LocalDate d,
			@RequestParam("utenteId") Long uid,
			@RequestParam("postazioneId") Long pid){
		
		try {
			Prenotazione p = ps.prenota(d, uid, pid);
			return new ResponseEntity(p, HttpStatus.OK);
		}
		catch (PostazionePrenotazioneException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);
		}
		catch (UtentePrenotazioneException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.FORBIDDEN);	
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
		
	}

	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<String> delete(@PathVariable Long id) {
//		
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Prenotazione> update(@PathVariable Long id, @RequestBody Prenotazione p) {
		Prenotazione updatedP = ps.update(id, p);
		return new ResponseEntity(updatedP, HttpStatus.OK)
	}
}
