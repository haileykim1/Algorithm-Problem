#include<iostream>
using namespace std;

int N, minans = 1000000000, maxans = -1000000000;
int opcnt[4];	//+-*/순.
int A[12];

void DFS(int now, int ans) {
	if (now == N) {
		maxans = ans > maxans ? ans : maxans;
		minans = ans < minans ? ans : minans;
		return;
	}
	for (int i = 0; i < 4; ++i) {
		if (opcnt[i]) {
			--opcnt[i];
			if (i == 0)
				DFS(now + 1, ans + A[now + 1]);
			else if (i == 1)
				DFS(now + 1, ans - A[now + 1]);
			else if (i == 2)
				DFS(now + 1, ans * A[now + 1]);
			else if (i == 3)
				DFS(now + 1, ans / A[now + 1]);
			++opcnt[i];
		}
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	cin >> N;
	for (int i = 1; i <= N; ++i)
		cin >> A[i];
	cin >> opcnt[0] >> opcnt[1] >> opcnt[2] >> opcnt[3];
	DFS(1, A[1]); //n번째 수까지 연산 완료.

	cout << maxans << '\n' << minans << '\n';
}