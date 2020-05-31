package com.algorithm.study.programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class BiggestNumber {
  public String solution(int[] number) {
    String answer = "";
    String[] numStr = new String[number.length];

    for(int i = 0; i < number.length; i++) {
      numStr[i] = String.valueOf(number[i]);
    }

    Arrays.sort(numStr, new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        return (o2+o1).compareTo(o1+o2);
      }
    });

    if(numStr[0].startsWith("0")) {
      answer += "0";
    } else {
      for(int i = 0; i < numStr.length; i++) {
        answer += numStr[i];
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new BiggestNumber().solution(new int[]{12, 121}));

  }
}
