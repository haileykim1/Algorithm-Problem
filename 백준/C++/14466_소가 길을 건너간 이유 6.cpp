#include<iostream>
#include<vector>
#include<memory.h>
#include<set>
using namespace std;

int mx[4] = { 0, 0, -1, 1 };
int my[4] = { -1, 1, 0, 0 };
set <pair <int, int>> connect[101][101];
int N, K, R;
bool visit[101][101] = { false, };

void dfs(int x, int y) {
	//지금칸으로 부터 갈 수 있는 곳
	if (x < 1 || x > N || y < 1 || y > N)
		return;
	visit[x][y] = true;
	for (int i = 0; i < 4; ++i) {
		int nx = x + mx[i];
		int ny = y + my[i];
		if (!connect[x][y].count({ nx, ny }) && !visit[nx][ny])
			dfs(nx, ny);
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> K >> R;
	for (int i = 0; i < R; ++i) {
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		connect[a][b].insert({ c, d });
		connect[c][d].insert({ a, b });
	}
	vector<pair<int, int>> cow(K);
	for (int i = 0; i < K; ++i)
		cin >> cow[i].first >> cow[i].second;
	
	int ans = 0;
	for (int i = 0; i < K; ++i) {
		memset(visit, false, sizeof(visit));
		dfs(cow[i].first, cow[i].second);
		for (int j = i + 1; j < K; ++j) {
			if (!visit[cow[j].first][cow[j].second])
				++ans;
		}
	}
	cout << ans << '\n';
}