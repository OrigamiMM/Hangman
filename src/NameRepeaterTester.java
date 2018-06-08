
public class NameRepeaterTester {
public static void main(String[] args) {
	NameRepeater nR = new NameRepeater();
	Thread thread = new Thread(nR);
	thread.run();
}
}
