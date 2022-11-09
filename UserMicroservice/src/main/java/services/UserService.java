package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

import models.PrenotazioneDTO;

@Service
public class UserService {


	WebClient webClient = WebClient.build();
	
	TypeFactory tf = new ObjectMapper().getTypeFactory();
	
	@Autowired
	UserRepository ur;
	
	public Boolean existById(Long id) {
		return ur.existsById(id);
	}
	
	public List<PrenotazioneDTO> getPrenotazioni(Long id) {

		List<PrenotazioneDTO> res = webClient.get()
		.uri("http://localhost:8000/user/"+id)
		.bodyToMono(List.class)
		.retrieve()
		.block();
		
//		tf.constructCollectionLikeType(List.class, PrenotazioneDTO.class)
		
		return res;
	}
}
