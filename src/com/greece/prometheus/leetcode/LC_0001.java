package com.greece.prometheus.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LC_0001 {

	public static void main(String[] args) {
		int nums[] = {2, 6, 9, 7, 3, 5};
		int result[] = twoSum(nums, 5);
		System.out.println(result[0] + ":" + result[1]);

	}
	
	public static int[] twoSum(int[] nums, int target) {
	    Map<Integer, Integer> map = new HashMap<>();
	    for (int i = 0; i < nums.length; i++) {
	    	int sub = target - nums[i];
	    	if (map.containsKey(sub)) {
	    		return new int[]{map.get(sub), i};
	    	}
	    	map.put(nums[i], i);
	    }
	    throw new IllegalArgumentException("no two sum solution");
	}

}
