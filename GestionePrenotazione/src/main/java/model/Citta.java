package model;

import javax.persistence.Entity;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Entity
@Data
public class Citta {
	
	@Id
	private Long id;
	private String nome;

}
