package com.algorithm.study.programmers.level2;

/*
 * 더 맵게 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */
import java.util.Comparator;
import java.util.PriorityQueue;

public class MoreSpicy {
  public int solution(int[] scoville, int K) {
    int result = 0;
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(((o1, o2) -> o1.compareTo(o2)));
    for(int sc: scoville) {
      pq.offer(sc);
    }

    boolean findFlag = false;

    while(!pq.isEmpty()) {
      if(pq.peek() >= K) {
        findFlag = true;
        break;
      }
      int first = pq.poll();
      if(pq.isEmpty()) {
        return -1;
      }
      int second = pq.poll();
      int newElem = first + (second * 2);
      pq.offer(newElem);
      result++;
    }

    if(findFlag) {
      return result;
    } else {
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(new MoreSpicy().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
  }
}
