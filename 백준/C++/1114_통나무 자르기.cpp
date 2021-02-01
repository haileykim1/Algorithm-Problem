#include<iostream>
#include<algorithm>
using namespace std;

int L, K, C, l, r, m, ans;
int able[10010];

bool isPossible(int x) {
	int i, diff = 0, cutcnt = 0;
	//제일 처음 자르는 위치 출력에 쓰이는 용도.
	if (able[x - 1] > m)
		return 0;
	for (i = x; i <= K + 1; ++i) {
		if (able[i] - able[i - 1] > m)
			return 0;
		if (diff + able[i] - able[i - 1] > m) {
			++cutcnt;
			diff = able[i] - able[i - 1];
			if (cutcnt > C)
				return 0;
		}
		else
			diff += able[i] - able[i - 1];
	}
	ans = m;
	return 1;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> L >> K >> C;
	for (int i = 1; i <= K; ++i) {
		cin >> able[i];
	}
	able[K + 1] = L;
	sort(able + 1, able + K + 2);
	l = 0;
	r = L;
	while (l <= r) {
		m = (l + r) / 2;
		if (isPossible(1))
			r = m - 1;
		else
			l = m + 1;
	}
	m = ans;
	int a;
	C--;
	for (a = 1; a <= K; ++a) {
		if (isPossible(a + 1))
			break;
	}
	cout << ans  << " " << able[a];

}