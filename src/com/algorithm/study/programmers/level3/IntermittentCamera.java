package com.algorithm.study.programmers.level3;

/*
 * 단속 카메라 문제
 * https://programmers.co.kr/learn/courses/30/lessons/42884
 */

import java.util.ArrayList;
import java.util.Collections;

public class IntermittentCamera {
  public int solution(int[][] routes) {
    int answer = 1;
    ArrayList<Route> routeList = new ArrayList<Route>();
    for(int i = 0; i < routes.length; i++) {
      routeList.add(new Route(routes[i][0], routes[i][1]));
    }

    Collections.sort(routeList);

    Route temp = routeList.get(0);
    for(int i = 1; i < routeList.size(); i++) {
      Route curr = routeList.get(i);
      if(curr.exit < temp.exit) {
        temp = curr;
      } else if(curr.enter > temp.exit) {
        answer++;
        temp = curr;
      }
    }

    return answer;
  }
  public class Route implements Comparable<Route> {
    int enter;
    int exit;

    public Route(int enter, int exit) {
      this.enter = enter;
      this.exit = exit;
    }

    @Override
    public int compareTo(Route o) {
      if(this.enter > o.enter) { return 1; }
      else if(this.enter == o.enter) { return 0; }
      else { return -1; }
    }
  }

  public static void main(String[] args) {
    int arr[][] = new int[4][];
    arr[0] = new int[]{-20, 15};
    arr[1] = new int[]{-14, -5};
    arr[2] = new int[]{-18, -13};
    arr[3] = new int[]{-5, -3};

    System.out.println(new IntermittentCamera().solution(arr));
  }
}
