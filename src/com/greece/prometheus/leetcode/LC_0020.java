package com.greece.prometheus.leetcode;

public class LC_0020 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 3, 4};
		int[] b = {2, 6};
		System.out.println(findMedianSortedArrays(a, b));
	}
	
	public static double findMedianSortedArrays(int[] A, int[] B) {
	    int m = A.length;
	    int n = B.length;
	    int len = m + n;
	    int left = -1, right = -1;
	    int aStart = 0, bStart = 0;
	    for (int i = 0; i <= len / 2; i++) {
	        left = right;
	        if (aStart < m && (bStart >= n || A[aStart] < B[bStart])) {
	            right = A[aStart++];
	        } else {
	            right = B[bStart++];
	        }
	    }
	    if ((len & 1) == 0)
	        return (left + right) / 2.0;
	    else
	        return right;
	}
	
	public static double findMedianSortedArrays1(int[] a, int[] b) {
		int m = a.length;
		int n = b.length;
		int len = m + n;
		int l = 0, r = 0;
		int p1 = 0, p2 = 0;
		for (int i = 0; i < len/2; i++) {
			l = r;
			if (p1 < m && (p2 >= n || a[p1] < b[p2])) {
				r = a[p1++];
			} else {
				r = b[p2++];
			}
		}
		if ((len & 1) == 0) {
			return (l + r)/2.0;
		}
		return r;
	}

}
