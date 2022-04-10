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
		// ����������
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i); // ���� i �е� 0 �е��ַ����ں����Ƚ�
			// �Ƚϵ� 1,2,3... �е��ַ��͵� 0 ���Ƿ����
			for (int j = 1; j < strs.length; j++) {
				/**
				 * i == strs[j].length() ������ǰ���Ѿ�����ĩβ strs[j].charAt(i) != c ��ǰ�к͵� 0 ���ַ������
				 * �ϱ�����������ؽ��
				 */
				if (i == strs[j].length() || strs[j].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}

	/**
	 * ˮƽ�Ƚ� ���ǽ��ַ���ˮƽ���У��� 0 ���͵� 1 ���ַ�������Ӵ������Ϊ leet�� �ٰѽ���͵� 2 ���ַ����Ƚϣ����Ϊ leet��
	 * �ٰѽ���͵� 3 ���ַ����Ƚϣ����Ϊ lee����Ϊ���ս����
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix2(String[] strs) {
		if (strs.length == 0)
			return "";
		String prefix = strs[0]; // ������
		// ����ÿһ���ַ���
		for (int i = 1; i < strs.length; i++) {
			// �ҵ��ϴεõ��Ľ�� prefix �͵�ǰ�ַ�������Ӵ�
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
	 * �ݹ����
	 * 
	 * @param strs
	 * @return
	 */
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";
		return longestCommonPrefix(strs, 0, strs.length - 1);
	}

	// �ݹ鲻�Ϸֳ�������
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

	// ����������������ǰ׺
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