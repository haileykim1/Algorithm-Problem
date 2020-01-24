#include<iostream>
#include<vector>
#include<queue>

using namespace std;

int main() {
	vector<int> destination[1001];
	vector<int> score[1001];
	vector<int> path;
	int inDegree[1001] = { 0, };		//cycle 없고 처리하는데 순서가 있으므로 topological하게 처리.
	int max[1001] = { 0, };
	queue<int> q;	
	int parent[1001];
	int N, M;
	cin >> N >> M;
	for (int i = 0; i < M; i++) {
		int p, q, r;
		cin >> p >> q >> r;
		destination[p].push_back(q);
		score[p].push_back(r);
		inDegree[q]++;
	}
	bool one = false;
	q.push(1);
	while (!q.empty()) {
		int now = q.front();
		if (now == 1) {
			if (one)
				break;
			one = true;
		}
		for (int i = 0; i < destination[now].size(); i++) {
			int y = destination[now].at(i);
			if (max[now] + score[now].at(i) > max[y]) {
				max[y] = max[now] + score[now].at(i);
				parent[y] = now;
			}
			if (--inDegree[y] == 0)
				q.push(y);
		}
		q.pop();
	}
	path.push_back(1);
	int now = parent[1];
	while (now != 1) {
		path.push_back(now);
		now = parent[now];
	}
	path.push_back(1);

	cout << max[1] <<'\n';
	while (!path.empty()) {
		cout << path.back() <<" ";
		path.pop_back();
	}
}