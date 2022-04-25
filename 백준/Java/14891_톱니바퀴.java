import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.*;

public class Main {
	
	static int[][] gear = new int[5][8];
	static int K;
	static boolean[] visited = new boolean[5];
	
	public static void Roll(int x, int clock) {
		visited[x] = true;
		int rear = gear[x][2];
		int front = gear[x][6];
		if(clock == 1) {
			int temp = gear[x][7];
			for(int i = 7; i > 0; --i) {
				gear[x][i] = gear[x][i - 1];
			}
			gear[x][0] = temp;
		}else {
			int temp = gear[x][0];
			for(int i = 0; i < 7; ++i) {
				gear[x][i] = gear[x][i + 1];
			}
			gear[x][7] = temp;
		}
		if((x > 1) && (front != gear[x - 1][2]) && !visited[x - 1]) {
			Roll(x - 1, -clock);
		}
		if((x < 4) && (rear != gear[x + 1][6]) && !visited[x + 1]) {
			Roll(x + 1, -clock);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tok;
		
		for(int i = 1; i <= 4; ++i) {
			String input = br.readLine();
			for(int j = 0; j < 8; ++j) {
				gear[i][j] = input.charAt(j) - '0';
			}
		}
		
		K = Integer.parseInt(br.readLine());
		for(int i = 0; i < K; ++i) {
			tok = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(tok.nextToken());
			int clockwise = Integer.parseInt(tok.nextToken());
			Arrays.fill(visited, false);
			Roll(num, clockwise);
		}
		
		int ans = 0;
		int score = 1;
		for(int i = 1; i <= 4; ++i, score *= 2) {
			if(gear[i][0] == 1) {
				ans += score;
			}
		}
		System.out.print(ans + "\n");
	}
	
}
