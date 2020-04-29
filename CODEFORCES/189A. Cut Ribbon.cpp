#include<iostream>
#include<algorithm>
#include<memory.h>
using namespace std;

int ribbons[4001] = { 0, };
int n;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int len[3];
	cin >> n >> len[0] >> len[1] >> len[2];
	memset(ribbons, 0, sizeof(ribbons));
	ribbons[0] = 0;
	sort(len, len + 3);
	ribbons[len[0]] = ribbons[len[1]] = ribbons[len[2]] = 1;
	for (int i = len[0] + 1; i <= n; ++i) {
		int maxVal = 0;
		for (int j = 0; j < 3; ++j) {
			if ((i - len[j]) > 0) {
				if (ribbons[i - len[j]])
					maxVal = max(maxVal, ribbons[i - len[j]] + 1);
			}
			ribbons[i] = max(maxVal, ribbons[i]);
		}
	}
	cout << ribbons[n] << '\n';
}