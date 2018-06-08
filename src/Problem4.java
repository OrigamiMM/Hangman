import java.util.HashMap;

public class Problem4 {
static HashMap<String, Integer> birthdays;
	public static void main(String[] args) {
		birthdays = new HashMap<String,Integer>();
		birthdays.put("Oscar", 10);
		birthdays.put("car", 9);
		birthdays.put("scar", 11);
		if (checkName(birthdays,"r")) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
		
	}
	
	static Boolean checkName(HashMap h, String name) {
		for (Object o : h.keySet()) {
			if (o.equals(name)) {
				return true;
			}
		}
		
		return false;
		
	}
}
