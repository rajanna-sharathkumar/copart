package copart;

import java.util.Scanner;

public class StringtoInteger {
	public static int myAtoi(String str) {

		if(str.length()==0){
			return 0;
		}

		boolean min = false;
		StringBuilder res = new StringBuilder(str);
		int i=0;
		for(i=0; i<res.length();i++){
			if(!Character.isSpaceChar(res.charAt(i))){
				break;
			}
			//System.out.println(res.charAt(i));
			res.deleteCharAt(i);
			i--;
		}


		if(res.toString().startsWith("-")){
			res.deleteCharAt(0);
			min = true;
		}

		else if(res.toString().startsWith("+")){
			res.deleteCharAt(0);
			min = false;
		}

		if(res.length()==0){
			return 0;
		}

		str = res.toString();
		res.delete(0, res.length());

		long res_long = 0;

		for(int j = 0; j<str.length(); j++){
			if(!Character.isDigit(str.charAt(j))){
				break;
			}
			res.append(str.charAt(j));
		}


		for(int j=0; j< res.length(); j++){
			char c = res.charAt(j);
			int val = Character.getNumericValue(c);
			res_long = res_long*10+val;
			if(res_long*(min?-1:1)>=Integer.MAX_VALUE){
				return Integer.MAX_VALUE;
			}
			else if(res_long*(min?-1:1) <= Integer.MIN_VALUE){
				return Integer.MIN_VALUE;
			}
		}


		return Math.toIntExact(res_long *(min?-1:1));
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the string to be converted to Integer: ");
		String input = in.nextLine();
		System.out.println(myAtoi(input));

	}

}
