package com.greece.prometheus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_0003 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int lengthOfLongestSubstring(String s) {
		int len = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < len; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			ans = Math.max(ans, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return ans;
	}

}
