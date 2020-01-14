#include<iostream>
#include<string>
using namespace std;


int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int number, similarnum = 0;
	cin >> number;
	int alphabet0[26] = { 0, };
	int alphabet1[26] = { 0, };
	string* word = new string[number];
	for (int i = 0; i < number; i++)
		cin >> word[i];
	int pivotlength = word[0].length();
	for (int i = 0; i < word[0].length(); i++) {
		alphabet0[word[0][i] - 65]++;	//A´Â 65
	}
	int difference,wordlength;
	for (int i = 1; i < number; i++) {
		difference = 0;
		wordlength = word[i].length();
		for (int j = 0; j < 26; j++)
			alphabet1[j] = 0;

		for (int j = 0; j < word[i].length(); j++) {
			alphabet1[word[i][j] - 65]++;
		}
		if (((pivotlength - wordlength) > 1) || ((pivotlength - wordlength) < -1)) {
			difference += 3;
		}
		for (int j = 0; j < 26; j++) {
			if (alphabet0[j] != alphabet1[j]) {
				if (((alphabet0[j] - alphabet1[j]) > 1) || ((alphabet0[j] - alphabet1[j]) < -1)) {
					difference += 3;
					break;
				}
				else {
					difference++;
				}
			}
		}
		
		if ((difference <= 2))
			similarnum++;
	}

	cout << similarnum;
}