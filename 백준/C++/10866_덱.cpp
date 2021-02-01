#include<deque>
#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	deque<int> dq;
	string dqQuery[8] = { "push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back" };
	while (N--) {
		string input;
		cin >> input;
		if (input == dqQuery[0] || input == dqQuery[1]) {
			int num;
			cin >> num;
			if (input == dqQuery[0])
				dq.push_front(num);
			else
				dq.push_back(num);
			continue;
		}
		if (input == dqQuery[2]) {
			if (dq.empty())
				cout << -1 << '\n';
			else {
				cout << dq.front() << '\n';
				dq.pop_front();
			}
		}
		if (input == dqQuery[3]) {
			if (dq.empty())
				cout << -1 << '\n';
			else {
				cout << dq.back() << '\n';
				dq.pop_back();
			}
		}
		if (input == dqQuery[4]) {
			cout << dq.size() << '\n';
		}
		if (input == dqQuery[5]) {
			if (dq.empty())
				cout << 1 << '\n';
			else
				cout << 0 << '\n';
		}
		if (input == dqQuery[6]) {
			if (dq.empty())
				cout << -1 << '\n';
			else {
				cout << dq.front() << '\n';
			}
		}
		if (input == dqQuery[7]) {
			if (dq.empty())
				cout << -1 << '\n';
			else {
				cout << dq.back() << '\n';
			}
		}
	}

}