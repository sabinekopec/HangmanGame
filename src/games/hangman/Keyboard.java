package games.hangman;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Keyboard {
	
	private String qwerty = "QWERTYUIOPASDFGHJKLZXCVBNM";
	private JButton buttonLabel;
	private JFrame frame = new JFrame("Keyboard");

 
	public void setClose() {
		frame.setVisible(false);
	}

	
	
	HangmanEngineBody engine;
	HangmanGui gui;
	public Keyboard(HangmanEngineBody engine, HangmanGui gui) {
		
		JPanel windowContent = new JPanel();
		
		GridLayout gl = new GridLayout(3,10);
		windowContent.setLayout(gl);
		
		
		HangmanEngineContainsLetter game = new HangmanEngineContainsLetter(this,engine,gui);
		
		// create buttons for all letters in String qwerty
		for(int i = 0; i < qwerty.length(); i++) {
			String label = "" + qwerty.charAt(i);
			buttonLabel = new JButton(label);
			windowContent.add(buttonLabel);
			
			// implement actionListener for all buttons (see HangmanEngineContainsLetter
			buttonLabel.addActionListener(game);
	
		}
		
		frame.setContentPane(windowContent);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(800,200);
		frame.setVisible(true);
		
	}
}