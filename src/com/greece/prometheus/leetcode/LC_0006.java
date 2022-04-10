package com.greece.prometheus.leetcode;

/**
 * ZigZag conversion
 * @author zhangyuanchao
 *
 */
public class LC_0006 {
	
	public static String convert(String s, int row) {
		if (row <= 1) {
			return s;
		}
		int n = s.length();
		int cycleLen = (row << 1) -2;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j + i < n; j += cycleLen) {
				res.append(s.charAt(i + j));
				if (i != 0 && i != row - 1) {
					res.append(s.charAt(j + cycleLen -i));
				}
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "PAYPALISHIRING";
		String result = convert(s, 3);
		System.out.println(result);
	}

}
