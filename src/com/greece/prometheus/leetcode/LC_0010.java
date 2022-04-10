package com.greece.prometheus.leetcode;

/**
 * 10. Regular Expression Matching
 *
 */
public class LC_0010 {

	public static void main(String[] args) {

		
	}
	
	public boolean isMatch1(String text, String pattern) {
	    // ��һά�Ŀռ䣬��Ϊ�� dp[len - 1][j] ��ʱ����Ҫ֪�� dp[len][j] �������
	    // ��һά�Ļ����Ϳ��԰� �� dp[len - 1][j] Ҳд��ѭ����
	    boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
	    // dp[len][len] ���������մ��Ƿ�ƥ���ˣ�"" �� "" ����Ȼ�� true �ˡ�
	    dp[text.length()][pattern.length()] = true;

	    // �� len ��ʼ����
	    for (int i = text.length(); i >= 0; i--) {
	        for (int j = pattern.length(); j >= 0; j--) {
	            // dp[text.length()][pattern.length()] �Ѿ������˳�ʼ��
	            if(i==text.length()&&j==pattern.length()) continue;

	            boolean first_match = (i < text.length() && j < pattern.length()
	                                   && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
	            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
	                dp[i][j] = dp[i][j + 2] || first_match && dp[i + 1][j];
	            } else {
	                dp[i][j] = first_match && dp[i + 1][j + 1];
	            }
	        }
	    }
	    return dp[0][0];
	}

    public boolean isMatch(String text, String pattern) {
        // ��һά�Ŀռ䣬��Ϊ�� dp[len - 1][j] ��ʱ����Ҫ֪�� dp[len][j] �������
        // ��һά�Ļ����Ϳ��԰� �� dp[len - 1][j] Ҳд��ѭ����
        boolean[][] dp = new boolean[2][pattern.length() + 1]; 
        dp[text.length()%2][pattern.length()] = true;

        // �� len ��ʼ����
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                if(i==text.length()&&j==pattern.length()) continue;
                boolean first_match = (i < text.length() && j < pattern.length()
                        && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                    dp[i%2][j] = dp[i%2][j + 2] || first_match && dp[(i + 1)%2][j];
                } else {
                    dp[i%2][j] = first_match && dp[(i + 1)%2][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
