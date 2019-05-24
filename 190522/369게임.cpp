#include<iostream>
#include<string>
using namespace std;
string game369(int N){
	string str;
    for(int i=1;i<=N;i++){
        string s=to_string(i);
    	if(((s.find("3")==string::npos)&&(s.find("6")==string::npos)&&(s.find("9")==string::npos))){
    		str+=s;
    		str+=" ";    
    	}else{
    		for(int j=0;j<s.size();j++){
        		if((s.at(j)=='3')||(s.at(j)=='6')||(s.at(j)=='9')){
            		str+="-";
        		}
    		}
        	str+=" ";
    	}
    }
	return str;
}
int main(){
    int n;
	cin>>n;
    cout<<game369(n)<<endl;
    return 0;
}