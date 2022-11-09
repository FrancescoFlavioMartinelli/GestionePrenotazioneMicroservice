package runnable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.manuelsenatore.security.security.entities.User;

@Component
@Order(1)
public class UtenteRunnable implements CommandLineRunner {
	
	@Autowired
	UserService us;
	
	@Autowired
	PasswordEncoder pe;
	
	
	@Override
	public void run(String... args) throws Exception {
//		System.out.println("UTENTE RUNS");
//		
//		Utente u = new Utente();
//		
//		ur.save(u);
		
		this.updatePassword();
		
		
	}
	
	public void updatePassword() {
		List<User> userList = us.findAll();
		for(User u : userList) {
			u.setPassword(pe.encode(u.getPassword()));
			us.save(u);
		}
		//findAll
		//forEach -> setPassword(pe.encode(getPassword()))
	}
	
	
	

	
}
