package com.algorithm.study.greedy.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class C_Baekjoon2437 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int sum = 0;
		Arrays.sort(arr);
		for(int i = 0; i < N; i++) {
			if(arr[i] <= sum + 1) {
				sum += arr[i];
			} else {
				break;
			}
		}

		System.out.println(sum+1);
	}
}
