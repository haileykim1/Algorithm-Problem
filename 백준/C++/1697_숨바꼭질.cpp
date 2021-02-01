#include<iostream>
#include<queue>
using namespace std;

bool visit[100001];	//비트마스크로 처리해도 될듯 int visit[n >> 4] && (1 << (n & 15))

int bfs(int n, int k) {
	queue<pair<int, int>> q;	//(현재 위치, 이동횟수).
	q.push(make_pair(n, 0));
	visit[n] = true;

	while (!q.empty()) {
		pair<int, int> a = q.front();
		q.pop();
		int pos = a.first;
		int move = a.second;
		if (pos == k)
			return move;
		if (pos - 1 >= 0 && !(visit[pos - 1])) {
			q.push(make_pair(pos - 1, move + 1));
			visit[pos - 1] = true;
		}
		if (pos + 1 <= 100000 && !(visit[pos + 1])) {
			q.push(make_pair(pos + 1, move + 1));
			visit[pos + 1] = true;
		}
		if (pos * 2 <= 100000 && !(visit[pos * 2])) {
			q.push(make_pair(pos * 2, move + 1));
			visit[pos * 2] = true;
		}

	}
}

int main() {
	ios::sync_with_stdio(false);
	int N, K, min;
	cin >> N >> K;
	cout << bfs(N, K);
}