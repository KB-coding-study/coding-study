package com.simulation;

import java.util.Scanner;

public class BOJ_14891 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 톱니바퀴 상태 입력
        int[][] gears = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String line = sc.next();
            for (int j = 0; j < 8; j++) {
                gears[i][j] = line.charAt(j) - '0';
            }
        }

        // 회전 횟수 입력
        int K = sc.nextInt();
        int[][] rotations = new int[K][2];
        for (int i = 0; i < K; i++) {
            rotations[i][0] = sc.nextInt() - 1;
            rotations[i][1] = sc.nextInt();
        }

        // 회전 처리
        for (int[] rotation : rotations) {
            int gearIndex = rotation[0];
            int direction = rotation[1];

            // 각 톱니바퀴가 회전하는 방향을 저장하는 배열
            int[] rotateDirections = new int[4];
            rotateDirections[gearIndex] = direction;

            // 왼쪽 톱니바퀴들 확인
            for (int i = gearIndex; i > 0; i--) {
                if (gears[i][6] != gears[i - 1][2]) {
                    rotateDirections[i - 1] = -rotateDirections[i];
                } else {
                    break;
                }
            }

            // 오른쪽 톱니바퀴들 확인
            for (int i = gearIndex; i < 3; i++) {
                if (gears[i][2] != gears[i + 1][6]) {
                    rotateDirections[i + 1] = -rotateDirections[i];
                } else {
                    break;
                }
            }

            // 각 톱니바퀴 회전
            for (int i = 0; i < 4; i++) {
                if (rotateDirections[i] != 0) {
                    rotate(gears[i], rotateDirections[i]);
                }
            }
        }

        // 점수 계산
        int score = 0;
        if (gears[0][0] == 1) score += 1;
        if (gears[1][0] == 1) score += 2;
        if (gears[2][0] == 1) score += 4;
        if (gears[3][0] == 1) score += 8;

        // 점수 출력
        System.out.println(score);

        sc.close();
    }

    // 톱니바퀴 회전 함수
    private static void rotate(int[] gear, int direction) {
        if (direction == 1) { // 시계 방향 회전
            int temp = gear[7];
            for (int i = 7; i > 0; i--) {
                gear[i] = gear[i - 1];
            }
            gear[0] = temp;
        } else if (direction == -1) { // 반시계 방향 회전
            int temp = gear[0];
            for (int i = 0; i < 7; i++) {
                gear[i] = gear[i + 1];
            }
            gear[7] = temp;
        }
    }
}
