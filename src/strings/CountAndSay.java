package strings;

public class CountAndSay {
	
	public static void main(String[] args) {
		System.out.println(new CountAndSay().countAndSay(9));
	}
	
    public String countAndSay(int limit) {
    	if(limit < 1) {
    		return "";
    	}
    	if(limit == 1) {
    		return "1";
    	} else if (limit == 2) {
    		return "11";
    	}
		else {
			StringBuilder src = new StringBuilder("11"), target = src;
			for (int i = 0; i < limit - 2; i++) {
				target = new StringBuilder();
				int sit = 0;
				while (sit < src.length()) {
					char sitChar = src.charAt(sit);
					int run = sit + 1;
					while (run < src.length()) {
						if(src.charAt(run) == sitChar) {
							run++;
						} else {
							break;
						}
					}
					int count = run - sit;
					sit = run;
					target.append(count).append(sitChar);
				}
				src = target;

			}
			return target.toString();
		}
    	
    }

}
