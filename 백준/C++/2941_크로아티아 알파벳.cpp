#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	string input;
	cin >> input;
	int ans = input.size();
	for (int i = 0; i < input.size(); ++i) {
		if (input[i] == '=' || input[i] == '-') {
			--ans;
			continue;
		}
		if (input[i] == 'd') {
			if (i < input.size() - 2 && input[i + 1] == 'z' && input[i + 2] == '=') {
				ans -= 2;
				i += 2;
				continue;
			}
		}
		if (input[i] == 'n') {
			if (i < input.size() - 1 && input[i + 1] == 'j') {
				--ans;
				++i;
				continue;
			}
		}
		if (input[i] == 'l') {
			if (i < input.size() - 1 && input[i + 1] == 'j') {
				--ans;
				++i;
				continue;
			}
		}
	}
	cout << ans << '\n';
}