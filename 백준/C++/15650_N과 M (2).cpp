#include<iostream>
#include<vector>

using namespace std;

int N, M;
vector<int> v;
bool visit[9] = { false, };

void DFS(int now, int before) {
	if (now == M) {
		for (int i = 0; i < M; ++i)
			cout << v[i] << " ";
		cout << '\n';
		return;
	}
	for (int i = before + 1; i <= N; ++i) {
		if (visit[i])
			continue;
		visit[i] = true;
		v.push_back(i);
		DFS(now + 1, i);
		visit[i] = false;
		v.pop_back();
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> M;
	DFS(0, 0);

}