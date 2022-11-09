package runnable;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class PostazioneRunnable implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.print("POSTAZIONE RUNS");
		// TODO Auto-generated method stub
		
//		try {
//			ps.save(p)
//		} catch() {} catch() {}

	}

}
