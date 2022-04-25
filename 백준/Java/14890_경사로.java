import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int N, L, ans = 0;
	static int[][] road;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(tok.nextToken());
		L = Integer.parseInt(tok.nextToken());
		road = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				road[i][j] = Integer.parseInt(tok.nextToken());
			}
		}
		
		for(int i = 0; i < N; ++i) {
			boolean ok = true;
			boolean[] bridge = new boolean[N];
			for(int j = 1; j < N; ++j) {
				if(road[i][j] == road[i][j - 1]) {
					continue;
				}else if((Math.abs(road[i][j] - road[i][j - 1]) >= 2)) {
					ok = false;
					break;
				}else {//높이 차 1
					if(road[i][j] > road[i][j - 1]) {
						int cnt = 0;
						int h = road[i][j - 1];
						int idx = j - 1;
						while((cnt < L) && (idx >= 0)) {
							if((road[i][idx] == h) && (!bridge[idx])) {
								++cnt;
								bridge[idx] = true;
							}else {
								break;
							}
							--idx;
						}
						if(cnt < L) {
							ok = false;
							break;
						}
					}else {
						int cnt = 0;
						int h = road[i][j];
						int idx = j;
						while((cnt < L) && (idx < N)) {
							if((road[i][idx] == h) && !bridge[idx]) {
								++cnt;
								bridge[idx] = true;
							}else {
								break;
							}
							++idx;
						}
						if(cnt < L) {
							ok = false;
							break;
						}else {
							j += L - 1;
						}
					}
				}
			}
			if(ok) {
				++ans;
			}
		}
		for(int j = 0; j < N; ++j) {
			boolean ok = true;
			boolean[] bridge = new boolean[N];
			for(int i = 1; i < N; ++i) {
				if(road[i][j] == road[i - 1][j]) {
					continue;
				}else if((Math.abs(road[i][j] - road[i - 1][j]) >= 2)) {
					ok = false;
					break;
				}else {//높이 차 1
					if(road[i][j] > road[i - 1][j]) {
						int cnt = 0;
						int h = road[i - 1][j];
						int idx = i - 1;
						
						while((cnt < L) && (idx >= 0)) {
							if((road[idx][j] == h) && (!bridge[idx])) {
								++cnt;
								bridge[idx] = true;
							}else {
								break;
							}
							--idx;
						}
						if(cnt < L) {
							ok = false;
							break;
						}
					}else {
						int cnt = 0;
						int h = road[i][j];
						int idx = i;
						while((cnt < L) && (idx < N)) {
							if((road[idx][j] == h) && !bridge[idx]) {
								++cnt;
								bridge[idx] = true;
							}else {
								break;
							}
							++idx;
						}
						if(cnt < L) {
							ok = false;
							break;
						}else {
							i += L - 1;
						}
					}
				}
			}

			if(ok) {
				++ans;
			}
		}
		System.out.print(ans + "\n");
		
	}
	
}
