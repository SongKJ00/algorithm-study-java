package com.algorithm.study.programmers.level3;

/*
 * 디스크 컨트롤러 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 */

import java.util.*;

public class DiskController {
  public int solution(int[][] jobs) {
    int answer = 0;

    Arrays.sort(jobs, ((o1, o2) -> o1[0] - o2[0]));
    Queue<ArrayList<Integer>> jobList = new ArrayDeque<>();
    for(int i = 0; i < jobs.length; i++) {
      ArrayList<Integer> arrList = new ArrayList<>();
      arrList.add(jobs[i][0]);
      arrList.add(jobs[i][1]);
      jobList.add(arrList);
    }

    PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>(((o1, o2) -> o1.get(1) - o2.get(1)));
    int time = 0;
    while(!jobList.isEmpty() || !pq.isEmpty()) {
      while(true) {
        if(jobList.isEmpty()) { break; }
        if(jobList.peek().get(0) <= time) {
          ArrayList<Integer> arrayList = jobList.poll();
          pq.add(arrayList);
        } else {
          break;
        }
      }

      if(!pq.isEmpty()) {
        ArrayList<Integer> arrayList = pq.poll();
        time += arrayList.get(1);
        answer += (time - arrayList.get(0));
      } else {
        time = jobList.peek().get(0);
      }
    }

    return answer / jobs.length;
  }

  public static void main(String[] args) {
    int arr[][] = new int[3][2];
    arr[0] = new int[]{0, 3};
    arr[1] = new int[]{1, 9};
    arr[2] = new int[]{2, 6};

    System.out.println(new DiskController().solution(arr));
  }
}
