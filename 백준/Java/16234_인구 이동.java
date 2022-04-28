import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static int N, L, R, sum = 0, cnt = 0, ans = 0;
	static int[][] A;
	static int[] dx = {-1, 0, 0, 1};
	static int[] dy = {0, -1, 1, 0};
	static boolean[][][] unite;
	static boolean[][] visited;
	static ArrayList<Pos> arr = new ArrayList<Pos>();

	public static class Pos{
		int x;
		int y;
		
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static boolean needMoves() {
		boolean ret = false;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				for(int k = 2; k < 4; ++k) {
					int nx = i + dx[k];
					int ny = j + dy[k];
					if((nx >= N) || (ny >= N)) {
						continue;
					}
					int diff = Math.abs(A[i][j] - A[nx][ny]);
					if((diff >= L) && (diff <= R)) {
						ret = true;
						unite[i][j][k] = true;
						unite[nx][ny][3 - k] = true;
						unite[i][j][4] = true;
						unite[nx][ny][4] = true;
					}
				}
			}
		}
		return ret;
	}
	
	public static void Open(int a, int b) {
		visited[a][b] = true;
		sum += A[a][b];
		++cnt;
		arr.add(new Pos(a, b));
		for(int i = 0; i < 4; ++i) {
			if(unite[a][b][i]) {
				int nx = a + dx[i];
				int ny = b + dy[i];
				if(!visited[nx][ny]) {
					Open(nx, ny);
				}
			}
		}
	}
	

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		L = Integer.parseInt(tok.nextToken());
		R = Integer.parseInt(tok.nextToken());
		
		A = new int[N][N];
		unite = new boolean[N][N][5];
		visited = new boolean[N][N];
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				A[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		while(true) {
			for(int i = 0; i < N; ++i) {
				Arrays.fill(visited[i], false);
				for(int j = 0; j < N; ++j) {
					Arrays.fill(unite[i][j], false);
				}
			}
			if(!needMoves()) {
				break;
			}
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(!visited[i][j] && unite[i][j][4]) {
						sum = 0;
						cnt = 0;
						arr.clear();
						Open(i, j);
						int population = sum / cnt;
						for(int k = 0; k < arr.size(); ++k) {
							A[arr.get(k).x][arr.get(k).y] = population;
						}
					}
				}
			}
			++ans;
			
		}
		
		System.out.print(ans + "\n");
	}
	
}
