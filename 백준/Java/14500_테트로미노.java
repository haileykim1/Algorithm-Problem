import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] arr;
	static boolean[][] visited;
	static int ans = 0;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	
	public static void FindMaxSum(int x, int y, int sum, int cnt) {
		if(cnt == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= M) || (visited[nx][ny])) {
				continue;
			}
			visited[nx][ny] = true;
			FindMaxSum(nx, ny, sum + arr[nx][ny], cnt + 1);
			visited[nx][ny] = false;
		}
		
		
	}
	
	public static void PlusShaped(int x, int y) {
		int cnt = 0;
		int mini = 1000;
		int sum = arr[x][y];
		for(int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= M)) {
				continue;
			}
			++cnt;
			sum += arr[nx][ny];
			mini = Math.min(mini, arr[nx][ny]);
			
		}
		
		if(cnt <= 2) {
			return;
		}else if(cnt == 3) {
			ans = Math.max(ans, sum);
		}else {	//cnt == 4
			ans = Math.max(ans, sum - mini);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		arr = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				arr[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				visited[i][j] = true;
				FindMaxSum(i, j, arr[i][j], 1);
				visited[i][j] = false;
				PlusShaped(i, j);
			}
		}
		
		
		System.out.print(ans + "\n");
		
	}
	
}
