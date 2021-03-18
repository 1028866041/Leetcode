using namespace System;
using namespace System::threading;

void work()
{
    Console:WriteLine(L"Work thread");
}

int main()
{
    Thread^ thread= gcnew Thread(gcnew ThredaStart(&work));
    mythread->Start();
    Console:WriteLine(L"Main");
    Console:ReadKey();
    return 0;
}
