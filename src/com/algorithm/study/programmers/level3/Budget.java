package com.algorithm.study.programmers.level3;


public class Budget {
  public int solution(int[] budgets, int M) {
    int answer = 0;

    int left = 0;
    int right = 0;
    for(int budget: budgets) {
      left = Math.min(left, budget);
      right = Math.max(right, budget);
    }

    int middle = 0;
    while(left <= right) {
      long sum = 0;
      middle = (left + right) / 2;
      for(int budget: budgets) {
        if(budget >= middle) {
          sum += middle;
        } else {
          sum += budget;
        }
      }

      if(sum > M) {
        right = middle - 1;
      } else {
        answer = middle;
        left = middle + 1;
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new Budget().solution(new int[]{120, 110, 140, 150}, 485));
  }
}
