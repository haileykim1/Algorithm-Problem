#include<iostream>
#include<algorithm>
using namespace std;

int n;
int a[100002];

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> n;
	a[0] = a[n + 1] = 100003;	
	for (int i = 1; i <= n; ++i)
		cin >> a[i];
	int i = 1, j = 2, maxLen = 0, M = a[1], m = a[1];

	while (j <= n) {
		while (a[j] >= m && a[j] <= M)	//오른쪽 끝 찾기
			++j;
		maxLen = max(maxLen, j - i);
		if (a[j] > a[j - 1]) {	//재조정
			M = a[j];
			m = a[j - 1];
		}
		else {
			M = a[j - 1];
			m = a[j];
		}
		i = j;
		while (a[i] >= m && a[i] <= M)	//왼쪽 끝 찾기
			--i;
		++i;
	}
	cout << maxLen << '\n';
}