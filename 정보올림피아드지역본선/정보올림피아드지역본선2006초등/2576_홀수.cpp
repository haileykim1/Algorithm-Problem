#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int input, sum = 0, min = 100;
	for (int i = 0; i < 7; ++i) {
		cin >> input;
		if (input % 2) {
			sum += input;
			min = min < input ? min : input;
		}
	}
	if (sum == 0)
		cout << -1;
	else
		cout << sum << '\n' << min;
}