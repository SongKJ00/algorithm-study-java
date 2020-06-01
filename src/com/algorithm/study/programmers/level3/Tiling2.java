package com.algorithm.study.programmers.level3;

public class Tiling2 {
  public int solution(int n) {
    int answer = 0;
    if(n == 0) { return 0; }
    if(n == 1) { return 1; }
    if(n == 2) { return 2; }

    int[] dp = new int[n+1];
    dp[1] = 1;
    dp[2] = 2;
    for(int i = 3; i < dp.length; i++) {
      dp[i] = (dp[i-1] + dp[i-2]) % 1000000007;
    }

    answer = dp[n];

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new Tiling2().solution(5));
  }
}
