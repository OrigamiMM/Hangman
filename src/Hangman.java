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
	Random ran = new Random();
	int counter = 0;
	int wanted;
	String currentKey;

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
		String word = hangWords.pop();
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JLabel label = new JLabel(word);
		frame.setVisible(true);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label);
		frame.pack();
	
	}
	void checkKey(String word, String CurrentKey) {
		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		currentKey = "" + arg0.getKeyCode();
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
