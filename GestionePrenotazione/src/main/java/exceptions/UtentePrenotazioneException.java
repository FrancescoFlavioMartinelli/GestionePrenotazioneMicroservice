package exceptions;

public class UtentePrenotazioneException extends Exception {
	
	public UtentePrenotazioneException() {
		super("Impossibile creare la prenotazione, l'utente ha già una prenotazione in quella data");
	}

}
