package com.algorithm.study.greedy.baekjoon;


import java.util.Scanner;

public class A_Baekjoon1439 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String S = sc.next();
		int changeCnt = 0;
		for(int i = 1; i < S.length(); i++) {
			if(S.charAt(i) != S.charAt(i-1)) {
				changeCnt++;
			}
		}

		int result = (changeCnt+1)/2;
		System.out.println(result);
	}
}
