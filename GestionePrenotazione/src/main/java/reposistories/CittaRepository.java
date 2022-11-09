package reposistories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Citta;

@Repository
public interface CittaRepository extends JpaRepository<Citta, Long> {

}
