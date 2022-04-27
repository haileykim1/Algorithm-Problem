import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	static int N, M, H, mini = 4;
	static boolean[][] line;
	
	public static boolean iToI() {
		boolean ret = true;
		for(int i = 1; i <= N; ++i) {
			int a = 1, b = i;
			for(a = 1; a <= H; ++a) {
				if(line[a][b]) {
					++b;
				}else if(line[a][b - 1]) {
					--b;
				}
			}
			if(b != i) {
				return false;
			}
		}
		return true;
	}
	
	public static void Pick(int done, int x, int y) {
		
		if(done >= mini) {
			return;
		}
		if(iToI()) {
			mini = done;
			return;
		}
		
		if(done == 3) {
			return;
		}
		
		for(int i = x; i <= H; ++i) {
			for(int j = 1; j < N; ++j) {
				if((i == x) && (j <= y)) {
					continue;
				}
				if(line[i][j]) {//이미 있는 경우.
					continue;
				}
				//전후조사
				if((j > 1) && (line[i][j - 1])) {
					continue;
				}
				if((j < N - 1) && (line[i][j + 1])) {
					continue;
				}
				//i, j 선택
				line[i][j] = true;
				Pick(done + 1, i, j + 1);
				line[i][j] = false;
			}
		}
		
		
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok = new StringTokenizer(br.readLine());
		N = Integer.parseInt(tok.nextToken());
		M = Integer.parseInt(tok.nextToken());
		H = Integer.parseInt(tok.nextToken());
		
		line = new boolean[H + 1][N + 1];
		
		for(int i = 0; i < M; ++i) {
			tok = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(tok.nextToken());
			int b = Integer.parseInt(tok.nextToken());
			line[a][b] = true;
		}
		
		Pick(0, 1, 0);
		
		if(mini > 3) {
			System.out.print("-1\n");
		}else {
			System.out.print(mini + "\n");
		}
		
	}
}
