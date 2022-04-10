package com.greece.prometheus.leetcode;

/**
 * 11. Container With Most Water
 *
 */
public class LC_0011 {

	public static void main(String[] args) {
		
	}
	
	public int maxArea(int[] height) {
	    int maxarea = 0, l = 0, r = height.length - 1;
	    while (l < r) {
	        maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
	        if (height[l] < height[r])
	            l++;
	        else
	            r--;
	    }
	    return maxarea;
	}
}
