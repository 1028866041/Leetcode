#include "tank.h"
#include <iostream>
using namespace std;

int Tank::count=0;
Tank::Tank(char c)
{
    code= c;
    count++;
    cout<<"tank"<<endl;
}

Tank::~Tank()
{
    count--;
    cout<<"~tank"<<endl;
}

void Tank::fire()
{
    getCount();
    cout<<"fire"<<endl;
}

int Tank::getCount()
{
    return count;
}
