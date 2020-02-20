#include<iostream>
#include<queue>
using namespace std;

int visit[(100000 >> 4) + 1] = {0, };
int bfs(int n, int k) {
	queue<pair<int, int>> q;
	q.push(make_pair(n, 0));
	visit[n >> 4] |= (1 << n);

	while (!q.empty()) {
		pair<int, int> a = q.front();
		q.pop();
		int pos = a.first;
		int move = a.second;
		if (pos == k)
			return move;
		if (pos - 1 >= 0 && !(visit[(pos - 1) >> 4] & (1 << (pos - 1 & 15)))) {
			q.push(make_pair(pos - 1, move + 1));
			visit[(pos - 1) >> 4] |= (1 << (pos - 1 & 15));
		}
		if (pos + 1 <= 100000 && !(visit[(pos + 1) >> 4] & (1 << (pos + 1 & 15)))) {
			q.push(make_pair(pos + 1, move + 1));
			visit[(pos + 1) >> 4] |= (1 << (pos + 1 & 15));
		}
		if (pos * 2 <= 100000 && !(visit[(pos * 2) >> 4] & (1 << (pos * 2 & 15)))) {
			q.push(make_pair(pos * 2, move + 1));
			visit[(pos * 2) >> 4] |= (1 << (pos * 2 & 15));
		}

	}
}

int main() {
	ios::sync_with_stdio(false);
	int N, K, min;
	cin >> N >> K;
	cout << bfs(N, K);
}