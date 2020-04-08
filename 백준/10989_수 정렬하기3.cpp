#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int natural[10001] = { 0, };
	int N, input, min = 10000, max = 0;
	cin >> N;
	while (N--) {
		cin >> input;
		++natural[input];
		min = input < min ? input : min;
		max = input > max ? input : max;
	}
	for (int i = min; i <= max; ++i) {
		if (natural[i]) {
			for (int j = 0; j < natural[i]; ++j)
				cout << i << '\n';
		}
	}
}