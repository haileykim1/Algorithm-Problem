#include<iostream>
#include<list>
using namespace std;

void josephus(int n, int k) {
	list<int> survivors;

	for (int i = 1; i <= n; ++i)
		survivors.push_back(i);
	list<int>::iterator kill = survivors.begin();
	while (n > 2) {
		kill = survivors.erase(kill);
		if (kill == survivors.end())
			kill = survivors.begin();
		--n;
		for (int i = 0; i < k - 1; ++i) {
			if (++kill == survivors.end())
				kill = survivors.begin();
		}

	}
	printf("%d %d\n", survivors.front(), survivors.back());
}

int main() {
	int C, N, K;
	cin >> C;
	while (C--) {
		cin >> N >> K;
		josephus(N, K);
	}
}