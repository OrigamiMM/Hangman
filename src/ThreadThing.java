
public class ThreadThing {
public static void main(String[] args) {
	Thread thread = new Thread(()-> {
		for (int i = 0; i < 100; i++) {
			System.out.println("Oscar");
		}
	});
	thread.start();
}
}
