import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, ans = 0;
	static int[][] seat; 
	static boolean[][] liked;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[] satisfy = {0, 1, 10, 100, 1000};
	
	public static void Pick(int now) {
		int likeMaxi = -1;
		int emptyMaxi = -1;
		int r = 1, c = 1;
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				if(seat[i][j] == 0) {
					int nowLike = 0, nowEmpty = 0;
					for(int k = 0; k < 4; ++k) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if((nx <= 0) || (nx > N) || (ny <= 0) || (ny > N)) {
							continue;
						}
						if(seat[nx][ny] == 0) {
							++nowEmpty;
						}else if(liked[now][seat[nx][ny]]) {
							++nowLike;
						}
					}
					if(nowLike > likeMaxi) {
						likeMaxi = nowLike;
						emptyMaxi = nowEmpty;
						r = i;
						c = j;
					}else if((nowLike == likeMaxi) && (nowEmpty > emptyMaxi)) {
						emptyMaxi = nowEmpty;
						r = i;
						c = j;
					}
				}
			}
		}
		seat[r][c] = now;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		seat = new int[N + 1][N + 1];
		liked = new boolean[N * N + 1][N * N + 1];
		
		for(int i = 1; i <= N * N; ++i) {
			StringTokenizer tok = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(tok.nextToken());
			for(int j = 0; j < 4; ++j) {
				liked[now][Integer.parseInt(tok.nextToken())] = true;
			}
			Pick(now);
		}
		
		for(int i = 1; i <= N; ++i) {
			for(int j = 1; j <= N; ++j) {
				int cnt = 0;
				for(int k = 0; k < 4; ++k) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if((nx <= 0) || (nx > N) || (ny <= 0) || (ny > N)) {
						continue;
					}
					if(liked[seat[i][j]][seat[nx][ny]]) {
						++cnt;
					}
					
				}
				ans += satisfy[cnt];
			}
		}
		System.out.print(ans + "\n");
		
	}
	
}
