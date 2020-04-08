#include<iostream>
#include<math.h>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int T;
	cin >> T;
	double x1, y1, r1, x2, y2, r2;
	while (T--) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		if (x1 == x2 && y1 == y2 && r1 == r2) {
			cout << -1 << '\n';
			continue;
		}
		double dist = sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
		int big, small;
		if (r1 > r2) {
			big = r1;
			small = r2;
		}
		else {
			big = r2;
			small = r1;
		}
		if (dist == r1 + r2 || dist == big - small) {
			cout << 1 << '\n';
			continue;
		}
		else if (dist > big - small && dist < big + small) {
			cout << 2 << '\n';
			continue;
		}
		else
			cout << 0 << '\n';
	}
}