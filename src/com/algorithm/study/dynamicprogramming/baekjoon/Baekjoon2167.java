package com.algorithm.study.dynamicprogramming.baekjoon;

import java.util.Scanner;

public class Baekjoon2167 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();

		int arr[][] = new int[N+1][M+1];
		int dp[][] = new int[N+1][M+1];

		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				arr[i][j] = scanner.nextInt();
			}
		}

		for(int i = 1; i < N+1; i++) {
			for(int j = 1; j < M+1; j++) {
				dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + arr[i][j];
			}
		}

		int K = scanner.nextInt();
		for(int t = 0; t < K; t++) {
			int i = scanner.nextInt();
			int j = scanner.nextInt();
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			int result = dp[x][y] - dp[i-1][y] - dp[x][j-1] + dp[i-1][j-1];

			System.out.println(result);
		}

		scanner.close();
	}
}
