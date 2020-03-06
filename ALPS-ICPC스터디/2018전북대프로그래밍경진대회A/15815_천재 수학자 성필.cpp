#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main() {
	string cal, op = "+-*/", ch;
	stack<int> s;
	int a, b, index;
	cin >> cal;
	for (int i = 0; i < cal.size(); ++i) {
		if (op.find(cal[i]) == string::npos) {
			ch = cal[i];
			s.push(stoi(ch));
		}
		else {
			b = s.top();
			s.pop();
			a = s.top();
			s.pop();
			index = op.find(cal[i]);
			if (index == 0)
				a += b;
			else if (index == 1)
				a -= b;
			else if (index == 2)
				a *= b;
			else
				a /= b;
			s.push(a);
		}
	}
	cout << s.top();
}