#include<iostream>
#include<algorithm>
using namespace std;

int n;
int inorder[1000000];
int postorder[100000];

void setArr(int ina, int inb, int poa, int pob) {
	
	if ((ina > inb) || (poa > pob))
		return;

	cout << postorder[pob] << " ";
	int temp = find(inorder + ina, inorder + inb + 1, postorder[pob]) - (inorder + ina);
	setArr(ina, ina + temp - 1, poa, poa + temp - 1);
	setArr(ina + temp + 1, inb, poa + temp, pob - 1);

}

int main() {
	cin.tie(NULL);
	ios::sync_with_stdio(false);
	cin >> n;
	
	for (int i = 0; i < n; ++i)
		cin >> inorder[i];
	for (int i = 0; i < n; ++i)
		cin >> postorder[i];

	//인오더 처음 끝, 포스트오더 처음 끝
	setArr(0, n - 1, 0, n - 1);

	cout << '\n';

}