package example0807;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Miro {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    static boolean[][] visited;
    static int[][] A; //지도
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());



        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }
        Bfs(0,0);

        System.out.println("=======A 배열=======");
        for (int[] ints : A) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("===================");
        System.out.println("=======check 배열=======");
        for (boolean[] ints : visited) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("===================");
        System.out.println("answer = " + A[N-1][M-1]);
    }
    //1. 0,0 이 들어간다.
    //2. QUEUE에 담는다.
    //3. 다음 상하좌우를 살핀다.
    //4. 1이면 움직일수있다.
    //5. 1이면 가고 체크배열 TRUE, 해당 배열 숫자 +1
    //6. 마지막으로 다시 그 값을 큐에 넣어준다

    private static void Bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {i,j});
        visited[i][j] =true;

        while(!queue.isEmpty()){
            int now[] = queue.poll();
            for (int k = 0; k < 4; k++) {
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x>=0 && y>=0 && x<N && y<M){
                    if(A[x][y]!=0 && ! visited[x][y]){
                        visited[x][y] =true;
                        A[x][y] = A[now[0]][now[1]] + 1;
                        queue.add(new int[] {x,y});
                    }
                }
            }
        }

    }
}
