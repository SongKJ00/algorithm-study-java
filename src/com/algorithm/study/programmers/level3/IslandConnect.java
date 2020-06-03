package com.algorithm.study.programmers.level3;

/*
 * 섬 연결하기
 * https://programmers.co.kr/learn/courses/30/lessons/42861
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class IslandConnect {
  int[] parent;
  int[] rank;

  boolean union(int x, int y) {
    x = find(x);
    y = find(y);

    if(x==y) { return false; }

    if(rank[x] < rank[y]) {
      parent[x] = y;
    } else {
      parent[y] = x;
      if(rank[x] == rank[y]) {
        rank[x]++;
      }
    }
    return true;
  }

  int find(int x) {
    if(parent[x] == x) {
      return x;
    }

    return parent[x] = find(parent[x]);
  }

  public int solution(int n, int[][] costs) {
    int answer = 0;
    int connectedBridgesCnt = 0;
    parent = new int[n+1];
    rank = new int[n+1];

    PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

    for(int i = 0; i <= n; i++) {
      parent[i] = i;
      rank[i] = 0;
    }

    for(int i = 0; i < costs.length; i++) {
      pq.add(costs[i]);
    }

    while(!pq.isEmpty()) {
      int[] curr = pq.poll();
      int first = curr[0], second = curr[1], cost = curr[2];
      if(union(first, second)) {
        answer += cost;
        connectedBridgesCnt++;
        if(connectedBridgesCnt == n-1) { break; }
      }
    }

    return answer;
  }

  public static void main(String[] args) {
    int[][] arr = new int[5][];
    arr[0] = new int[]{0,1,1};
    arr[1] = new int[]{0,2,2};
    arr[2] = new int[]{1,2,5};
    arr[3] = new int[]{1,3,1};
    arr[4] = new int[]{2,3,8};

    System.out.println(new IslandConnect().solution(4, arr));
  }
}
