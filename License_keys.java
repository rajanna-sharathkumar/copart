package copart;

import java.util.Scanner;

public class License_keys {

	public static String validate(String S, int k){

		S = S.replaceAll("-", "");
		S = S.toUpperCase();

		int length = S.length();
		int first_length = 0;

		if(length%k!=0){
			first_length = length%k;
		}


		StringBuilder res = new StringBuilder();
		int posi = 0;
		if(first_length!=0){
			for(posi=0; posi<first_length; posi++){
				res.append(S.charAt(posi));
			}
			res.append("-");
		}

		for(int i=0;i<length-posi; i++){
			res.append(S.charAt(i+posi));
			if((i+1)%k==0){
				res.append("-");
			}
		}
		
		if(res.toString().endsWith("-")){
			res.deleteCharAt(res.length()-1);
		}

		return res.toString();
	}

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		System.out.println("Input the string");
		String S = in.nextLine();
		System.out.println("Input Length");
		int k = in.nextInt();
		System.out.println(validate(S,k));
	}

}
