package games.hangman;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class HangmanEngineContainsLetter implements ActionListener{
	private int count;
	private String guessedWord; // word to be guessed
	private String guessedWordLines;// word with letters that are already guessed correctly, others represented by lines
	
	Keyboard keys;
	HangmanEngineBody HMEBody;
	HangmanGui gui;
	HangmanEngineContainsLetter(Keyboard keys, HangmanEngineBody HMEBody, HangmanGui gui) {
		this.keys = keys;
		this.HMEBody = HMEBody;
		this.gui = gui;
		
	}
	
	public void setRemainingTries(int val) {
		count = val;
	}

	public void actionPerformed(ActionEvent e) {
		
		
		JButton buttonlabel = (JButton) e.getSource();
		String clickedButtonLabel = buttonlabel.getText();
		
	
//		JOptionPane.showConfirmDialog(null, "Letter is " + clickedButtonLabel, "Just a test", JOptionPane.PLAIN_MESSAGE);
		buttonlabel.setEnabled(false);
		
		//call method that checks whether letter is in guessedWord
		guessedWordLines = HangmanEngineContainsLetterMethod(clickedButtonLabel);
		
		//update word in GUI
		gui.setJLabelWord(guessedWordLines);
		
		// repaint Hangman image in GUI
		gui.setJLabelGraphic(count);
		
		System.out.println(guessedWordLines);
	}
		
		
	//method that checks whether guessLetter is in guessedWord and returns updated String guessedWordLines
	public String HangmanEngineContainsLetterMethod(String guessLetter){
		
		
		// get guessedWord from Body and GuessedWordLines from GUI
		guessedWord = HMEBody.getGuessedWord();
		guessedWordLines = gui.getJLabelWord();
		
		
		/* if guessLetter appears in guessedWord: find its index position in guessedWord, 
		 *	fill it in on those positions in guessedWordLines 
		 *	and return guessedWordLines
		*/
		if (guessedWord.contains(guessLetter)) {
			
			StringBuilder myname = new StringBuilder(guessedWordLines);
			int index = 0;
			int indexPosition = 0;
			for (int i = 0; i < guessedWord.length(); i++) {
				
				index = guessedWord.indexOf(guessLetter, indexPosition);
				indexPosition = index + 1;
				
				if (index < 0) {
					break;
				}
				
				myname.setCharAt(index,guessLetter.charAt(0));
				guessedWordLines = myname.toString();
				
			}
						
			// condition to end game with a win, closing keyboard
			if (guessedWordLines.equals(guessedWord)) {
				System.out.println("Game is won.");
				gui.setJLabelPhrase("Game is won. Congratulations");
		        keys.setClose();
			}
			
			return guessedWordLines;
			
		/* if guessLetter does not appear in guessedWord:
		 * increase number of false tries (count)
		 * if maximum number of false tries exceeded (count == 7): end of game (lost), close keyboard
		 */
		} else {
			count = count +1;
			
			if (count == 7) {
				System.out.println("Game is lost.");
				gui.setJLabelPhrase("<html>Game is lost. Hope you have more luck next time.<br>Correct word was " + guessedWord);
				keys.setClose();
			}
			return guessedWordLines;
		}
			
	}

	
}

