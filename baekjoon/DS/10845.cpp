#include <iostream>

using namespace std;

struct Node {
    int value;
    Node * next;
};

class Queue {
private:    
    int size;
    Node * head;
    Node * tail;

public:
    Queue(){
        size = 0;
        head = nullptr;
        tail = nullptr;
    }

    void push(int value){
        if(size == 0){
            Node * newNode = new Node;
            newNode ->value = value;

            head = newNode;
            tail = newNode;
            size++;
        }else{
            Node * newNode = new Node;
            newNode ->value = value;

            tail -> next = newNode;
            tail = tail->next;
            size++;
        }
    }

    void pop(){
        if(size==0){
            cout << "-1\n";
        }else{
            cout << head->value << '\n';
            if(size == 1){
                tail = nullptr;
                head = nullptr;
                size--;
                return;
            }
            head = head->next;

            size--;
        }
    }

    void getSize(){
        cout << size << '\n';
    }

    void empty(){
        if(size==0){
            cout << "1\n";
        }else{
            cout << "0\n";
        }
    }

    void front(){
        if(size == 0){
            cout << "-1\n";
        }else{
            cout << head -> value << "\n";
        }
    }

    void back(){
        if(size==0){
            cout << "-1\n";
        }else{
            cout << tail -> value << "\n";
        }
    }
};

int main(void){
    int N;
    cin >> N;

    Queue * queue = new Queue();
    
    for(int i=0; i<N; i++){
        string command;
        cin >> command;

        if(command == "push"){
            int X;
            cin >> X;
            queue->push(X);
        }else if(command == "pop"){
            queue->pop();
        }else if(command == "size"){
            queue->getSize();
        }else if(command == "empty"){
            queue->empty();
        }else if(command == "front"){
            queue->front();
        }else if (command =="back"){
            queue->back();
        }
    }
}