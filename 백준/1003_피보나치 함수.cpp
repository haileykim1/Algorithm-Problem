#include<iostream>
using namespace std;

int zero[41] = { 0, };
int one[41] = { 0, };

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int T;
	cin >> T;
	zero[0] = 1;
	one[1] = 1;
	for (int i = 2; i <= 40; ++i) {
		zero[i] = zero[i - 1] + zero[i - 2];
		one[i] = one[i - 1] + one[i - 2];
	}
	while (T--) {
		int input;
		cin >> input;
		
		cout << zero[input] << " " << one[input] << '\n';
	}


}