#include<iostream>

#include<string>

#include<sstream>

using namespace std;

 

int main() {

	string teststr;

	int testcase;

	getline(cin, teststr);

	testcase = stoi(teststr);

	for (int t = 1; t <= testcase; t++) {

		int m,n;

		string str;

		getline(cin, str);

		stringstream ss;

		ss.str(str);

		string temp;

		ss >> temp;

		n = stoi(temp);

		ss >> temp;

		m = stoi(temp);

		int fly[15][15];

		for (int i = 0; i < n; i++) {

			int j = 0;

			string str;

			getline(cin, str);

			stringstream ss;

			ss.str(str);

			string flydata;

			while (ss >> flydata) {

				fly[i][j++] = stoi(flydata);

			}

		}

		

		int maxkill = 0;

		for (int s = 0; s < n - m + 1; s++) {

			for (int a = 0; a < n - m + 1; a++) {

				int tempfly = 0;

				for (int b = 0; b < m; b++) {	//���� �� �ִ� �ĸ� ������

					for (int c = 0; c < m; c++) {

						tempfly += fly[s+b][a+c];

					}

				}

				if (tempfly >= maxkill)

					maxkill = tempfly;

			}

		}

		cout << "#" << t << " " << maxkill << endl;

	}

	return 0;

}