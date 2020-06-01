package com.algorithm.study.programmers.level3;

/*
 * 정수 삼각형 문제
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */

public class IntegerTriangle {
  public int solution(int[][] triangle) {
    int answer = 0;
    int[][] arr = new int[triangle.length+1][triangle.length+1];
    int[][] dp = new int[triangle.length+1][triangle.length+1];

    for(int i = 1; i < arr.length; i++) {
      for(int j = 1; j < arr.length; j++) {
        if(j <= i) {
          arr[i][j] = triangle[i-1][j-1];
        }
      }
    }

    for(int i = 1; i < dp.length; i++) {
      for(int j = 1; j < dp.length; j++) {
        dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
      }
    }

    for(int j = 1; j < dp.length; j++) {
      answer = Math.max(answer, dp[dp.length-1][j]);
    }

    return answer;
  }
  public static void main(String[] args) {
    int arr[][] = new int[5][];
    arr[0] = new int[]{7};
    arr[1] = new int[]{3, 8};
    arr[2] = new int[]{8, 1, 0};
    arr[3] = new int[]{2, 7, 4, 4};
    arr[4] = new int[]{4, 5, 2, 6, 5};

    System.out.println(new IntegerTriangle().solution(arr));
  }
}
