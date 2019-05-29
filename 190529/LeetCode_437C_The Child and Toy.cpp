#include<iostream>
#include<string>
#include<sstream>
using namespace std;

int main() {
	int n, m;
	string str;
	stringstream ss;
	string data;
	getline(cin, str);
	ss.str(str);
	ss >> data;
	n = stoi(data);
	ss >> data;
	m = stoi(data);
	int* energy;
	int sumenergy = 0;
	energy = new int[n];

	getline(cin, str);
	stringstream ss2;
	ss2.str(str);
	int i = 0;
	while (ss2 >> data) {
		energy[i++] = stoi(data);
	}	
	for (int j = 0; j < m; j++) {
		int a, b;
		getline(cin, str);
		stringstream ss3;
		ss3.str(str);
		ss3 >> data;
		a = stoi(data);
		ss3 >> data;
		b = stoi(data);
		sumenergy += (energy[a - 1] > energy[b - 1]) ? energy[b - 1] : energy[a - 1];
	}
	cout << sumenergy;
	system("pause");
	return 0;
}