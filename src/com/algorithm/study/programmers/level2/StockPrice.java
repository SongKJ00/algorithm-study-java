/*
 * 주식 가격 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
package com.algorithm.study.programmers.level2;

public class StockPrice {
  public int[] solution(int[] prices) {
    int[] result = new int[prices.length];

    for(int i = 0; i < prices.length-1; i++) {
      int cnt = 0;
      for(int j = i+1; j < prices.length; j++) {
        cnt++;
        if(prices[j] < prices[i]) {
          break;
        }
      }
      result[i] = cnt;
    }

    return result;
  }

  public static void main(String[] args) {
    new StockPrice().solution(new int[]{1, 2, 3, 2, 3});
  }
}
