package games.hangman;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

//import javax.swing.JButton;



public class HangmanEngineBody {
	
	private int count; // number of wrong tries; used to build up the hangman graphic
	private String guessedWord; // word to be guessed
	private String guessedWordLines; // guessed Word with letters substituted by lines, updated if letter is guessed correctly
	private Keyboard keys;	
	
	public String getGuessedWord() {
		return guessedWord;
	}
	
	/* initialize start screen for game: 
	 * get the word to guess (guessedWord), substitute all letters by lines (guessedWordLines)
	 * write guessedWordLines to GUI
	 * set number of false tries to zero and update it in the method that checks for the appearance of a letter in guessedWord
	 * call keyboard
	 */
	
//	constructor
	HangmanGui gui;
	HangmanEngineBody(HangmanGui gui){
		this.gui = gui;
//		System.out.println("Hier wird Engine gestartet");
		gui.generateNewWordAddActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				guessedWord = HangmanGetWord();
				guessedWordLines = guessedWord.replaceAll("[A-Z]", "-");
				gui.setJLabelWord(guessedWordLines);
				count = 0;
        

				gui.setJLabelGraphic(count);
//        System.out.println(guessedWord);
				gui.setJLabelPhrase("Please give a letter:");
				new Keyboard(HangmanEngineBody.this,gui);

        
		
		}
	});
	}

	
	public String HangmanGetWord() {
		
		int randomNumber;
		// try opening file, if length of word at least 3, select as guessedWord
		try (Stream<String> lines = Files.lines(Paths.get("filewithwords.txt"))) {
			randomNumber = ThreadLocalRandom.current().nextInt(0,4690);
			String chosenWord = lines.skip(randomNumber).findFirst().get();
			
			if (chosenWord.length() > 2) {
				guessedWord = chosenWord.toUpperCase();
			}
		// if file not found, select a word from the manual list wordArray
		} catch (IOException ioe){
			
			List<String> wordArray = Arrays.asList("HANGMAN", "MUSEUM", "MAINSTATION", "PROGRAMMING COURSE", "HOLIDAYS", "BEACH HOTEL");
			randomNumber = ThreadLocalRandom.current().nextInt(0, wordArray.size() + 1);
			guessedWord = wordArray.get(randomNumber);
		}
		
		
		
		return guessedWord;
	}
	
} //end class
