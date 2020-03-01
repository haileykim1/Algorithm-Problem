#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int height[9];
	int dwarf[7];
	for (int i = 0; i < 9; i++) {
		cin >> height[i];
	}
	int i, j, sum, index = 0;
	for (i = 0; i < 9; i++) {
		for (j = 1; j < 9; j++) {
			if (i == j)
				continue;
			sum = 0;
			for (int k = 0; k < 9; k++) {
				if ((k == i) || (k == j))
					continue;
				sum += height[k];
			}
			if (sum == 100)
				break;
		}
		if (sum == 100)
			break;
	}
	for (int l = 0; l < 9; l++) {
		if ((l == i) || (l == j))
			continue;
		dwarf[index] = height[l];
		index++;
	}
	sort(dwarf, dwarf + 7);
	for (int l = 0; l < 7; l++)
		cout << dwarf[l] << '\n';

}