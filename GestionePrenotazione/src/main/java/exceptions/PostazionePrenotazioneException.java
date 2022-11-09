package exceptions;

public class PostazionePrenotazioneException extends Exception {

	public PostazionePrenotazioneException() {
		super("Impossibile creare la prenotazione, la postazione è già occupata in quella data");
	}
}
