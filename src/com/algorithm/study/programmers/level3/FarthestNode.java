package com.algorithm.study.programmers.level3;

/*
 * 가장 먼 노드 문제
 * https://programmers.co.kr/learn/courses/30/lessons/49189https://programmers.co.kr/learn/courses/30/lessons/49189
 */

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class FarthestNode {
  public int solution(int n, int[][] edge) {
    int maxDepth = 0;
    ArrayList<Integer>[] adj = new ArrayList[n+1];
    boolean[] visited = new boolean[n+1];

    for(int i = 0; i < adj.length; i++) {
      adj[i] = new ArrayList<>();
    }

    for(int i = 0; i < edge.length; i++) {
      int first = edge[i][0];
      int second = edge[i][1];
      adj[first].add(second);
      adj[second].add(first);
    }

    Queue<Node> q = new ArrayDeque<>();
    q.add(new Node(1, 0));

    int answer = 0;
    while(!q.isEmpty()) {
      Node currNode = q.poll();
      int value = currNode.value;
      int depth = currNode.depth;
      visited[value] = true;
      if(depth > maxDepth) {
        maxDepth = depth;
        answer = 1;
      } else if(depth == maxDepth) {
        answer++;
      }

      for(int i = 0; i < adj[value].size(); i++) {
        int nextNodeIdx = adj[value].get(i);
        if(!visited[nextNodeIdx]) {
          q.offer(new Node(nextNodeIdx, depth+1));
          visited[nextNodeIdx] = true;
        }
      }
    }

    return answer;
  }

  class Node {
    public int value;
    public int depth;
    public Node(int value, int depth) {
      this.value = value;
      this.depth = depth;
    }
  }


  public static void main(String[] args) {
    int arr[][] = new int[7][];
    arr[0] = new int[]{3, 6};
    arr[1] = new int[]{4, 3};
    arr[2] = new int[]{3, 2};
    arr[3] = new int[]{1, 3};
    arr[4] = new int[]{1, 2};
    arr[5] = new int[]{2, 4};
    arr[6] = new int[]{5, 2};

    System.out.println(new FarthestNode().solution(6, arr));

  }
}
