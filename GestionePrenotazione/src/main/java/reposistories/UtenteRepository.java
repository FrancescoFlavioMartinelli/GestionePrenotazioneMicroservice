package reposistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Utente;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
	
	

}
