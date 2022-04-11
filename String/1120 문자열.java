import java.util.Scanner;

public class Main {
	public static void main (String args[]) {
		String str1, str2;
		
		Scanner input = new Scanner(System.in);
		str2 = input.next();
		str1 = input.next();

		int len1 = str1.length();
		int len2 = str2.length();
		
		int ans = 50;
		
		for (int i = 0; i < len1 - len2 + 1; i++) {
			int dif = 0;
			
			for (int j = 0; j < len2; j++)
				if (str1.charAt(j + i) != str2.charAt(j)) dif++;
	
			ans = (dif < ans? dif : ans);
		}
		
		System.out.println(ans);
	}
}
