package com.greece.prometheus.leetcode;

public class LC_0007 {
	
	public int reverse(int x) {
	    long rev = 0;
	    while (x != 0) {
	        int pop = x % 10;
	        x /= 10;
	        rev = rev * 10 + pop;
	    }
	    if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE ) return 0;
	    return (int)rev;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public int reverse1(int x) {
		int res = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;
			res = res * 10 + pop;
		}
		return res;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

}
