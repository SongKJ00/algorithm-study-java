package com.algorithm.study.programmers.level2;

public class Top {
  public int[] solution(int[] heights) {
    int[] result = new int[heights.length];

    for(int i = heights.length-1; i >= 1; i--) {
      for(int j = i-1; j >= 0; j--) {
        if(heights[j] > heights[i]) {
          result[i] = j+1;
          break;
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    new Top().solution(new int[]{6, 9, 5, 7, 4});
  }
}
