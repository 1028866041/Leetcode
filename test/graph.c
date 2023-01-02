#include<stdio.h>
#include<stdbool.h>

#define MAX 10

typedef struct Graphs{
    char vex[MAX];
    int arc[MAX][MAX];
    int vert;
    int edge;
    int type;
}Graph;

typedef struct Queues{
    int data[MAX];
    int *head;
    int *tail;
    int size;
}Queue;

bool visited[MAX];

void dfs(Graph *g, int i)
{
    int j;

    visited[i]= true;
    printf("%c ", g->vex[i]);
    for(j=0;j<g->vert;j++)
    {
        if(g->arc[i][j]!=-1&& !visited[j])
            dfs(g,j);
    }
}

int enqueue(Queue *q, int data)
{
    if(q->size==MAX)
        return -1;
    
    q->tail++;
    q->size++;
    q->size%=MAX;
    q->data[q->size]=data;
    return 0;    
}

int dequeue(Queue *q, int *data)
{
    if(q->size==0)
        return -1;

    q->head++;
    data=&(q->data[q->size-1]);
    q->size--;
    return 0;
}
 
void bfs(Graph *g)
{
    int i;
    
    Queue *q=(Queue *)malloc(sizeof(Queue));
    for(i=0;i<g->vert;i++)
        visited[i]=false;
    
    for(i=0;i<g->vert;i++)
    {
        visited[i]=true;
        printf("%c", g->vex[i]);
        enqueue(q, i);

        while(q->size!=0)
        {
            dequeue(q, &i); //neighbour
            if(!visited[g->vert])
            {
                visited[g->vert]= true;
                printf("%c ", g->vex[i]);
            }
        }
    }
}

void print(Graph *g)
{
    int i,j,count=0;

    for(i=0;i<g->vert;i++)
        printf("%c ", g->vex[i]);

    printf("\n");
    for(i=0;i<g->vert;i++)
    {
        for(j=0;j<g->vert;j++)
        {
            printf("%d ", g->arc[i][j]);
            count++;
            if(count%g->vert)
                printf("\n");
        }
    }    
}

void create(Graph *g)
{
    int i,j,k,w;
    
    scanf("%d%d", &g->vert, &g->edge);
    getchar();
    
    for(i=0;i<g->vert;i++)
    {
       scanf("%c", &g->vex[i]);
       getchar();    
    }
    
    for(i=0;i<g->vert;i++)
        for(j=0;j<g->vert;j++)
            g->arc[i][j]=-1;

    for(k=0;k<g->edge;k++)
    {
        scanf("%d%d%d", &i, &j, &w);
        g->arc[i][j]= w;
        if(!g->type)
        {
            g->arc[j][i]=g->arc[i][j];
        }
    }
}

int main()
{
    Graph g;

    create(&g);
    print(&g);
    dfs(&g, 0);
    bfs(&g);

    return 0;
}
