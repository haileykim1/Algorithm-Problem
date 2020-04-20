#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int N, M;
int inDegree[32001];
vector<int> order[32001];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> M;
	int a, b;
	for (int i = 0; i < M; ++i) {
		cin >> a >> b;
		++inDegree[b];
		order[a].push_back(b);
	}
	queue<int> q;
	for (int i = 1; i <= N; ++i) {
		if (!inDegree[i])
			q.push(i);
	}
	while (!q.empty()) {
		int now = q.front();
		cout << now << " ";
		for (int i = 0; i < order[now].size(); ++i) {
			if (--inDegree[order[now][i]] == 0)
				q.push(order[now][i]);
		}
		q.pop();
	}

}