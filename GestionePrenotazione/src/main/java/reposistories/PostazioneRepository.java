package reposistories;

import org.springframework.stereotype.Repository;

import model.Citta;
import model.Postazione;
import model.TipoPostazione;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, Long> {

	public List<Postazione> findByTipoAndEdificioCitta(TipoPostazione t, Citta c);
}
