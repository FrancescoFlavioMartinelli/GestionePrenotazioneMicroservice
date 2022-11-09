package model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

import lombok.Data;
import security.entities.Role;

@Entity
@Data
public class Utente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    @Column(unique = true, nullable = false)
	private String username;
	private String password;
	private String nome;
	private String email;
    private Boolean active;

	@OneToMany(mappedBy="utente")
	private List<Prenotazione> prenotazioni;

    @ManyToMany
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "utente_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<Role>();
	
	

}
