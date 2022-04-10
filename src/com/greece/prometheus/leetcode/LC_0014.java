package com.greece.prometheus.leetcode;

/**
 * 14. Longest Common Prefix
 *
 */
public class LC_0014 {

	public static void main(String[] args) {

	}

	public String longestCommonPrefix1(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		// 遍历所有列
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i); // 保存 i 列第 0 行的字符便于后续比较
			// 比较第 1,2,3... 行的字符和第 0 行是否相等
			for (int j = 1; j < strs.length; j++) {
				/**
				 * i == strs[j].length() 表明当前行已经到达末尾 strs[j].charAt(i) != c 当前行和第 0 行字符不相等
				 * 上边两种情况返回结果
				 */
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	/**
	 * 水平比较 我们将字符串水平排列，第 0 个和第 1 个字符串找最长子串，结果为 leet， 再把结果和第 2 个字符串比较，结果为 leet，
	 * 再把结果和第 3 个字符串比较，结果为 lee，即为最终结果。
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0]; // 保存结果
		// 遍历每一个字符串
		for (int i = 1; i < strs.length; i++) {
			// 找到上次得到的结果 prefix 和当前字符串的最长子串
			int minLen = Math.min(prefix.length(), strs[i].length());
			int j = 0;
			for (; j < minLen; j++) {
				if (prefix.charAt(j) != strs[i].charAt(j)) {
					break;
				}
			}
			prefix = prefix.substring(0, j);
		}
		return prefix;
	}

	/**
	 * 递归求解
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		return longestCommonPrefix(strs, 0, strs.length - 1);
	}

	// 递归不断分成两部分
	private String longestCommonPrefix(String[] strs, int l, int r) {
		if (l == r) {
			return strs[l];
		} else {
			int mid = (l + r) / 2;
			String lcpLeft = longestCommonPrefix(strs, l, mid);
			String lcpRight = longestCommonPrefix(strs, mid + 1, r);
			return commonPrefix(lcpLeft, lcpRight);
		}
	}

	// 求两个结果的最长公共前缀
	String commonPrefix(String left, String right) {
		int min = Math.min(left.length(), right.length());
		for (int i = 0; i < min; i++) {
			if (left.charAt(i) != right.charAt(i))
				return left.substring(0, i);
		}
		return left.substring(0, min);
	}
	
	/**********************************************************************************************/
	
	public String lcp(String[] strs) {
		if (strs == null || strs.length == 0) {
			return null;
		}
		return lcp(strs, 0, strs.length - 1);
	}
	
	public String lcp(String[] strs, int l, int r) {
		if (l == r) {
			return strs[l];
		}
		int mid = l + ((r - l) >> 2);
		String leftlcp = lcp(strs, l, mid);
		String rightlcp = lcp(strs, mid, r);
		return cp(leftlcp, rightlcp);
	}
	
	public String cp(String leftlcp, String rightlcp) {
		int minLen = Math.min(leftlcp.length(), rightlcp.length());
		for (int i = 0; i < minLen; i++) {
			if (leftlcp.charAt(i) != rightlcp.charAt(i)) {
				return leftlcp.substring(0, i);
			}
		}
		return leftlcp.substring(0, minLen);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}