package com.greece.prometheus.leetcode;

/**
 * 12. Integer to Roman
 *
 */
public class LC_0012 {

	public static void main(String[] args) {
		String res = intToRoman(27);
		System.out.println(res);
	}
	
	public static String intToRoman(int num) {
		// I 1
		// V 5
		// X 10
		// L 50
		// C 100
		// D 500
		// M 1000
	    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
	    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

	    StringBuilder sb = new StringBuilder();

	    for(int i=0;i<values.length;i++) {
	        while(num >= values[i]) {
	            num -= values[i];
	            sb.append(strs[i]);
	        }
	    }
	    return sb.toString();
	}

}
