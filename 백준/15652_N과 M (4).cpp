#include<iostream>
#include<vector>
using namespace std;

int N, M;
vector<int> v;

void DFS(int now, int before) {
	if (now == M) {
		for (int i = 0; i < M; ++i)
			cout << v[i] << " ";
		cout << '\n';
		return;
	}
	for (int i = before; i <= N; ++i) {
		v.push_back(i);
		DFS(now + 1, i);
		v.pop_back();
	}

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> M;
	DFS(0, 1);

}