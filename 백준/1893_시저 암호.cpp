#include<iostream>
#include<string>
#include<vector>
#include<map>
using namespace std;

map<char, int> mp;

vector<int> getPi(string p) {//실패함수
	int pSize = (int)p.size();
	int j = 0;

	vector<int> pi(pSize, 0);
	
	for (int i = 1; i < pSize; ++i) {
		while (j && p[i] != p[j])
			j = pi[j - 1];
		if (p[i] == p[j])
			pi[i] = ++j;
	}
	return pi;
}

vector<int> kmp(string s, string p) {
	vector<int> ans;
	auto pi = getPi(p);
	int sSize = (int)s.size(), pSize = (int)p.size(), j = 0;
	for (int i = 0; i < sSize; ++i) {
		while (j && s[i] != p[j])
			j = pi[j - 1];
		if (s[i] == p[j]) {
			if (j == pSize - 1) {
				ans.push_back(i - pSize + 1);
				j = pi[j];
			}
			else
				++j;
		}
	}
	return ans;
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int N;
	cin >> N;
	string A, W, S;
	while (N--) {
		vector<int> ans;
		cin >> A >> W >> S;
		
		int lenA = A.size();
		//알파벳 순서 map에다 순서 붙여서 넣어둠.
		for (int i = 0; i < lenA; ++i)
			mp[A[i]] = i;
		
		int lenW = W.size();
		for (int shift = 0; shift < lenA; ++shift) {
			string temp = W;
			//원문 한칸씩 shift해서 temp 에 담아둠.
			for (int i = 0; i < lenW; ++i)
				temp[i] = A[(mp[temp[i]] + shift) % lenA];
			
			vector<int> vc = kmp(S, temp);

			if (vc.size() == 1)
				ans.push_back(shift);

		}
		if (!ans.size())
			cout << "no solution\n";
		else if (ans.size() == 1)
			cout << "unique: " << ans[0] << '\n';
		else {
			cout << "ambiguous: ";
			for (int i = 0; i < ans.size(); ++i)
				cout << ans[i] << " ";
			cout << '\n';

		}

	}

}