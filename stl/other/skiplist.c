#include<stdio.h>
#include<stdbool.h>

typedef struct Nodes{
    int key;
    int value;
    struct Nodes *next[];
}Node;

typedef struct skiplists{
    int level;
    Node *head;
}skiplist;

#define MAX 3

Node* create_node(int key, int val)
{
    Node *p= (Node *)malloc(sizeof(Node));
    if(!p)
        return NULL;

    p->key= key;
    p->value= val;
    return p;
}

skiplist* create()
{
    int i=0;

    skiplist *sl=(skiplist *)malloc(sizeof(skiplist));
    if(sl==NULL)
        return NULL;
    
    Node *h=create_node(0,0);
    if(h==NULL)
    {
       free(sl);
       return NULL;
    }
    sl->head= h;

    for(i=0;i<MAX;i++)
    {
        h->next[i]= NULL;
    }
    return sl;
}

int levels()
{
    int level=1;

    while(rand()%2)
    {
        level++;
    }
    level=(MAX>level)?level:MAX;
    return level;
}

bool insert(skiplist *sl, int key, int val)
{
    Node *update[MAX];
    Node *q=NULL,*p=sl->head;
    int i=sl->level-1;
    int level= levels();
    
    for(;i>=0;i--)
    {
        while((q=p->next[i])&& key>q->key)
        {
            p=q;
        }
        update[i]=p; //position
    }
    
    if(q&& q->key==key)
    {
        q->value=val;
        return true;        
    }    
    if(level> sl->level)
    {
        for(i=sl->level;i<level;i++)
        {
            update[i]= sl->head;
        }
    }
    
    q=create_node(key,val);
    if(q==NULL)
    {
        return false;
    }
    
    for(i=level-1;i>=0;i--)
    {
        q->next[i]=update[i]->next[i];
        update[i]->next[i]=q;
    }
    return true;
}

int search(skiplist *sl, int key)
{   
    Node *q=NULL,*p=sl->head;
    int i=sl->level-1;
    
    for(;i>=0;i--)
    {
        while((q=p->next[i])&& key>q->key)
        {
            p=q;
        }
        if(q&& q->key==key)
            return q->value;
    }
    return -1;
}

bool delete(skiplist *sl, int key)
{
    Node *update[MAX];
    Node *q=NULL, *p=sl->head;
    int i=sl->level-1;

    for(;i>=0;i--)
    {
        while((q=p->next[i])&& key>q->key)
        {
            p=q;
        }
        update[i]=p;
    }
    
    if(!q||(!q&&q->key!=key))
        return false;

    for(i=sl->level-1;i>=0;i--)
    {
        if(update[i]->next[i]== q)
        {
            update[i]->next[i]=q->next[i];
            if(sl->head->next[i] == NULL)
                sl->level-= 1;
        }
    }

    free(q);
    q=NULL;
    return true;
}

void destroy(skiplist *sl)
{
    Node *q=NULL,*p=sl->head;
    int i=sl->level-1;

    for(;i>=0;i--)
    {
        while(p)
        {
            q=p->next[i];
            free(p);
            p=q;
        }
    }
}

void traverse(skiplist *sl)
{
    Node *q=NULL, *p=sl->head;
    int i=sl->level-1;

    for(;i>=0;i--)
    {
        while(q=p->next[i])
        {
            printf("%d ", q->key);
            p=q;
        }
    }
}

int main(int argc, char *argv[])
{
    int i;
    skiplist *sl= create();

    for(i=1;i<20;i++)
    {
        insert(sl,i,i);
    }
   
    traverse(sl);

    for(i=1;i<20;i++)
    {
        delete(sl, i);
    }
    destroy(sl);
   
    return 0;
}
