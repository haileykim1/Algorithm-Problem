#include<iostream>
#include<vector>
using namespace std;

vector<pair<int, int>> v;

void Hanoi(int k, int now, int to) {
	if (k == 1) {
		v.push_back({ now, to });
	}
	else {

		
		Hanoi(k - 1, now, 6 - now - to);
		v.push_back({ now, to });
		Hanoi(k - 1, 6 - now - to, to);

	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int K;
	cin >> K;
	Hanoi(K, 1, 3);

	cout << v.size() << '\n';
	for (int i = 0; i < v.size(); ++i)
		cout << v[i].first << " " << v[i].second << '\n';

}