package services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import exceptions.LinguaNonTrovataException;

@Service
public class InfoService {

	@Value("${info.english}") private String en;
	@Value("${info.english}") private String it;
	
	public String getInfo(String l) throws LinguaNonTrovataException {
		if(l.equals("en")) {
			return en;
		}
		if(l.equals("it")) {
			return it;
		}
		throw new LinguaNonTrovataException();
	}

}
