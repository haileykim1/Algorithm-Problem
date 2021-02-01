#include<iostream>
using namespace std;

int N, ans = 0;
bool col[15], plusGrad[30], minusGrad[30];

void DFS(int now) {
	if (now == N) {
		++ans;
		return;
	}
	//now + 1번째 row의 자리 구하기.
	for (int i = 1; i <= N; ++i) {
		if (col[i] || plusGrad[i - now + 14] || minusGrad[i + now])
			continue;
		col[i] = plusGrad[i - now + 14] = minusGrad[i + now] = true;
		DFS(now + 1);
		col[i] = plusGrad[i - now + 14] = minusGrad[i + now] = false;

	}
}

int main() {
	cin >> N;
	DFS(0);
	cout << ans << '\n';
}