package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import models.Postazione;
import models.Prenotazione;

import repositories.PostazioneRepository;
import repositories.PrenotazioneRepository;

import org.springframework.web.*;

@Service
public class PrenotazioneService {
	
	WebClient webClient = WebClient.build();
	
	@Autowired
	PrenotazioneRepository pr;

	@Autowired
	PostazioneRepository postRep;
	
//	@Autowired
//	UtenteRepository utenteRep;
	
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

	public Prenotazione prenota(LocalDate d, Long uid, Long pid) throws Exception {
		Optional<Postazione> post = postRep.findById(pid);
		
//		Optional<Utente> user = utenteRep.findById(uid);
		
		if(post.isPresent() && this.userExists(uid)) {
			if(pr.existsByPostazioneAndData(post.get(), d)) {
				throw new Exception();
			}
			if(pr.existsByUserAndData(uid, d)) {
				throw new Exception();
			}
			Prenotazione p = Prenotazione.builder()
					.data(d)
					.postazione(post.get())
					.user(uid)
					.build();
			return pr.save(p);
		}
		
		throw new Exception("Utente o postazione non trovata");
	}

	public Prenotazione update(Long id, Prenotazione p) throws Exception {
		Optional<Prenotazione> oldP = pr.findById(id);
		if(oldP.isPresent()) {
			Prenotazione op = oldP.get();
			op.setData(p.getData());
			op.setUser(p.getUser());
			op.setPostazione(p.getPostazione());
			pr.save(op);
			return op;
		}
		throw new Exception();
	}
	
	
	public boolean userExists(Long id) {
		
		Boolean res = webClient.get()
		.uri("http://localhost:8001/users/"+id)
		.bodyToMono(Boolean.class)
		.retrieve()
		.block();
		
		return res;
	}

}
