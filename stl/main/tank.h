#include <iostream>
#pragma once
using namespace std;

class Tank
{
public:
    Tank(char c);
    ~Tank();
    void fire();
    static int getCount();
private:
    static int count;
    char code;
};
