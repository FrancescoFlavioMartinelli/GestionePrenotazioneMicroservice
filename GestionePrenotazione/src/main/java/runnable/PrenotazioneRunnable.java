package runnable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import model.Postazione;
import model.Prenotazione;

@Component
@Order(0)
public class PrenotazioneRunnable implements CommandLineRunner {


	@Override
	public void run(String... args) throws Exception {
		System.out.print("PRENOTAZIONE RUNS");
		
//		Prenotazione p = new Prenotazione();
//		p.setData(LocalDate.now());
//		p.setPostazione(new Postazione());
		

	}

}
