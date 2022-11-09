package models;

import java.time.LocalDate;

import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import model.Postazione;
import model.Utente;

public class PrenotazioneDTO {


	private Long id;
	private LocalDate data;

	private Long user;

	private Postazione postazione;
}
