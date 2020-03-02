#include<iostream>
#include<string>
#include<queue>
#include<string.h>
using namespace std;
int ans = 0;
int hor, ver;
string map[51];
int dist[51][51];
int dx[4] = { -1, 1, 0, 0 };
int dy[4] = { 0, 0, -1, 1 };

void BFS(int i, int j) {
	bool visit[51][51] = { false, };

	queue<pair<int, int>> q;
	q.push(make_pair(i, j));
	visit[i][j] = true;
	dist[i][j] = 0;
	while (!q.empty()) {
		int ny = q.front().first;
		int nx = q.front().second;
		q.pop();
		for (int k = 0; k < 4; ++k) {
			int nny = ny + dy[k];
			int nnx = nx + dx[k];
			if (nny >= 0 && nny < ver && nnx >= 0 && nnx < hor) {
				if (map[nny][nnx] == 'L' && !visit[nny][nnx]) {
					visit[nny][nnx] = true;
					dist[nny][nnx] = dist[ny][nx] + 1;
					q.push(make_pair(nny, nnx));
					ans = ans > dist[nny][nnx] ? ans : dist[nny][nnx];
				}

			}
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> ver >> hor;
	for (int i = 0; i < ver; ++i)
		cin >> map[i];
	for (int i = 0; i < ver; ++i) {
		for (int j = 0; j < hor; ++j) {
			if (map[i][j] == 'L') {
				BFS(i, j);
			}
		}
	}
	cout << ans;
}