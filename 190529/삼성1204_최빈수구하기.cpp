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

		getline(cin, teststr);

		int testnum = stoi(teststr);

		int score[100] = {0,};

		string bigdata;

		getline(cin, bigdata);

		stringstream ss;

		ss.str(bigdata);

		string mydata;

		while (ss >> mydata) {

			score[stoi(mydata)-1]++;

		}

		int mode=0;

		for (int i = 1; i < 100; i++) {

			if (score[mode] <= score[i]) {

				mode = i;

			}

 

		}

		cout << "#" <<testnum<<" "<<mode+1<< endl;

	}

	return 0;

}