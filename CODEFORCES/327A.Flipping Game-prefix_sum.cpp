#include<iostream>
using namespace std;

bool a[101];
int psum[101];	//i에서 0개수 - 1개수
int cntI = 0;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	for (int i = 1; i <= n; ++i) {
		cin >> a[i];
		if (a[i]) {
			++cntI;
			psum[i] = psum[i - 1] - 1;
		}
		else
			psum[i] = psum[i - 1] + 1;
	}

	int maxGain = -1;
	for (int i = 0 ; i <= n; ++i) {
		for (int j = i + 1; j <= n; ++j) {
			if (psum[j] - psum[i] > maxGain) {
				maxGain = psum[j] - psum[i];
			}
		}
	}

	cout << cntI + maxGain << '\n';
}