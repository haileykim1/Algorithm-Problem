#include<iostream>
#include<vector>
using namespace std;
int N, M;
bool visit[9];
vector<int> v;

void DFS(int now) {
	if (now == M) {
		for (int i = 0; i < v.size(); ++i)
			cout << v[i] << " ";
		cout << '\n';
		return;
	}
	for (int i = 1; i <= N; ++i) {
		if (visit[i])
			continue;
		visit[i] = true;
		v.push_back(i);
		DFS(now + 1);
		visit[i] = false;
		v.pop_back();
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int number[8];
	cin >> N >> M;
	DFS(0);
}