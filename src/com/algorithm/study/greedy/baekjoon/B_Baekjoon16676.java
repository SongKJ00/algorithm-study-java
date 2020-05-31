package com.algorithm.study.greedy.baekjoon;

import java.util.Scanner;

public class B_Baekjoon16676 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String N = sc.next();
		if(N.length() == 1) {
			System.out.println(1);
			return;
		}

		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < N.length(); i++) {
			sb.append('1');
		}

		int result = 0;
		if (Integer.parseInt(N) >= Integer.parseInt(sb.toString())) {
			result = N.length();
		} else {
			result = N.length() - 1;
		}

		System.out.println(result);
	}
}
