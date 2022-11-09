package config;

import java.awt.RenderingHints.Key;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

@Converter
public class CodiceEdificioConverter implements AttributeConverter<String, String> {
	
	@Autowired
	private PasswordEncoder pe;
	
	Key key = new SecretKeySpec(KEY, "AES");

	@Override
	public String convertToDatabaseColumn(String codiceEdificio) {
//		String codiceCriptato = pe.encode(codiceEdificio);
//		return codiceCriptato;
		
		try {
			Cipher c = Cipher.getInstance("AES");
			c.init(Cipher.ENCRYPT_MODE, key);
			return Base64.getEncoder().encodeToString((c.doFinal(codiceEdificio.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
//	}

	@Override
	public String convertToEntityAttribute(String codiceCriptato) {
//		String codiceEdificio = pe.decode(codiceCriptato);
//		return codiceEdifico;

		try {
			Cipher c = Cipher.getInstance("AES");
			c.init(Cipher.DECRYPT_MODE, key);
			return Base64.getEncoder().encodeToString((c.doFinal(codiceCriptato.getBytes())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
