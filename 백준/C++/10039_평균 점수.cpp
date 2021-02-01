#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int sum = 0;
	for (int i = 0; i < 5; ++i) {
		int input;
		cin >> input;
		if (input < 40)
			sum += 40;
		else
			sum += input;
	}
	cout << sum / 5 << '\n';
}