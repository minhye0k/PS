#include <iostream>

using namespace std;

struct Node{
    Node * next;
    int value;
};

class Stack{
    private:
        Node * head;
        int size;
    public:
        Stack(){
            size = 0;
            head = nullptr;
        }

        void getSize(){
            cout << size << '\n';
        }

        void push(int X){
            Node * newNode = new Node;
            newNode->value = X;
            newNode->next = head;
            head = newNode;
            size++;
        }

        void pop(){
            if(size==0){
                cout << "-1\n";
                return;
            }
            cout << head->value <<"\n";
            head = head->next;
            size--;
        }

        void empty(){
            if(size==0){
                cout << "1\n";
            }else{
                cout << "0\n";
            }
        }

        void top(){
            if(size==0){
                cout << "-1\n";
            }else{
                cout << head->value << '\n';
            }
        }
};

int main(void){
    Stack * stack = new Stack;
    
    int N;
    cin >> N;

    string command;
    for(int i=0; i<N; i++){
        cin >> command;
        if(command == "push"){
            int X;
            cin >> X;
            stack->push(X);
        }else if(command == "pop"){
            stack->pop();
        }else if(command == "size"){
            stack->getSize();
        }else if(command == "empty"){
            stack->empty();
        }else if(command == "top"){
            stack->top();
        }
    }


}


