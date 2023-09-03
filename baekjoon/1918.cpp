#include <bits/stdc++.h>

using namespace std;

struct oper{
    char c;
    int prior;
};

int getPriority(char c){
    switch(c){
        case '*': return 2;
        case '/': return 2;
        case '+': return 1;
        case '-': return 1;
        case '(':
        case ')': return -1;
        default: return 0;
    }
}

int main(){
    string s;
    cin >> s;

    stack<oper> st;

    string ret;
    
    for(char&c : s){
        int p = getPriority(c);
        if(p==0) ret+= c;
        else{
            if(c == '(') {
                st.push({c, 0});
                continue;
            }else if(c == ')'){
                while(!st.empty() && st.top().c != '('){
                    ret += st.top().c;
                    st.pop();
                }
                st.pop();
            }else{
                while(!st.empty() && st.top().prior >= p){
                    ret += st.top().c;
                    st.pop();
                }
                st.push({c, getPriority(c)});
            }            
        }
    }

    while(!st.empty()){
        ret+=st.top().c;
        st.pop();
    }
    
    cout << ret;

    return 0;
}