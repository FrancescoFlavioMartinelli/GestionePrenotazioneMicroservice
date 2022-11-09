package models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CascadeType;
import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Data
public class Postazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String descr;
	@Enumerated(EnumType.STRING)
	private TipoPostazione tipo;
	private int nMax;
	@ManyToOne
	private Edificio edificio;
	
	@OneToMany(mappedBy="postazione")
	private List<Prenotazione> prenotazioni;
	
}
