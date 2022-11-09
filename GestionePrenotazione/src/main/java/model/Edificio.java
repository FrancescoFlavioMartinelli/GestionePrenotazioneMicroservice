package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import config.CodiceEdificioConverter;
import lombok.Data;

@Entity
@Data
public class Edificio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String indirizzo;
	private Citta citta;
	@OneToMany(mappedBy="edificio")
	private List<Postazione> postazioni;
	
	@Enumerated(EnumType.STRING)
	private StatoEdificio status;
	
	@Convert(converter = CodiceEdificioConverter.class)
	private String codice;
}
