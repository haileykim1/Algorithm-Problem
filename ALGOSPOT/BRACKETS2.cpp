#include<iostream>
#include<string>
#include<stack>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int C;
	cin >> C;
	while (C--) {
		string br,open = "[{(", close = "]})";
		stack<int> s;
		cin >> br;
		char c;
		int index, index2;
		for (int i = 0; i < br.size(); ++i) {
			c = br[i];
			if ((index = open.find(c)) != string::npos)
				s.push(index);
			else {
				index = close.find(c);
				if (!s.empty())
					index2 = s.top();
				else {
					s.push(3);
					break;
				}
				if (index == index2)
					s.pop();
				else
					break;
			}
		}
		if (s.empty())
			cout << "YES" << '\n';
		else
			cout << "NO" << '\n';
	}
}