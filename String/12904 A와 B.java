import java.util.Scanner;

public class Main {
	public static void main (String args[]) {
		String cur = "";
		String tar = "";
		
		Scanner input = new Scanner(System.in);
		cur = input.next();
		tar = input.next();
		
		boolean l = false, r = true;
		while (cur.length() != tar.length()) {
			if (r) { // right side 
				if (tar.endsWith("B")) {
					r = false; l = true;
				}
				tar = tar.substring(0, tar.length() - 1);
			}
			else if (l) { // left side
				if (tar.startsWith("B")) {
					r = true; l = false;
				}
				tar = tar.substring(1);
			}
		}
		
		int ans = 1;
		
		if (tar.equals(cur) && r);
		else if (l) {
			int len = tar.length();
			
			for (int i = 0; i < len; i++) {
				if (cur.charAt(i) != tar.charAt(len - i - 1)) {
					ans = 0;
				}
			}
		}
		else ans = 0;
		
		System.out.print(ans); // int 형으로 출력 안 하면 2%에서 fail
	}
}
