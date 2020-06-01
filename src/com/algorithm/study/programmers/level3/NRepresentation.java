package com.algorithm.study.programmers.level3;

/*
 * N으로 표현 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42895
 */

public class NRepresentation {
  int answer = -1;

  public int solution(int N, int number) {
    dfs(0, N, 0, number);
    return answer;
  }

  public void dfs(int depth, int N, int currNum, int targetNum) {
    if(depth > 8) {
      return;
    }
    if(currNum == targetNum) {
      if(depth < answer || answer == -1) {
        answer = depth;
      }
      return;
    }

    int nn = 0;
    for(int i = 1; i <= 8; i++) {
      nn = nn*10 + N;
      dfs(depth+i, N, currNum+nn, targetNum);
      dfs(depth+i, N, currNum-nn, targetNum);
      dfs(depth+i, N, currNum*nn, targetNum);
      dfs(depth+i, N, currNum/nn, targetNum);
    }
  }

  public static void main(String[] args) {
    System.out.println(new NRepresentation().solution(5, 12));
  }
}
