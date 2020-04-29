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
		while (a[j] >= m && a[j] <= M)	//������ �� ã��
			++j;
		maxLen = max(maxLen, j - i);
		if (a[j] > a[j - 1]) {	//������
			M = a[j];
			m = a[j - 1];
		}
		else {
			M = a[j - 1];
			m = a[j];
		}
		i = j;
		while (a[i] >= m && a[i] <= M)	//���� �� ã��
			--i;
		++i;
	}
	cout << maxLen << '\n';
}