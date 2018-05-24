import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Hangman implements KeyListener{
	ArrayList<String> words = new ArrayList<String>();
	Stack<String> hangWords = new Stack<String>();
	ArrayList<Integer> ranInts = new ArrayList<Integer>();
	ArrayList<JLabel> labels;
	Random ran = new Random();
	ArrayList<String> theWord = new ArrayList<String>();
	ArrayList<String> guessedC = new ArrayList<String>();
	String word;
	int counter = 0;
	int kounter = 0;
	int wanted;
	char currentKey;
	JPanel panel = new JPanel();

	public static void main(String[] args) {
		String am = JOptionPane.showInputDialog("How may times do you want to play?");
		int amount = Integer.parseInt(am);
		Hangman man = new Hangman();
		man.numbers(amount);
		System.out.println();
		man.randomWord();
		System.out.println();
		man.GUI();
	}

	void numbers(int amount) {
		int placeholder = 0;
		for (int i = 0; i < amount; i++) {
			int wordNum = ran.nextInt(3000);
			ranInts.add(wordNum);
		}
		for (int i = 0; i < ranInts.size(); i++) {
			for (int j = 0; j < ranInts.size(); j++) {
				if (ranInts.get(j) > ranInts.get(i)) {
					placeholder = ranInts.get(i);
					ranInts.set(i, ranInts.get(j));
					ranInts.set(j, placeholder);
				}
			}
		}
		for (Integer integer : ranInts) {
			System.out.println(integer);
		}
	}

	void randomWord() {
		if (!ranInts.isEmpty()) {
			wanted = ranInts.get(0);
			try {
				BufferedReader read = new BufferedReader(new FileReader("src/dictionary.txt"));
				String line = read.readLine();
				checkWantedWord(line);
				while (line != null) {
					line = read.readLine();
					checkWantedWord(line);
				}

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for (String t : words) {
				System.out.println(t);
			}
			randomString(words);
		}
	}

	void randomString(ArrayList list) {
		while(!list.isEmpty()) {
			int random = ran.nextInt(list.size());
			hangWords.push(words.get(random));
			list.remove(random);
		}
		System.out.println();
		for (String string : hangWords) {
			System.out.println(string);
		}
	}

	void checkWantedWord(String line) {
		if (wanted == counter) {
			words.add(line);
			if (!ranInts.isEmpty()) {
				ranInts.remove(0);
			}

			if (!ranInts.isEmpty()) {
				wanted = ranInts.get(0);
			}
		}
		counter++;
	}
	void GUI() {
		word = hangWords.pop();
		JFrame frame = new JFrame();
		frame.addKeyListener(this);
		labels = new ArrayList<JLabel>();
		for (int i = 0; i < word.length(); i++) {
			JLabel label = new JLabel(" _ ");
			labels.add(label);
			panel.add(labels.get(i));
		}
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		currentKey = arg0.getKeyChar();
		System.out.println(currentKey);
		for (int i = 0; i < word.length(); i++) {
			if (currentKey == word.charAt(i)) {
				String le = ""+currentKey;
				guessedC.add(le);
				JLabel l = labels.get(i);
				l.setText(le);
			}
		}
		if (kounter == word.length()) {
			System.out.println("full");
			word = hangWords.pop();
			for (int i = 0; i < word.length(); i++) {
				String le = ""+currentKey;
				JLabel l = labels.get(i);
				l.setText(le);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
