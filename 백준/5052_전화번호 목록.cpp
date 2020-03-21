#include<iostream>
#include<vector>
#include<string>
#include<algorithm>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int t;
	cin >> t;
	while (t--) {
		int n;
		cin >> n;
		string input;
		vector<string> phone;
		bool iscon = true;
		for (int i = 0; i < n; ++i) {
			cin >> input;
			phone.push_back(input);
		}
		sort(phone.begin(), phone.end());

		for (int i = 0; i < n - 1; ++i) {
			if (phone[i].size() < phone[i + 1].size()) {
				int j;
				for (j = 0; j < phone[i].size(); ++j) {
					if (phone[i][j] != phone[i + 1][j])
						break;
				}
				if (j == phone[i].size())
					iscon = false;
			}
		}

		if (iscon)
			cout << "YES\n";
		else
			cout << "NO\n";
	}

}