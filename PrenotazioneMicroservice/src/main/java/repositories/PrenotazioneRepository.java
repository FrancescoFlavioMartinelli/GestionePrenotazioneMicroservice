package repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Postazione;
import models.Prenotazione;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, Long> {
	
	public List<Prenotazione> findByUserAndData(Long u, LocalDate d);
	
	public Boolean existsByUserAndData(Long u, LocalDate d);
	
	public Boolean existsByPostazioneAndData(Postazione p, LocalDate d);

}
