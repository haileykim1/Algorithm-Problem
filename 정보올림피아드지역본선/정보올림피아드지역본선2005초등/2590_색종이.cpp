#include<iostream>
using namespace std;

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int paper[7];
	int input, ans = 0;
	for (int i = 1; i <= 6; ++i) {
		cin >> input;
		paper[i] = input;
	}
	//6cm 葛滴 贸府
	ans += paper[6];
	//5cm 葛滴 贸府
	ans += paper[5];
	paper[1] -= paper[5] * 11;
	//4cm 葛滴 贸府
	ans += paper[4];
	paper[2] -= paper[4] * 5;
	if (paper[2] < 0)
		paper[1] += paper[2] * 4;
	//3cm 葛滴 贸府.
	if (paper[3] > 0) {
		ans += (paper[3] + 3) / 4;
		if (paper[3] % 4 == 1) {
			if (paper[2] > 0) {
				paper[2] -= 5;
				if (paper[2] < 0)
					paper[2] -= 7 - paper[2] * 4;
				else
					paper[1] -= 7;
			}
			else
				paper[1] -= 27;
		}
		else if (paper[3] % 4 == 2) {
			if (paper[2] > 0) {
				paper[2] -= 3;
				if (paper[2] < 0)
					paper[1] -= 6 - paper[2] * 4;
				else
					paper[1] -= 6;
			}
			else
				paper[1] -= 18;
		}
		else if (paper[3] % 4 == 3) {
			if (paper[2] > 0) {
				paper[2]--;
				paper[1] -= 5;
			}
			else
				paper[1] -= 9;
		}
	}
	//2cm 葛滴 贸府.
	if (paper[2] > 0) {
		ans += (paper[2] + 8) / 9;
		if (paper[2] % 9)
			paper[1] -= (9 - (paper[2] % 9)) * 4;
	}
	//1cm 葛滴 贸府.
	if(paper[1] > 0)
		ans += (paper[1] + 35) / 36;
	cout << ans;
}