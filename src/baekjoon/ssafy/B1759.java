package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class B1759 {

    /**
     * 암호 조건 : 최소 1개의 모음, 두개의 자음으로 구성되어 있음, 오름차순 정렬
     *
     */

    static int C;
    static int consonant, vowel; // 자음 / 모음
    static char[] alphabetArr;
    static boolean[] selected;
    static HashSet<Character> set;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken()); // 암호 알파벳 종류(암호 길이)
        C = Integer.parseInt(st.nextToken()); // 암호 후보 알파벳 개수
        alphabetArr = new char[C];
        selected = new boolean[C];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; ++i) {
            alphabetArr[i] = st.nextToken().charAt(0);
        } // 입력 완료
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');

        Arrays.sort(alphabetArr);
        combination(0, L);

        System.out.println(sb);
    }

    static void combination(int start, int cnt) {
        if(cnt == 0) { // L개짜리 암호 조합 만들어졌을 때
            consonant = 0;
            vowel = 0;
            for (int i = 0; i < C; ++i) {
                if (selected[i] == true) {
                    if (set.contains(alphabetArr[i]))vowel++;
                    else consonant++;
                }
            }

            if(vowel >=1 && consonant >= 2) { // 문제 조건 만족하는 경우
                for (int i = 0; i < C; ++i) {
                    if (selected[i] == true) sb.append(alphabetArr[i]);
                }
                sb.append("\n");
            }

            return ;
        }

        for (int i = start; i < C; ++i) {
            selected[i] = true;
            combination(i+1, cnt-1);
            selected[i] = false;
        }

    }

}