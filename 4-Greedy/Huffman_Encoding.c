#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef enum bool{true=1,false=0}bool;

typedef struct node {
    int freq;
    union internal_node
    {
        char name;
        struct inode{
            struct node* left;
            struct node* right;
        }inode;
    }internal_node;
    bool flag;
}node;

/* heap Function working */

void swap(node tree[],int a,int b)
{
    node  x;
    //printf("a ");
    x.freq=tree[a].freq;
    tree[a].freq=tree[b].freq;
    tree[b].freq=x.freq;
}
void percolateUpwards(node tree[],int k)
{
    int parent= k/2;
    while(parent>=1 && tree[parent].freq >= tree[k].freq)
    {
        swap(tree,parent,k);
        k=parent;
        parent=k/2;
    }
}

void insertIntoHeap(node tree[],node z,int *k)
{
    (*k)++;
    tree[*k]=z;
    percolateUpwards(tree,*k);
}

void heapify(node tree[],int s,int e)
{
    //printf("b ");
    int k=(s+e)/2;
    int i=s,min=s;
        if(2*i <= e && tree[2*i].freq < tree[min].freq)
        min=2*i;
        if(2*i +1 <= e && tree[2*i+1].freq < tree[min].freq )
        min=2*i+1;
        if(min!=s)
        {
            swap(tree,i,min);
            heapify(tree,min,e);
        }
    return ;
}

node Extract_min(node tree[],int* n)
{
    swap(tree,1,*n);
    (*n)--;
    heapify(tree,1,(*n));
    return tree[(*n)+1];
}

void buildHeap(node tree[],int n)
{
    for(int i=n/2;i>=1;i--)
    {
        heapify(tree,i,n);
    }
}


/* Huffmann Coding */

char* append(char *code,char c)
{
    int len=strlen(code);
    code[len]=c;
    code[len+1]='\0';
    return code;
}

node getNode(int freq)
{
    node x;
    x.freq = freq;
    x.internal_node.inode.left=NULL;
    x.internal_node.inode.right=NULL;
    x.flag=false;
    return x;
}

void printCodes(node root,char *code)
{
    if(root.flag==true)
    {
        printf(" %c = %s\n",root.internal_node.name, code);
        return ;
    }
    else
    {
        char code1[100], code2[100];

        int len=strlen(code);
        strcpy(code1,code);
        code1[len]='\0';
        strcpy(code2,code);
        code2[len]='\0';
        printCodes(*(root.internal_node.inode.left),append(code1,'0'));
        printCodes(*(root.internal_node.inode.right),append(code2,'1'));
    }
    return ;
}
void inorderTraversal(node* root)
{
        if((*root).flag==true)
        {
            printf(" %c \n",(*root).internal_node.name);
            return ;
        }
        inorderTraversal((*root).internal_node.inode.left);
        inorderTraversal((*root).internal_node.inode.right);
    return ;
}
int main()
{
    int n,i;
    int arr[1000];
    node tree[1000];
    printf("Enter the number of charters whose code is to be generated\n");
    scanf("%d",&n);
    printf("Enter the character and their frequencies\n");
    for(i=1;i<=n;i++)
    {
        getchar();
        scanf("%c",&(tree[i].internal_node.name));
        scanf("%d",&(tree[i].freq));
        tree[i].flag=true;
    }
    buildHeap(tree,n);
    int k=n;
    node z;
   while(k>1)
    {
        node x= Extract_min(tree,&k);
        node y= Extract_min(tree,&k);

        printf("%d  %d\n",x.freq,y.freq);
        int sum_freq = x.freq + y.freq;
        z = getNode(sum_freq);

        z.internal_node.inode.left = (node *)malloc(sizeof(node));
        z.internal_node.inode.right = (node *)malloc(sizeof(node));
           
            *(z.internal_node.inode.left)=x;
            *(z.internal_node.inode.right)=y;

        if(k!=0)
        {
            insertIntoHeap(tree,z,&k);
        }
        else
        {
            k++;
            tree[k]=z;
        }
    }
    printf("The tree has been Created Successfully and freq Of finally Created Node is: \n");
    //printf(" %d\n",z.freq);
    printf("The Code Of The Characters are : \n");

    char code[100];

    printCodes(z,code);

    printf("Inorder Traversal\n");
    inorderTraversal(&z);
    return 0;
}
