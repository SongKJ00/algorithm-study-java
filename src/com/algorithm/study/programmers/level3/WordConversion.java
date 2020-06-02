package com.algorithm.study.programmers.level3;

public class WordConversion {
  public int answer = -1;

  public int solution(String begin, String target, String[] words) {
    boolean[] visited = new boolean[words.length];

    dfs(0, begin, target, visited, words);

    if(answer == -1) {
      return 0;
    } else {
      return answer;
    }
  }

  public void dfs(int depth, String word, String target, boolean[] visited, String[] words) {
    for(int i = 0; i < words.length; i++) {
      if(!visited[i] && canChange(word, words[i])) {
        if(words[i].equals(target)) {
          depth++;
          if(depth < answer || answer == -1) {
            answer = depth;
          }
          return;
        }

        visited[i] = true;
        dfs(depth+1, words[i], target, visited, words);
        visited[i] = false;
      }
    }
  }

  public boolean canChange(String s1, String s2) {
    int cnt = 0;
    for(int i = 0; i < s1.length(); i++) {
      if(s1.charAt(i) != s2.charAt(i)) {
        cnt++;
      }
      if(cnt >= 2) {
        return false;
      }
    }

    if(cnt == 1) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println(new WordConversion().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
  }
}
