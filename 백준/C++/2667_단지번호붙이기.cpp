#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
using namespace std;

bool isHouse[25][25];
bool visit[25][25] = { false, };
int mx[4] = { -1, 0, 0, 1 };
int my[4] = { 0, -1, 1, 0 };
int cnt = 0;
vector<int> v;
int N;

void DFS(int a, int b) {

	visit[a][b] = true;
	++cnt;
	for (int i = 0; i < 4; ++i) {
		int nx = a + mx[i];
		int ny = b + my[i];
		if (nx < 0 || nx >= N || ny < 0 || ny >= N)
			continue;
		if ((!visit[nx][ny]) && isHouse[nx][ny])
			DFS(nx, ny);
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> N;
	string input;
	for (int i = 0; i < N; ++i) {
		cin >> input;
		for (int j = 0; j < N; ++j) {
			isHouse[i][j] = input[j] - '0';
		}
	}

	for (int i = 0; i < N; ++i) {
		for (int j = 0; j < N; ++j) {
			if (isHouse[i][j] && !visit[i][j]) {
				cnt = 0;
				DFS(i, j);
				v.push_back(cnt);
			}
			
		}
	}

	sort(v.begin(), v.end());

	cout << v.size() << '\n';
	for (int i = 0; i < v.size(); ++i)
		cout << v[i] << '\n';

}