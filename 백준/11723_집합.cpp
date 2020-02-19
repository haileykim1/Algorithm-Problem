#include<iostream>
#include<string>
using namespace std;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	int M, S = 0, x;
	string al;
	cin >> M;
	while (M--) {
		cin >> al;
		if (!al.compare("all"))
			S = (1 << 21) - 1;
		else if (al[0] == 'e')
			S = 0;
		else {
			cin >> x;
			if (al[0] == 'a')
				S |= (1 << x);
			else if (al[0] == 'r')
				S &= ~(1 << x);
			else if (al[0] == 'c') {
				cout << (bool)(S & (1 << x)) << '\n';
			}
			else if (al[0] == 't')
				S ^= (1 << x);
		}
	}
}