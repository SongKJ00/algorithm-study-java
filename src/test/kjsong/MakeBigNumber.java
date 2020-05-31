package test.kjsong;

import java.util.*;

public class MakeBigNumber {

/*    public String solution(String number, int k) {
        int idx = 0;
        char max;
        StringBuilder answer = new StringBuilder();

        if(number.charAt(0) == '0') return "0";
        for(int i = 0; i < number.length() - k; i++) {
            max = '0';
            for(int j = idx; j <= k + i; j++) {
                if(max < number.charAt(j)) {
                    max = number.charAt(j); idx = j + 1;
                }
            }
            answer.append(max);
        }
        return answer.toString();
    }*/
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < number.length() - k; i++) {
            char maxCh = '0';
            for (int j = idx; j <= k + i; j++) {
                if (maxCh < number.charAt(j)) {
                    maxCh = number.charAt(j);
                    idx = j + 1;
                }
            }
            answer.append(maxCh);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
	// write your code here
        System.out.println(new MakeBigNumber().solution("4177252841", 4));
    }
}
