#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int minburger = 2100, mindrink = 2100;
	int input;
	for (int i = 0; i < 3; ++i) {
		cin >> input;
		minburger = input < minburger ? input : minburger;
	}
	for (int i = 0; i < 2; ++i) {
		cin >> input;
		mindrink = input < mindrink ? input : mindrink;
	}
	cout << minburger + mindrink - 50 << '\n';
}