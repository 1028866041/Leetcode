#include<stdio.h>

#define RED 0
#define BLACK 1

typedef struct Nodes{
    char color;
    int key;
    struct Nodes *parent;    
    struct Nodes *left;
    struct Nodes *right;
}Node;

typedef struct Roots{
    Node *node;
}Root;

void rotate_left(Root *root, Node *x)
{
    Node *y= x->right;
    
    x->right = y->left;
    if(y->left!= NULL)
        y->left->parent= x;
    
    y->parent= x->parent;
    if(x->parent!= NULL)
    {
        if(x->parent->left= x)
        {
            x->parent->left = y; 
        }else{
            x->parent->right= y;    
        }
    }else{
        root->node= y;
    }

    y->left= x;
    x->parent= y;
} 

void rotate_right(Root *root, Node *y)
{
    Node *x= y->left;    

    y->left= x->right;
    x->right->parent= y;

    x->parent= y->parent;
    if(y->parent!= NULL)
    {
        if(y->parent->left== y)
        {
            y->parent->left= x;
        }else{
            y->parent->left= y;
        }
    }else{
        root->node= y; 
    }
    
    x->right= y;
    y->parent= x;
}

void insert_fix(Root *root, Node *node);
void insert(Root *root, Node *node)
{
    Node *y= NULL;
    Node *x= root->node;

    while(x!= NULL)
    {
        y= x;
        if(node->key< y->key)
        {
            x= x->left;
        }
        else
        {
            x= x->right;
        }    
    }
    node->parent = y;

    if(y!= NULL)
    {
        if(node->key< y->key)
        {
            y->left= node;
        }else{
            y->right= node;
        }       
    }else{
        root->node = node;
    }

    node->color= RED;
    insert_fix(root, node);
}

void insert_fix(Root *root, Node *node)
{
    Node *parent, *gparent, *uncle, *tmp;

    while((parent= node->parent)&& (parent->color==RED))
    {
        gparent= parent->parent;

        if(parent==gparent->left)
        {
            uncle= gparent->right;
            if(uncle&& uncle->color== RED)
            {
                uncle->color= BLACK;
                parent->color= BLACK;
                gparent->color= RED;
                continue;        
            }
            
            if(parent->right== node)
            {
                rotate_left(root, parent);
                tmp= parent;
                parent= node;
                node= parent;
            }else{
                rotate_right(root, parent);
                tmp= parent;
                parent= node;
                node= parent;
            }
        }else{
            uncle= gparent->left;
            if(uncle&& uncle->color== RED)
            {
                uncle->color= BLACK;
                parent->color= BLACK;
                gparent->color= RED;
            }
    
            if(parent->left== node)
            {
                rotate_right(root, node);   
                tmp= parent;
                parent= node;
                node= tmp;     
            }else{
                rotate_left(root, node);
                tmp= parent;
                parent= node;
                node= tmp;            
            }  
        }
    }
    root->node->color= BLACK;
}

void delete_fix(Root *root, Node *child, Node *parent);
void delete(Root *root, Node *node)
{
    Node *child=NULL, *parent, *replace, *tmp;
    int color;

    if((node->left!= NULL)&& (node->right!=NULL))
    {
        replace= node->right;
        while(replace->left!= NULL)
        {
            replace= replace->left;
        }
        
        if(node->parent!= NULL)
        {
            if(node->parent->left== node)
            {
                node->parent->left= replace;
            }else{
                node->parent->right= replace;
            }
        }else{
            root->node= replace; 
        }
    
        child= replace->right;
        parent= replace->parent;
        if(parent== node)
        {
            parent= replace; //replace node
        }else{
            if(child)
            {
                child->parent= parent;
            }
            parent->left= child;
            replace->right= node->right;
            node->right->parent= replace;
        } 
        
        replace->parent= node->parent;
        replace->color= node->color;
        replace->left= node->left;
        node->left->parent= replace;
        
        if(color== BLACK)
            free(node);
        node= NULL;        
        return;  
    }

    if(node->left!= NULL)
    {
        child= node->left;
    }
    if(node->right!= NULL)
    {
        child= node->right;    
    }

    parent= node->parent;
    color= node->color;
    if(child)
    {
        child->parent= parent;
    }
    
    if(parent)
    {
        if(parent->left== node)
        {
            parent->left= child;
        }else{
            parent->right= child;
        }
    }else{
        root->node= child;
    }  

    if(color== BLACK)
    {
        delete_fix(root, child, parent);
    }
    free(node);
    node= NULL;
}

void delete_fix(Root *root, Node *node, Node *parent)
{
    Node *other;

    while((!node || node->color== BLACK) && node!= root->node)
    {
        if(parent->left== node)
        {
            other= parent->right;
            if(other->color== RED)
            {
                    
            }else{
            
            }
                
        }else{
            if()
            {
            
            }else{
            
            
            }
                
        }
    }
     
    if(node)
    {
        node->color= BLACK;
    }
}

Root* create()
{
    Root *root= (Root *)malloc(sizeof(Root));
    root->node= NULL;

    return root;
}

Node* create_node(int key, Node *parent, Node *left, Node *right)
{
    Node *p;
    p= (Node *)malloc(sizeof(Node));
    if(p==NULL)
        return NULL;
    p->key= key;
    p->parent= parent;
    p->left= left;
    p->right= right;
    
    return p;
}

void *destroy(Root *root)
{
    if(root!= NULL)
        free(root);
    root= NULL;
}

void preorder(Node *root)
{
   if(root!= NULL)
   {
        printf("%d ", root->key);
        preorder(root->left);
        preorder(root->right);
   } 
}

void inorder(Node *root)
{
    if(root!= NULL)
    {
        inorder(root->left);
        printf("%d ", root->key);
        inorder(root->right);
    }
}

void postorder(Node *root)
{
    if(root!= NULL)
    {
        postorder(root->left);
        postorder(root->right);
        printf("%d ", root->key);
    }
}

Node* search(Node *root, int key)
{
    if(root==NULL|| root->key==key)
        return root;
    
    if(key< root->key)
    {
        return search(root->left, key);
    }else{
        return search(root->right, key);
    }
}

int min(Node *root)
{
    Node *x= root, *y;
    
    if(root->left==NULL)
        return root->key;
    y= root->left;
    while(x)
    {
        y=x;
        x=x->left;
    }
    return y->key;
}

int max(Node *root)
{
   Node *x= root, *y;
  
   if(root->right==NULL)
       return root->key;
   y= root->right;
   while(x)
   {
        y=x;
        x=x->right;
   }
   return y->key;
}

int main(int argc, char *argv[])
{
    int a[10]= {10, 40, 30, 60, 90, 70, 20, 50, 80};
    int i, len= sizeof(a)/sizeof(int);
    Root *root= NULL;
    Node *node= NULL;

    for(i=0;i<len;i++)
    {
        printf("%d ", a[i]);
    }

    root= create();
    for(i=0;i<len;i++)
    {
       node=create_node(a[i],NULL,NULL,NULL); 
       insert(root, node);     
    }

    preorder(root->node);
    inorder(root->node);
    postorder(root->node);
    search(root->node, a[len]);
         
    printf("\n%d %d", min(root->node), max(root->node));

    for(i=0;i<len;i++)
    {
        delete(root, search(root->node, a[i]));
    }
    
    destroy(root);
    return 0;
}
