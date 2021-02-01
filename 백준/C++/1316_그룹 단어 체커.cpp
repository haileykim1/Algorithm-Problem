#include<iostream>
#include<string>
#include<set>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, cnt = 0;
	cin >> N;
	string input;
	while (N--) {
		bool b = true;
		set<char> s;
		cin >> input;
		for (int i = 0; i < input.size(); ++i) {
			if (!s.count(input[i]))
				s.insert(input[i]);
			else {
				if (input[i - 1] != input[i]) {
					b = false;
					break;
				}
			}
		}
		if (b)
			++cnt;
	}
	cout << cnt << '\n';
}