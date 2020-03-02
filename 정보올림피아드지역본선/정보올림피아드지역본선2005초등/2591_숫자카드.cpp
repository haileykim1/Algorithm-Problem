#include<iostream>
#include<string>
using namespace std;

string input;
int n;
int cnt[41];
int count(int start) {

	if (cnt[start] != -1)
		return cnt[start];
	if (start == n)
		return cnt[n] = 1;
	if (input[start] == '0')
		return cnt[start] = 0;
	if (start == n - 1)
		return cnt[start] = 1;
	if (stoi(input.substr(start, 2)) > 34)
		return cnt[start] = count(start + 1);
	return cnt[start] = count(start + 1) + count(start + 2);
	
}

int main() {
	int ans;
	cin >> input;
	n = input.size();
	for (int i = 0; i < 41; ++i)
		cnt[i] = -1;
	ans = count(0);
	cout << ans;
}