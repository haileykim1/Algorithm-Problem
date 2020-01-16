#include<iostream>
#include<string>
using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	string str[2];
	string sumstr = "";
	int num[2] = { 0,0 };
	cin >> str[0];
	cin >> str[1];
	for (int j = 0; j < 2; j++) {
		for (int i = 1; i <= str[j].length(); i++) {
			if ((str[j].substr(i - 1, 2) != "IV") && (str[j].substr(i - 1, 2) != "IX") && (str[j].substr(i - 1, 2) != "XL") && (str[j].substr(i - 1, 2) != "XC") && (str[j].substr(i - 1, 2) != "CD") && (str[j].substr(i - 1, 2) != "CM")) {
				if (str[j][i - 1] == 'M')
					num[j] += 1000;
				else if (str[j][i - 1] == 'D')
					num[j] += 500;
				else if (str[j][i - 1] == 'C')
					num[j] += 100;
				else if (str[j][i - 1] == 'L')
					num[j] += 50;
				else if (str[j][i - 1] == 'X')
					num[j] += 10;
				else if (str[j][i - 1] == 'V')
					num[j] += 5;
				else if (str[j][i - 1] == 'I')
					num[j] += 1;

			}
			else {
				if (str[j].substr(i - 1, 2) == "IV")
					num[j] += 4;
				else if (str[j].substr(i - 1, 2) == "IX")
					num[j] += 9;
				else if (str[j].substr(i - 1, 2) == "XL")
					num[j] += 40;
				else if (str[j].substr(i - 1, 2) == "XC")
					num[j] += 90;
				else if (str[j].substr(i - 1, 2) == "CD")
					num[j] += 400;
				else if (str[j].substr(i - 1, 2) == "CM")
					num[j] += 900;
				i++;
			}
			if (i == str[j].length() - 1) {
				if (str[j][i] == 'M')
					num[j] += 1000;
				else if (str[j][i] == 'D')
					num[j] += 500;
				else if (str[j][i] == 'C')
					num[j] += 100;
				else if (str[j][i] == 'L')
					num[j] += 50;
				else if (str[j][i] == 'X')
					num[j] += 10;
				else if (str[j][i] == 'V')
					num[j] += 5;
				else if (str[j][i] == 'I')
					num[j] += 1;
				break;
			}
		}
	}
	int sum = num[0] + num[1];
	cout << sum << '\n';
	while ((sum - 1000) >= 0) {
		sum -= 1000;
		sumstr += "M";
	}//백의 자리로 내려옴.
	if (sum >= 900) {
		sum -= 900;
		sumstr += "CM";
	}
	if (sum >= 500) {
		sum -= 500;
		sumstr += "D";
	}
	if (sum >= 400) {
		sum -= 400;
		sumstr += "CD";
	}
	while ((sum - 100) >= 0) {
		sum -= 100;
		sumstr += "C";
	}//십의 자리로 내려옴.
	if (sum >= 90) {
		sum -= 90;
		sumstr += "XC";
	}
	if (sum >= 50) {
		sum -= 50;
		sumstr += "L";
	}
	if (sum >= 40) {
		sum -= 40;
		sumstr += "XL";
	}
	while ((sum - 10) >= 0) {
		sum -= 10;
		sumstr += "X";
	}
	if (sum >= 9) {
		sum -= 9;
		sumstr += "IX";
	}
	if (sum >= 5) {
		sum -= 5;
		sumstr += "V";
	}
	if (sum >= 4) {
		sum -= 4;
		sumstr += "IV";
	}
	while ((sum - 1) >= 0) {
		sum -= 1;
		sumstr += "I";
	}
		cout << sumstr;
}