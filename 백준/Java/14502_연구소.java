import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, M, ans = 0;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[][] lab;
	static boolean[][] visited;
	
	public static void PickWall(int cnt, int x, int y) {;
		if(cnt == 3) {
			for(int i = 0; i < N; ++i) {
				Arrays.fill(visited[i], false);
			}
			ans = Math.max(ans, FindSafeZone());
			return;
		}
		
		for(int i = x; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if((i == x) && (j <= y)) {
					continue;
				}
				if(lab[i][j] == 0) {
					lab[i][j] = 1;
					PickWall(cnt + 1, i, j);
					lab[i][j] = 0;	
				}
			}
		}
		
		
	}
	
	public static int FindSafeZone() {
		int ret = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M ; ++j) {
				if(!visited[i][j] && lab[i][j] == 0) {
					int cluster = DFS(i, j);
					if(cluster != -1) {
						ret += cluster;
					}
				}
			}
		}
		
		return ret;
	}
	
	public static int DFS(int x, int y) {
		visited[x][y] = true;
		int ret = 1;
		boolean virus = false;
		for(int i = 0; i < 4; ++i) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if((nx < 0) || (nx >= N) || (ny < 0) || (ny >= M) || (visited[nx][ny]) || (lab[nx][ny] == 1)) {
				continue;
			}
			if(lab[nx][ny] == 2) {
				virus = true;
			}else {
				int part = DFS(nx, ny);
				if(part == -1) {
					virus = true;
				}else {
					ret += part;
				}
			}
		}
		if(virus) {
			return -1;
		}
		return ret;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		lab = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				lab[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		PickWall(0, 0, -1);
		
		System.out.print(ans + "\n");
		
	}
	
}
