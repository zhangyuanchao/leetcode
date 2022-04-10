package com.greece.prometheus.leetcode;

/**
 * 9. Palindrome Number
 *
 */
public class LC_0009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	
	public int reverse(int x) {
		int rev = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= x;
			rev = rev * 10 + pop;
		}
		return rev;
	}
	
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int rev = reverse(x);
		return rev == x;
	}

}