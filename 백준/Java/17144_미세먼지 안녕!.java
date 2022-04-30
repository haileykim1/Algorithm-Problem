import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int R, C, T, ans = 0;
	static int[][] A;
	static int[] purifyLine = new int[2];
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static int[][] dir = {{0, 2, 3, 1}, {3, 2, 0, 1}};
	
	public static void Diffuse() {
		int[][] newA = new int[R + 1][C + 1];
		
		newA[purifyLine[0]][1] = -1;
		newA[purifyLine[1]][1] = -1;
		
		for(int i = 1; i <= R; ++i) {
			for(int j = 1; j <= C; ++j) {
				if(A[i][j] > 0) {
					int diffAmount = A[i][j] / 5;
					int cnt = 0;
					for(int k = 0; k < 4; ++k) {
						int nx = i + dx[k];
						int ny = j + dy[k];
						if((nx < 1) || (nx > R) || (ny < 1) || (ny > C) || (A[nx][ny] == -1)) {
							continue;
						}
						++cnt;
						newA[nx][ny] += diffAmount;
					}
					newA[i][j] += A[i][j] - diffAmount * cnt;
				}
			}
		}
		for(int i = 1; i <= R; ++i) {
			for(int j = 1; j <= C; ++j) {
				A[i][j] = newA[i][j];
			}
		}
	}
	
	public static void Purify() {
		for(int i = 0; i < 2; ++i) {
			int direction = 0;
			int x = purifyLine[i] + dx[dir[i][direction]];
			int y = 1 + dy[dir[i][direction]];
			while(A[x][y] != -1) {
				int nx = x + dx[dir[i][direction]];
				int ny = y + dy[dir[i][direction]];
				if((nx < 1) || (nx > R) || (ny < 1) || (ny > C) || ((x == purifyLine[i]) && (ny == C))) {
					++direction;
					continue;
				}
				if(A[nx][ny] != -1) {
					A[x][y] = A[nx][ny];
				}else {
					A[x][y] = 0;
				}
				x = nx;
				y = ny;
				
			}
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(tok.nextToken());
		C = Integer.parseInt(tok.nextToken());
		T = Integer.parseInt(tok.nextToken());
		A = new int[R + 1][C + 1];
		int purifierCnt = 0;
		
		for(int i = 1; i <= R; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 1; j <= C; ++j) {
				A[i][j] = Integer.parseInt(tok.nextToken());
				if(A[i][j] == -1) {
					purifyLine[purifierCnt++] = i;
				}
			}
		}
		
		for(int i = 1; i <= T; ++i) {
			Diffuse();
			Purify();
		}
		
		for(int i = 1; i <= R; ++i) {
			for(int j = 1; j <= C; ++j) {
				if(A[i][j] != -1) {
					ans += A[i][j];
				}
			}
		}
		System.out.print(ans + "\n");
	}
	
}
