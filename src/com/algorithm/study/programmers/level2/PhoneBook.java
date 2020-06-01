package com.algorithm.study.programmers.level2;

/*
 * 전화번호 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42577?language=java
 */

public class PhoneBook {
  public boolean solution(String[] phone_book) {
    boolean answer = true;

    for(int i = 0; i < phone_book.length; i++) {
      for(int j = 0; j < phone_book.length; j++) {
        if(i == j) {
          continue;
        } else {
          if(phone_book[i].startsWith(phone_book[j])) {
            return false;
          }
        }
      }
    }
    return answer;
  }

  public static void main(String[] args) {
    System.out.println(new PhoneBook().solution(new String[]{"119", "97674223", "1195524421"}));
  }
}
