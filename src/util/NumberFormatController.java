package util;

public class NumberFormatController {

	public static boolean isNumber(String candidateNum) {
		boolean flag = true;
		int counter = 0;
		for(int i = 0;i < candidateNum.length(); i++) {
			if(candidateNum.charAt(i) < 48 || candidateNum.charAt(i) > 57) {
				flag = false;
			}
			
			if(candidateNum.charAt(i) == '0') {
				counter++;
			}
		}
		
		return flag && counter < candidateNum.length();
	}
	
}
