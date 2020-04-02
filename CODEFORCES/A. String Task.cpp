#include<iostream>
#include<string>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	string input;
	string vowel = "aoyeuiAOYEUI";
	cin >> input;
	for (int i = 0; i < input.size(); ++i) {
		if (vowel.find(input[i]) != string::npos)
			continue;
		if (input[i] >= 'A' && input[i] <= 'Z')
			input[i] += 'a' - 'A';
		cout << "." << input[i];
	}
	cout << '\n';
}