import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	
	static boolean[][] arr = new boolean[101][101];
	static int N, ans = 0;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	public static void DragonCurve(int x, int y, int d, int g) {
		//direction arraylist
		ArrayList<Integer> dir = new ArrayList<Integer>();
		
		dir.add(d);
		
		for(int i = 1; i <= g; ++i) {
			ArrayList<Integer> nDir = (ArrayList<Integer>) dir.clone();
			Collections.reverse(nDir);
			for(int j = 0; j < nDir.size(); ++j) {
				nDir.set(j,(nDir.get(j) + 5) % 4);
			}
			dir.addAll(nDir);
		}
		int nowX = x;
		int nowY = y;
		arr[x][y] = true;
		for(int i = 0; i < dir.size(); ++i) {
			int nowDir = dir.get(i);
			nowX += dx[nowDir];
			nowY += dy[nowDir];
			arr[nowX][nowY] = true;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer tok;
		for(int i = 0; i < N; ++i) {
			tok = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(tok.nextToken());
			int y = Integer.parseInt(tok.nextToken());
			int d = Integer.parseInt(tok.nextToken());
			int g = Integer.parseInt(tok.nextToken());
			DragonCurve(x, y, d, g);
		}
		for(int i = 0; i < 100; ++i) {
			for(int j = 0; j < 100; ++j) {
				if(arr[i][j] && arr[i][j + 1] && arr[i + 1][j] && arr[i + 1][j + 1]) {
					++ans;
				}
			}
		}
		
		System.out.print(ans + "\n");
		
	}
}
