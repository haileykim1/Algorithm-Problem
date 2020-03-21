#include<iostream>
using namespace std;

bool visit[100][100];
int mx[2][3] = { {0, -1, 1},{0, -1, 1} };
int my[2][3] = { {-1, 1, 1},{1, -1, -1} };
int N, cnt = 0;

void dfs(int x, int y, int type, int check, int bx, int by) {
	visit[x][y] = true;
	if (check > N) {
		visit[x][y] = false;
		return;
	}
	for (int i = 0; i < 3; ++i) {
		int nx = x + mx[type][i];
		int ny = y + my[type][i];
		if (nx == bx && ny == by)
			continue;
		if (visit[nx][ny]) {
			if (check == N)
				++cnt;
		}
		else {
			dfs(nx, ny, !type, check + 1, x, y);
		}
	}
	visit[x][y] = false;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N;
	//50,50 에서 시작.
	dfs(50, 50, 0, 0, 50, 50);
	cout << cnt / 3 << '\n';
	
}