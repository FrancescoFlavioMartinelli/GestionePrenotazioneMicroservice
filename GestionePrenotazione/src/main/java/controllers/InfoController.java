package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exceptions.LinguaNonTrovataException;
import services.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	@Autowired
	InfoService is;
	
	@GetMapping("/{lan}")
	public ResponseEntity<String> getInfo(@PathVariable String lan) {
		String info;
		try {
			info = is.getInfo(lan);
			return new ResponseEntity(info, HttpStatus.OK);
		} catch (LinguaNonTrovataException e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.NO_CONTENT);
		}
		
//		if(lan.equals("en")) {
//			return new ResponseEntity("instructions", HttpStatus.OK);
//		}
//		if(lan.equals("it")) {
//			return new ResponseEntity("istruzioni", HttpStatus.OK);
//		}
		
	}

}
