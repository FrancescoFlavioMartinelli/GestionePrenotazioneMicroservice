package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exceptions.PostazionePrenotazioneException;
import exceptions.UtentePrenotazioneException;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import model.Postazione;
import model.Prenotazione;
import model.Utente;
import reposistories.PostazioneRepository;
import reposistories.PrenotazioneRepository;
import reposistories.UtenteRepository;

@Service
public class PrenotazioneService {
	
	@Autowired
	PrenotazioneRepository pr;

	@Autowired
	PostazioneRepository postRep;
	
	@Autowired
	UtenteRepository utenteRep;
	
//	public void prenota(Prenotazione p) throws UtentePrenotazioneException, PostazionePrenotazioneException {
////		List<Prenotazione> prenTrovate = pr.findByUtenteAndData(p.getUtente(), p.getData());
////		if(prenTrovate.size() == 0) {
////			pr.save(p);
////		} else {
////			throw new UtentePrenotazioneException();
////		}
//		if(pr.existsByPostazioneAndData(p.getPostazione(), p.getData())) {
//			throw new PostazionePrenotazioneException();
//		} 
//		if(pr.existsByUtenteAndData(p.getUtente(), p.getData())) {
//			throw new UtentePrenotazioneException();
//		}
//		pr.save(p);
//		
//	}
	
	public Prenotazione save(Prenotazione p) {
		return pr.save(p);
	}

	public Prenotazione prenota(LocalDate d, Long uid, Long pid) throws PostazionePrenotazioneException, UtentePrenotazioneException, Exception {
		Optional<Postazione> post = postRep.findById(pid);
		Optional<Utente> user = utenteRep.findById(uid);
		
		if(post.isPresent() && user.isPresent()) {
			if(pr.existsByPostazioneAndData(post.get(), d)) {
				throw new PostazionePrenotazioneException();
			} 
			if(pr.existsByUtenteAndData(user.get(), d)) {
				throw new UtentePrenotazioneException();
			}
			Prenotazione p = Prenotazione.builder()
					.data(d)
					.postazione(post.get())
					.utente(user.get())
					.build();
			return pr.save(p);
		}
		
		throw new Exception("Utente o postazione non trovata");
	}

	public Prenotazione update(Long id, Prenotazione p) {
		Optional<Prenotazione> oldP = pr.findById(id);
		if(oldP.isPresent()) {
			Prenotazione op = oldP.get();
			op.setData(p.getData());
			op.setUtente(p.getUtente());
			op.setPostazione(p.getPostazione());
			pr.save(op);
			return op;
		}
		throw new PrenotazioneNotFoundException();
	}

}
