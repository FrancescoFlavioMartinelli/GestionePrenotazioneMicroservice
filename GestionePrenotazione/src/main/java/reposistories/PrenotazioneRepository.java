package reposistories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Postazione;
import model.Prenotazione;
import model.Utente;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	
	public List<Prenotazione> findByUtenteAndData(Utente u, LocalDate d);
	
	public Boolean existsByUtenteAndData(Utente u, LocalDate d);
	
	public Boolean existsByPostazioneAndData(Postazione p, LocalDate d);

}
