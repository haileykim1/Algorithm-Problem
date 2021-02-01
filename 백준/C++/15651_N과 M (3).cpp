#include<iostream>
#include<vector>
using namespace std;

int N, M;
vector<int> v;

void DFS(int now) {
	if (now == M) {
		for (int i = 0; i < M; ++i)
			cout << v[i] << " ";
		cout << '\n';
		return;
	}

	for (int i = 1; i <= N; ++i) {
		v.push_back(i);
		DFS(now + 1);
		v.pop_back();

	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N >> M;
	DFS(0);

}