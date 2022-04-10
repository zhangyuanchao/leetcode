package com.greece.prometheus.leetcode;

/**
  * 给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
 * 
  * 示例1
  * 输入: "tree"
  * 输出: "eert"
  * 解释: 'e'出现两次，'r'和't'都只出现一次。因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
 * 
  * 示例2
  * 输入: "cccaaa"
  * 输出: "cccaaa"
  * 解释: 'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。注意"cacaca"是不正确的，因为相同的字母必须放在一起。
 * 
  * 示例3
  * 输入: "Aabb"
  * 输出: "bbAa"
  * 解释: 此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。注意'A'和'a'被认为是两种不同的字符。
 */
public class LC_0451 {
	
	private final static char BASE_CHAR = 'A';
	
	private static int[] counts = new int[58];
	private static char[] characters = new char[58];

	public static void main(String[] args) {
		Long start = System.currentTimeMillis();
		// String raw = "CharactersayohgghoongiaopodkjgjappdpphoajgjaogjaojfpjaoputpahghmjauhaqkinppgjajhjkkejjjdaaadbunAAAGUULGANHHALPAHNHXLAHEUJBABG";
		String raw = "characters";
		init(raw);
		sort(counts);
		String result = compact();
		System.out.println(result);
		Long end = System.currentTimeMillis();
		System.out.println(start-end);
	}
	
	// 初始化characters, 保存'A'-'z'的字符，并且统计字符频数
	private static void init(String raw) {
		for (int i = 0; i < characters.length; i++) {
			characters[i] = (char)(BASE_CHAR + i);
		}
		char[] cs = raw.toCharArray();
		int index = 0;
		for (char c : cs) {
			index = c - BASE_CHAR;
			counts[index]++;
		}
	}
	
	private static String compact() {
		StringBuffer buffer = new StringBuffer();
		for (int i = counts.length - 1; i >= 0; i--) {
			if (counts[i] == 0) {
				break;
			}
			int count = counts[i];
			for (int n = 0; n < count; n++) {
				buffer.append(characters[i]);
			}
		}
		return buffer.toString();
	}
	
	public static void sort(int arr[]) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int e = arr.length - 1; e > 0; e--) {
			for (int i = 0; i < e; i ++) {
				if (arr[i] > arr[i + 1]) {
					swap(arr, i, i + 1);
				}
			}
		}
	}
	
	// 交换arr的i和j位置的值
	public static void swap(int arr[], int i, int j) {
		arr[i] = arr[i] ^ arr[j];
		arr[j] = arr[i] ^ arr[j];
		arr[i] = arr[i] ^ arr[j];
		
		characters[i] = (char)((int)characters[i] ^ (int)characters[j]);
		characters[j] = (char)((int)characters[i] ^ (int)characters[j]);
		characters[i] = (char)((int)characters[i] ^ (int)characters[j]);
	}
	
	public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
        	return;
        }
        process(arr, 0, arr.length - 1);
    }
	
	public static void process(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = L + ((R - L) >> 1);
		process(arr, L, mid);
		process(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}
	
	public static void merge(int[] arr, int L, int M, int R) {
		int[] help = new int[R - L + 1];
		char[] chelp = new char[R - L + 1];
		int i = 0, j = 0;
		int p1 = L;
		int p2 = M + 1;
		int p1c = L;
		int p2c = M + 1;
		while (p1 <= M && p2 <= R) {
			help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
			chelp[j++] = arr[p1c] <= arr[p2c] ? characters[p1c++] : characters[p2c++];
		}
		while (p1 <= M) {
			help[i++] = arr[p1++];
			chelp[j++] = characters[p1c++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
			chelp[j++] = characters[p2c++];
		}
		for ( i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
			characters[L + i] = chelp[i];
		}
	}

}
