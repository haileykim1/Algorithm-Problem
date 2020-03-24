#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int x, y;
	cin >> x >> y;
	if (x > 0) {
		if (y > 0)
			cout << 1 << "\n";
		else
			cout << 4 << '\n';
	}
	else {
		if (y > 0)
			cout << 2 << "\n";
		else
			cout << 3 << '\n';
	}

}