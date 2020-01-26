#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

int parent[101];
vector<int> team;
vector<int> teammem[101];

int getParent(int now) {
	if (parent[now] == now)
		return now;
	return parent[now] = getParent(parent[now]);
}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	int step[101][101];
	int N, M;
	cin >> N >> M; 
	for (int i = 1; i <= N; i++) {
		parent[i] = i;
		fill(&step[i][1], &step[i][1] + N, 120);
		step[i][i] = 0;
	}
	for (int i = 0; i < M; i++) {
		int p, q;
		cin >> p >> q;
		step[p][q] = step[q][p] = 1;
		//union
		if (getParent(p) > getParent(q))
			parent[getParent(p)] = getParent(q);
		else
			parent[getParent(q)] = getParent(p);
	}

	for (int i = 1; i < N + 1; i++) {
		bool found = false;
		for (int j = 0; j < team.size(); j++) {
			if (getParent(i) == team.at(j)) {
				found = true;
				teammem[team.at(j)].push_back(i);
			}
		}
		if (!found) {
			team.push_back(getParent(i));
			teammem[getParent(i)].push_back(i);
		}
	}
	//floydWarshall
	for (int k = 1; k <= N; k++) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (step[i][j] > step[i][k] + step[k][j])
					step[i][j] = step[i][k] + step[k][j];
			}
		}
	}

	vector<int> minmem;
	for (int i = 0; i < team.size(); i++) {
		int min = 120, max , minindex;
		int teamid = team.at(i);
		for (int j = 0; j < teammem[teamid].size(); j++) {
			max = 0;
			for (int k = 0; k < teammem[teamid].size(); k++) {
				if (max < step[teammem[teamid].at(j)][teammem[teamid].at(k)])
					max = step[teammem[teamid].at(j)][teammem[teamid].at(k)];
			}
			if (max < min) {
				minindex = teammem[team.at(i)].at(j);
				min = max;
			}
		}
		minmem.push_back(minindex);
	}
	sort(minmem.begin(), minmem.end());
	cout << team.size() << '\n';

	for (int i = 0; i < minmem.size(); i++)
		cout << minmem.at(i) << "\n";
}