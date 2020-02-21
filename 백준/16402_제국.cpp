#include<iostream>
#include<vector>
#include<string>
#include<sstream>
#include<algorithm>
using namespace std;

vector<int> parent;
vector<string> name;
int getParent(int num) {
	if (parent.at(num) == num)
		return num;
	return parent[num] = getParent(parent[num]);
}
int getnum(string n) {
	for (int i = 0; i < name.size(); ++i) {
		if (n == name.at(i))
			return i;
	}
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N, M;
	string temp;

	cin >> N >> M;
	cin.ignore();	//입력 버퍼 지움
	for (int i = 0; i < N; ++i) {
		getline(cin,temp);
		name.push_back(temp);
		parent.push_back(i);
	}
	while (M--) {
		int war[3];
		getline(cin, temp);
		stringstream ss(temp);
		int i = 0;
		string temp2;
		getline(ss, temp2, ',');
		war[0] = getnum(temp2);
		getline(ss, temp2, ',');
		war[1] = getnum(temp2);
		getline(ss, temp2, ',');
		war[2] = stoi(temp2);
		if (getParent(war[0]) == war[1] && war[2] == 1)
			parent[war[0]] = parent[war[1]] = war[0];
		else if (getParent(war[1]) == war[0] && war[2] == 2)
			parent[war[1]] = parent[war[0]] = war[1];
		else {
			if (war[2] == 1)
				parent[getParent(war[1])] = getParent(war[0]);
			else
				parent[getParent(war[0])] = getParent(war[1]);
		}
	}
	vector<string> own;
	for (int i = 0; i < N; ++i) {
		if (getParent(i) == i)
			own.push_back(name.at(i));
	}
	sort(own.begin(), own.end());
	cout << own.size() << '\n';
	for (int i = 0; i < own.size(); ++i)
		cout << own.at(i) << '\n';
}