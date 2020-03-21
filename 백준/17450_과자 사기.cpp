#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);

	double p[3];
	double w[3];
	double g[3];

	for (int i = 0; i < 3; ++i) {
		cin >> p[i] >> w[i];

		if (p[i] >= 500)
			g[i] = w[i] * 10 / (p[i] * 10 - 500);
		else
			g[i] = w[i] / p[i];
	}
	int idx = -1;
	double max = 0;
	for (int i = 0; i < 3; ++i) {
		if (g[i] > max) { 
			max = g[i];
			idx = i;
		}

	}
	if (idx == 0)
		cout << "S\n";
	else if (idx == 1)
		cout << "N\n";
	else
		cout << "U\n";

}