package controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserContrller {
	
	@Autowired
	UserService us;
	
	@GetMapping("/{id}")
	public ResponseEntity<Boolean> userExists(@PathVariable Long id) {
		 ResponseEntity.ok(us.existById(id));
	}
	
	@GetMapping("/prenotazioni/{id}")
@CrossOrigin(origins="http://localhost:8000")	
	public ResponseEntity<List<PrenotazioneDTO>> getPrentazioni(@PathVariable Long id) {
		return ResponseEntity.ok(us.getPrenotazioni(id));
	}
	

}
