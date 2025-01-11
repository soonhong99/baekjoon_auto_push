
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;


public class Main {
    static int N, M;
    static int[][] board;
    static int max = 0;
    // 테트로미노의 모든 모양을 정의
    static int[][][] tetromino = {
            {{0,0}, {0,1}, {0,2}, {0,3}},  // I 모양
            {{0,0}, {1,0}, {2,0}, {3,0}},
            {{0,0}, {0,1}, {1,0}, {1,1}},  // O 모양
            {{0,0}, {1,0}, {2,0}, {2,1}},  // L 모양
            {{0,0}, {0,1}, {0,2}, {1,0}},
            {{0,0}, {0,1}, {1,1}, {2,1}},
            {{1,0}, {1,1}, {1,2}, {0,2}},
            {{0,1}, {1,1}, {2,1}, {2,0}},
            {{0,0}, {1,0}, {1,1}, {1,2}},
            {{0,0}, {0,1}, {1,0}, {2,0}},
            {{0,0}, {0,1}, {0,2}, {1,2}},
            {{0,0}, {1,0}, {1,1}, {2,1}},  // Z 모양
            {{1,0}, {1,1}, {0,1}, {0,2}},
            {{0,1}, {1,1}, {1,0}, {2,0}},
            {{0,0}, {0,1}, {1,1}, {1,2}},
            {{0,1}, {1,0}, {1,1}, {1,2}},  // T 모양
            {{0,0}, {1,0}, {1,1}, {2,0}},
            {{0,0}, {0,1}, {0,2}, {1,1}},
            {{0,1}, {1,0}, {1,1}, {2,1}}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        // 보드 입력 받기
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 위치에서 테트로미노 놓아보기
        findMaxSum();

        System.out.println(max);
    }

    // 모든 가능한 테트로미노 배치를 시도
    static void findMaxSum() {
        // 보드의 모든 위치를 시작점으로 시도
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                // 각 위치에서 모든 테트로미노 모양을 시도
                for(int k = 0; k < tetromino.length; k++) {
                    int sum = 0;
                    boolean isPossible = true;

                    // 현재 테트로미노의 4개 블록에 대해
                    for(int l = 0; l < 4; l++) {
                        int nx = i + tetromino[k][l][0];
                        int ny = j + tetromino[k][l][1];

                        // 보드 범위를 벗어나면 불가능
                        if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                            isPossible = false;
                            break;
                        }
                        sum += board[nx][ny];
                    }

                    // 가능한 배치였다면 최대값 갱신
                    if(isPossible) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }
    }
}
