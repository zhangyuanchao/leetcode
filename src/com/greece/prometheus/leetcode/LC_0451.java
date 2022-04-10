package com.greece.prometheus.leetcode;

/**
  * ����һ���ַ������뽫�ַ�������ַ����ճ��ֵ�Ƶ�ʽ������С�
 * 
  * ʾ��1
  * ����: "tree"
  * ���: "eert"
  * ����: 'e'�������Σ�'r'��'t'��ֻ����һ�Ρ����'e'���������'r'��'t'֮ǰ�����⣬"eetr"Ҳ��һ����Ч�Ĵ𰸡�
 * 
  * ʾ��2
  * ����: "cccaaa"
  * ���: "cccaaa"
  * ����: 'c'��'a'���������Ρ����⣬"aaaccc"Ҳ����Ч�Ĵ𰸡�ע��"cacaca"�ǲ���ȷ�ģ���Ϊ��ͬ����ĸ�������һ��
 * 
  * ʾ��3
  * ����: "Aabb"
  * ���: "bbAa"
  * ����: ���⣬"bbaA"Ҳ��һ����Ч�Ĵ𰸣���"Aabb"�ǲ���ȷ�ġ�ע��'A'��'a'����Ϊ�����ֲ�ͬ���ַ���
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
	
	// ��ʼ��characters, ����'A'-'z'���ַ�������ͳ���ַ�Ƶ��
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
	
	// ����arr��i��jλ�õ�ֵ
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
