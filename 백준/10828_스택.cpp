#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	stack<int> s;
	while (N--) {
		string op;
		cin >> op;
		if (op[0] == 't') {
			if (s.empty())
				cout << -1 << '\n';
			else
				cout << s.top() << '\n';
		}
		else if (op[0] == 's')
			cout << s.size() << '\n';
		else if (op[0] == 'e')
			cout << s.empty() << '\n';
		else if (op == "pop") {
			if (s.empty())
				cout << -1 << '\n';
			else {
				cout << s.top() << '\n';
				s.pop();
			}
		}
		else {
			int num;
			cin >> num;
			s.push(num);
		}
	}


}