#include <iostream>
#include <cmath>
using namespace std;

void fillBoxes(int * arrayIndex,int size,int index);

int main(void){
    int number;

    cout << "Enter Number of Pennies : ";
    cin >> number;
    
    cout<<endl;

    int size=floor((int)log2(number))+1;
    int *boxes = new int(size);
    fillBoxes(boxes,size,number);

    for(int i=0;i<size;i++){
        cout<<(int)boxes[i]<<" ";
    }
}

void fillBoxes(int * arrayIndex,int size,int number){
    if(size==0) return;

    *(arrayIndex)=number%2;
    number=number/2;
    arrayIndex++;
    size--;
    fillBoxes(arrayIndex,size,number);
}
