#include<iostream>
#include<vector>
#include<memory.h>
#include<queue>
#include<algorithm>
using namespace std;

vector<int> v[1001];
bool visit[1001] = { 0, };
queue<int> q;

void DFS(int n) {
	visit[n] = true;
	cout << n << " ";
	for (int i = 0; i < v[n].size(); ++i) {
		if (!visit[v[n][i]]) {
			DFS(v[n][i]);
		}
	}
}
void BFS(int n) {
	q.push(n);
	visit[n] = true;
	while (!q.empty()) {
		int temp = q.front();
		cout << temp << " ";
		for (int i = 0; i < v[temp].size(); ++i) {
			if (!visit[v[temp][i]]) {
				q.push(v[temp][i]);
				visit[v[temp][i]] = true;
			}
		}

		q.pop();
	}
 }

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, M, V;
	cin >> N >> M >> V;
	for (int i = 0; i < M; ++i) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}
	
	for (int i = 0; i < N; ++i) {
		sort(v[i].begin(), v[i].end());
	}

	DFS(V);
	memset(visit, 0, sizeof(visit));
	cout << "\n";
	BFS(V); 
	cout << "\n";


}