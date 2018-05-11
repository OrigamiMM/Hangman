import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JOptionPane;

public class Hangman {
	ArrayList<String> words = new ArrayList<String>();
	// Stack<String> hangWords = new Stack<String>();
	ArrayList<Integer> ranInts = new ArrayList<Integer>();
	Random ran = new Random();
	int counter = 0;
	int wanted;

	public static void main(String[] args) {
		String am = JOptionPane.showInputDialog("How may times do you want to play?");
		int amount = Integer.parseInt(am);
		Hangman man = new Hangman();
		man.numbers(amount);
		man.randomWord();
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
			for (String i : words) {
				System.out.println(i);
			}
		}
	}

	void checkWantedWord(String line) {
		if (wanted == counter) {
			words.add(line);
		}
		counter++;
		if (!ranInts.isEmpty()) {
			ranInts.remove(0);
		}

		if (!ranInts.isEmpty()) {
			wanted = ranInts.get(0);
		}
	}
}
