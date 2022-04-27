import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, M, left = 0, cnt, ans = 64;
	static int[][] office;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	static ArrayList<CCTV> cctvList = new ArrayList<CCTV>();
	
	public static class CCTV{
		int x;
		int y;
		int type;
		
		CCTV(int x, int y, int type){
			this.x = x;
			this.y = y;
			this.type = type;
		}
	}
	
	public static void Observe(int x, int y, int start, int end, int step) {
		int nx, ny;
		for(int j = start; j <= end; j += step) {
			nx = x + dx[j % 4];
			ny = y + dy[j % 4];
			while((nx >= 0) && (nx < N) && (ny >= 0) && (ny < M)) {
				if(office[nx][ny] == 6) {
					break;
				}
				if(office[nx][ny] == 0) {
					--left;
				}
				office[nx][ny] += 10;
				nx += dx[j % 4];
				ny += dy[j % 4];
			}
			
		}
	}
	
	public static void UnObserve(int x, int y, int start, int end, int step) {
		int nx, ny;
		for(int j = start; j <= end; j += step) {
			nx = x + dx[j % 4];
			ny = y + dy[j % 4];
			while((nx >= 0) && (nx < N) && (ny >= 0) && (ny < M)) {
				if(office[nx][ny] == 6) {
					break;
				}
				if(office[nx][ny] == 10) {
					++left;
				}
				office[nx][ny] -= 10;
				nx += dx[j % 4];
				ny += dy[j % 4];
			}
			
		}
	}
	
	public static void FixDirection(int done) {
		
		if(done == cnt) {
			ans = Math.min(ans, left);
			return;
		}
		
		int x = cctvList.get(done).x;
		int y = cctvList.get(done).y;
		int type = cctvList.get(done).type;
		
		if(type == 1) {
			for(int i = 0; i < 4; ++i) {
				//备泅 : i 规氢
				Observe(x, y, i, i, 1);
				FixDirection(done + 1);
				UnObserve(x, y, i, i, 1);
			}
			
		}else if(type == 2) {
			for(int i = 0; i < 2; ++i) {
				//备泅 : i, i + 2 规氢
				Observe(x, y, i, i + 2, 2);
				FixDirection(done + 1);
				UnObserve(x, y, i, i + 2, 2);
			}
		}else if(type == 3) {
			for(int i = 0; i < 4; ++i) {
				//备泅 : i, (i + 1) % 4 规氢
				Observe(x, y, i, i + 1, 1);
				FixDirection(done + 1);
				UnObserve(x, y, i, i + 1, 1);
			}
			
		}else if(type == 4) {
			for(int i = 0; i < 4; ++i) {
				//备泅 : i, (i + 1) % 4, (i + 2) % 4 规氢
				Observe(x, y, i, i + 2, 1);
				FixDirection(done + 1);
				UnObserve(x, y, i, i + 2, 1);
				
			}
		}else {
			//备泅 :  葛电规氢
			Observe(x, y, 0, 3, 1);
			FixDirection(done + 1);
			UnObserve(x, y, 0, 3, 1);
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		office = new int[N][M];
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				office[i][j] = Integer.parseInt(tok.nextToken());
				if(office[i][j] == 0) {
					++left;
				}else if(office[i][j] != 6){
					cctvList.add(new CCTV(i, j, office[i][j]));
					++cnt;
				}
				
			}
		}
		FixDirection(0);
		
		System.out.print(ans + "\n");
		
	}
	
	
	
}
