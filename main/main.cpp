#include"tank.h"
#include"ptr.h"
#include<iostream>
#include<limits>
#include<string>
using namespace std;

extern int conts();
extern int rb_trees();
extern int memory();
extern int file_handle();

int main(int argc, char **argv)
{
    cout<<__cplusplus<<endl;
    conts();
    //allocators();
    rb_trees();
    memory();
    file_handle();

    unique_ptr<int> p(new int(1));
    cout<<p<<" ";
    cout<<numeric_limits<string>::is_specialized<<endl;
    //system("pause");
    return 0;
}
