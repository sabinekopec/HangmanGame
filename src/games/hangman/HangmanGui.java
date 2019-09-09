/*
 *  @version 1.08    August 2019
 *  
 *  @author Sabine Kopec
 *  
 *  This program is free software.
 *
 * JFrame icon taken from http://www.icons101.com/icon/id_75809/setid_2529/Brain_Games_by_QuizAnswers/HangmanGamegrey
 *  
 */


package games.hangman;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;



public class HangmanGui {

	private JLabel word; // guessed Word
	private JLabel phrase = new JLabel("Start a new game."); // label with phrase giving status of game
	private JFrame frame = new JFrame("Hangman");
	private GPanel graphic= new GPanel(); // hangman image
	private JButton generateNewWord;
	
	public void setJLabelWord(String val) {
		word.setText(val);
	}
	
	public String getJLabelWord() {
		return word.getText();
	}

	public void setJLabelPhrase(String val) {
		phrase.setText(val);
	}

	public void setJLabelGraphic(int count) {
		graphic.setRemainingTriesGPanel(count);
		graphic.repaint();
	}

	


	HangmanGui() {
		
		JPanel windowContent = new JPanel();
		
		GridLayout gl = new GridLayout(2,2);
		windowContent.setLayout(gl);

		
		word = new JLabel("",SwingConstants.CENTER);
		word.setFont(new Font("", Font.BOLD, 30));
		phrase.setFont(new Font("",Font.BOLD,15));
				
		generateNewWord = new JButton("Give me a new word");
		
		
		
		
		new HangmanEngineBody(this);
//		generateNewWord.addActionListener(HMEBody.ActionListenerMethod()); 
		

		windowContent.add(word);
		windowContent.add(graphic);
		windowContent.add(phrase);
		windowContent.add(generateNewWord);
		windowContent.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		

		frame.setContentPane(windowContent);
		
		frame.pack();
		
		// different icon for Frame
		File sourceIcon = new File("src/Hangman-Game-grey.Png");
		Image icon;
		try {
			icon = ImageIO.read(sourceIcon);
			frame.setIconImage(icon);
		} catch (IOException e) {
			System.out.println("Game Icon Image not found");
			e.printStackTrace();
		}
		
		//Display the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 650);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		
		
	
		
		
	}
	
	public void generateNewWordAddActionListener(ActionListener al) {
	    generateNewWord.addActionListener(al);
	}
	
	
	public static void main(String[] args) {
		new HangmanGui();	
	}

}
