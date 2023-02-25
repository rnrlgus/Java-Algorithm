package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21758 {

    /**
     * 벌 두마리는 꿀통으로 가면서 꿀을 빤다(벌통 포함).(각 벌이 출발한 장소는 못빨아)
     * max 꿀 추출
     *
     * 벌 벌 꿀통 -> 꿀통 : 오른쪽 끝 고정 / 한마리는 왼쪽 끝 고정 / 나머지 옮기면서 max
     * 벌 꿀통 벌 -> 벌들 양쪽 끝에 박아놓기 / 꿀통 옮기면서 max
     * 꿀통 벌 벌 -> 꿀통 : 왼쪽 끝 고정 / 한마리는 오른쪽 끝 고정 / 나머지 옮기면서 max
     *
     * 그냥 반복문 -> n^2 -> time out (n : 10만, 시간 : 1초)
     * 누적합 써야겠다 -> n
     *
     * 벌, 꿀통 배치 :
     *  완탐 : n^3 절대 불가능 백트래킹 해도 절대 안될각
     *  규칙을 찾아야해 -> n
     *
     *
     *
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1]; // 그냥 배열
        int[] sumArr = new int[N+1]; // 누적합 배열
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
            sumArr[i] = sumArr[i-1] + arr[i];
        }

        int answer = Integer.MIN_VALUE;
        // 0 9 9 4 1 4 9 9
        // 0 9 18 22 23 27 36 45

        // 0 2 5 4
        // 0 2 7 11

        // 벌 벌 꿀통
        for (int i = 2; i < N; ++i) {
            int tmp = (sumArr[N] - arr[1]) + (sumArr[N] - sumArr[i]) - arr[i];
            answer = Math.max(tmp, answer);
        }

        // 꿀통 벌 벌
        for (int i = 2; i < N; ++i) {
            int tmp = (sumArr[N] - arr[N]) + sumArr[i-1] - arr[i];
            answer = Math.max(tmp, answer);
        }

        // 벌 꿀통 벌
        for (int i = 2; i < N; ++i) {
            int tmp = (sumArr[i] - arr[1]) + (sumArr[N-1] - sumArr[i-1]);
            answer = Math.max(tmp, answer);
        }

        System.out.println(answer);
    }
}