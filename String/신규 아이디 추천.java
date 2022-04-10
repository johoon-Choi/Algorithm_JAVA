class Solution {
	public static String del(String str, int idx) {
		int rightSize = str.length() - idx - 1;
		
		String str1 = str.substring(0, idx);
		String str2 = str.substring(str.length() - rightSize);
		
		String ret = str1 + str2;

		return ret;
	}
	
	public static String solution(String new_id) {
		// 전부 소문자로 변경
		new_id = new_id.toLowerCase();
		
		// '-', '_', '.' 문자들을 제외한 문자들을 전부 제거
		for (int i = 0; i < new_id.length(); i++) {
			char cur = new_id.charAt(i);

			if ((cur < 'a' || 'z' < cur) && (cur < '0' || '9' < cur)) {
				if (cur != '-' && cur != '_' && cur != '.')
					new_id = del(new_id, i--);
			}
		}
		
		// '.' 이 2개 이상 연속으로 있는 부분들을 전부 '.'로 변경
		while (new_id.contains("..")) {
			new_id = new_id.replace("..", ".");
		}
		
		// '.' 로 시작하거나 끝날 때 그 점들을 제거 
		if (new_id.startsWith("."))
			new_id = new_id.substring(1);
		if (new_id.endsWith("."))
			new_id = new_id.substring(0, new_id.length() - 1);
		
		// new_id 가 빈 문자열 이라면 "a" 를 대입
		if (new_id.length() == 0) new_id = "a";
		
		// new_id 가 16자 이상이라면, index 0 ~ 14 문자들만 남기고,
		//   그 후 new_id 가 "." 으로 끝난다면 점을 제거
		if (16 <= new_id.length()) {
			new_id = new_id.substring(0, 15);
			if (new_id.endsWith("."))
				new_id = new_id.substring(0, new_id.length() - 1);
		}
		
		// new_id 가 2자 이하라면, 마지막 문자를 반복하여 3자 이상으로 변경
		while (new_id.length() < 3) {
			new_id += new_id.charAt(new_id.length() - 1);
		}
		
		String ret = new_id;
		return ret;
	}
}
