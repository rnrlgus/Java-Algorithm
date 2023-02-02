package baekjoon.ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2290 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        char[] nums = input[1].toCharArray();

        for (int j = 0; j < 2 * s + 3; ++j) {
            for (int i = 0; i < nums.length; ++i) {
                if (j == 0) {
                    for (int k = 0; k < s + 2; ++k) {
                        if (nums[i] != '1' && nums[i] != '4') {
                            if (k == 0 || k == s + 1) {
                                sb.append(" ");
                            } else{
                                sb.append("-");
                            }

                        } else {
                            sb.append(" ");
                        }
                    }
                    sb.append(" ");
                }

                if (j >= 1 && j <= s) {
                    for (int k = 0; k < s + 2; ++k) {
                        if (nums[i] == '1' || nums[i] == '2' || nums[i] == '3' || nums[i] == '7') {
                            if (k < s + 1) {
                                sb.append(" ");
                            } else {
                                sb.append("|");
                            }
                        } else if (nums[i] == '5' || nums[i] == '6') {
                            if (k == 0) {
                                sb.append("|");
                            } else {
                                sb.append(" ");
                            }
                        } else { // 4 8 9 0
                            if (k == 0 || k == s + 1) {
                                sb.append("|");
                            } else {
                                sb.append(" ");
                            }
                        }
                    }
                    sb.append(" ");
                }

                if (j == s + 1) {
                    for (int k = 0; k <  s +2; ++k) {
                        if (nums[i] == '1' || nums[i] == '7' || nums[i] == '0') {
                            sb.append(" ");
                        } else {
                            if (k == 0 || k == s + 1) {
                                sb.append(" ");
                            } else {
                                sb.append("-");
                            }

                        }
                    }
                    sb.append(" ");
                }

                if (j >s+1 && j <2*s + 2) {
                    for (int k = 0; k < s + 2; ++k) {
                        if (nums[i] == '1' || nums[i] == '3' || nums[i] == '4' || nums[i] == '5' || nums[i] == '7' || nums[i] == '9') {
                            if (k < s + 1) {
                                sb.append(" ");
                            } else{
                                sb.append("|");
                            }
                        } else if (nums[i] == '2') {
                            if (k == 0) {
                                sb.append("|");
                            } else {
                                sb.append(" ");
                            }
                        } else {
                            if (k == 0 || k == s + 1) {
                                sb.append("|");
                            } else {
                                sb.append(" ");
                            }
                        }
                    }
                    sb.append(" ");
                }

                if (j == 2*s + 2) {
                    for (int k = 0; k < s + 2; ++k) {
                        if (nums[i] != '1' && nums[i] != '4' && nums[i] != '7') {
                            if (k == 0 || k == s + 1) {
                                sb.append(" ");
                            } else {
                                sb.append("-");
                            }

                        } else {
                            sb.append(" ");
                        }
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}