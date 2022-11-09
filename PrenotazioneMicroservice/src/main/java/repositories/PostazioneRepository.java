package repositories;

import org.springframework.stereotype.Repository;

import models.Citta;
import models.Postazione;
import models.TipoPostazione;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	public List<Postazione> findByTipoAndEdificioCitta(TipoPostazione t, Citta c);
}
