import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class problem_21 {
public static void main(String[] args) {
	String msg = JOptionPane.showInputDialog("Type in a Message");
	try {
		FileWriter fileWriter = new FileWriter("src/Test.txt");
		fileWriter.write(msg);
		fileWriter.close();
	} catch (IOException e) {
		e.printStackTrace();
}
}
}
