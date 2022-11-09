package models;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

import lombok.Builder;
import lombok.Data;

@Entity
@Data
@Builder
public class Prenotazione {

	@Id
	private Long id;
	private LocalDate data;
	private Long user;
	@ManyToOne
	private Postazione postazione;
}
