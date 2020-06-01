package com.algorithm.study.programmers.level2;

/*
 * HIndex 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */

public class HIndex {
  public int solution(int[] citations) {
    int answer = 0;
    for(int i = 1; i <= citations.length; i++) {
      int tempCnt = 0;
      for(int j = 0; j < citations.length; j++) {
        if(citations[j] >= i) {
          tempCnt++;
        }
      }

      if(tempCnt >= i) {
        answer = i;
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new HIndex().solution(new int[]{3, 0, 6, 1, 5}));
  }
}
