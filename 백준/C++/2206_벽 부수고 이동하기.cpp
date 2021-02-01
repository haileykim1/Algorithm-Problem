#include<iostream>
#include<string>
#include<queue>
using namespace std;

int N, M;
bool map[1000][1000];
int dist[1000][1000][2];
int mx[4] = { 1, 0, 0, -1 };
int my[4] = { 0, -1, 1, 0 };

int BFS() {
	//0개 부수는 경우.
	queue<pair<pair<int, int>, bool>> q;
	q.push({ { 0, 0 }, 1 });
	dist[0][0][1] = 1;

	while (!q.empty()) {
		int nx = q.front().first.first;
		int ny = q.front().first.second;
		bool chance = q.front().second;
		q.pop();

		if ((nx == N - 1) && (ny == M - 1))
			return dist[nx][ny][chance];

		for (int i = 0; i < 4; ++i) {
			int fx = nx + mx[i];
			int fy = ny + my[i];
			if (fx < 0 || fx >= N || fy < 0 || fy >= M)
				continue;
			if (map[fx][fy] && chance) {
				dist[fx][fy][0] = dist[nx][ny][1] + 1;
				q.push({ {fx, fy}, 0 });
			}
			else if(!map[fx][fy] && !dist[fx][fy][chance]) {
				dist[fx][fy][chance] = dist[nx][ny][chance] + 1;
				q.push({ {fx, fy}, chance });
			}
		}
	}
	return -1;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> M;
	string input;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		for (int j = 0; j < M; ++j)
			map[i][j] = input[j] - '0';
	}
	

	cout << BFS() << '\n';
}