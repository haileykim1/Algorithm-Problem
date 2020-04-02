#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int n;
	cin >> n;
	while (n--) {
		string input;
		cin >> input;
		if (input.size() <= 10)
			cout << input << '\n';
		else
			cout << input[0] << input.size() - 2 << input[input.size() - 1] << '\n';
	}
}