#include<stdio.h>
#include<pthread.h>

int test(void *param)
{
    priintf("in thread %s\n", param);
}

int main()
{
    pthread_t thread;     
    pthred_create(&thread, 0, &test, 0);
    printf("main\");
}
