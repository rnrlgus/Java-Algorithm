package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B5587 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] cards = new int[2 * n + 1];

        ArrayList<Integer> sg = new ArrayList<>();
        ArrayList<Integer> gs = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            sg.add(Integer.parseInt(br.readLine()));
            cards[sg.get(i)] = 1;
        }
        for (int i = 1; i < cards.length; ++i) {
            if (cards[i] == 0) gs.add(i);
        }
        Collections.sort(sg);
        Collections.sort(gs);


        boolean turn = true; // true : sg, false : gs
        int current = 0;

        while (true) {
            if (sg.size() == 0 || gs.size() == 0) break;

            if (turn == true) {
                if (current == 0) {
                    current = sg.remove(0);
                } else  {
                    int tmp = current;
                    for (int i = 0; i < sg.size(); ++i) {
                        if (sg.get(i) > current) {
                            current = sg.remove(i);
                            break;
                        }
                    }
                    if (current == tmp) {
                        current = 0;
                    }
                }
                turn = false;
            } else {
                if (current == 0) {
                    current = gs.remove(0);
                } else  {
                    int tmp = current;
                    for (int i = 0; i < gs.size(); ++i) {
                        if (gs.get(i) > current) {
                            current = gs.remove(i);
                            break;
                        }
                    }
                    if (current == tmp) {
                        current = 0;
                    }
                }
                turn = true;
            }
        }

        System.out.println(gs.size());
        System.out.println(sg.size());

    }
}