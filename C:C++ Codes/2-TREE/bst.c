
#include<stdio.h>
typedef struct node{
    int data;
    struct node *left;
    struct node *right;
}node;
void inOrder(node* root)
{
   // printf("Started InOrder\n")
    if(root==NULL)
        return ;
    inOrder(root->left);
    printf("%d ",root->data);
    inOrder(root->right);
    return ;
}
node* newNode(int value)
{
    struct node *root=(node*)malloc(sizeof(node));
    root->data=value;
    root->left=NULL;
    root->right=NULL;
    return root;
}
node* insertNode(node** root,int value)
{
    if((*root)==NULL)
    {
        (*root)=newNode(value);
        return (*root);
    }
    if(value > (*root)->data)
    {
        (*root)->right=insertNode(&(*root)->right,value);
    }
    else
    {
        (*root)->left=insertNode(&(*root)->left,value);
    }
    return *root;
}
node*  insertNode_Iterative(node* root, int value)
{
    node** ref=root;
    node** prev;
    int flag=0;
    while((root)!=NULL)
    {
        if(value > (root)->data)
        {
            prev=&root;
            root=root->right;
            flag=1;
        }
        else
        {
            prev=&root;
            root=root->left;
            flag=2;
        }
    }
    if(root==NULL)
    {
        root=newNode(value);
        if(flag==1)
        (*prev)->right=root;
        else if(flag==2)
        (*prev)->left=root;
    }
    return (*ref);
}
void createTree(node** root,int value)
{
    //printf("Create Tree started\n");
    printf("Tree Creation Initiated\n");
    if((*root)==NULL)
    {

        (*root)=newNode(value);
        //printf("%d",(*root)->data);
    }
    return ;
}
int searching(node* root,int value)
{
    if(root==NULL)
        return 0;
    if(root->data < value)
        searching(root->right,value);
    else if(root->data > value)
        searching(root->left,value);
    else
        return 1;
}
int Search_iterative(node* root,int value)
{
    if(root==NULL)
        return 0;
    while(root!=NULL)
    {
        if(root->data == value)
            return 1;
        else if(root->data < value)
            root=root->right;
        else
            root=root->left;
    }
    return 0;

}
int InOrderSuccessor(node* root,int value)
{
    if((root)==NULL)
    {
        return 0;
    }
    if((root)->left==NULL)
    {
        int p=(root)->data;
        (root)->data=value;
        return p;
    }
    InOrderSuccessor((root)->left,value);
}
int InOrderPredessor(node* root,int value)
{
    if((root)==NULL)
    {
        return 0;
    }
    if((root)->right==NULL)
    {
        int p=(root)->data;
        (root)->data=value;
        return p;
    }
    InOrderPredessor((root)->left,value);
}
node* Iterative_delete(node *root,int k)
{

}
node* delete(node * root,int value)
{
    if((root)==NULL)
        return NULL;
    if((root)->data == value)
    {
        if((root)->left==NULL && (root)->right==NULL)
        {
            //free((*root));
            return NULL;
        }
        else if((root)->left==NULL)
        {
            return (root)->right;
        }
        else if((root)->right==NULL)
        {
            return (root)->left;
        }
        else
        {
            //(root)->data=InOrderSuccessor((root)->right,value);
            (root)->data=InOrderPredessor((root)->left,value);
            //(root)->right=delete(((root)->right),value);
            (root)->left=delete(((root)->left),value);
        }
        return NULL;
    }
    else if((root)->data > value)
    {
       ((root)->left)=delete(((root)->left),value);
    }
    else
    {
       ((root)->right)=delete(((root)->right),value);
    }
    return root;
}
int main()
{
    node *root=NULL;
    int n,c=0,i,value,k;
    printf("ENTER \n1 FOR CREATION \n2 FOR INSERTION \n3 FOR INORDER TRAVERSAL \n4 SERCHING \n5 DELETION \n7 EXIT \n");
    while(1)
    {
        printf("Enter Choice\n");
        scanf("%d",&k);
        switch(k)
        {
            case 1:
                printf("Enter Root data\n");
                scanf("%d",&value);
                createTree(&root,value);
            case 2:
                printf("Enter the Number of Nodes to be inserted\n");
                    scanf("%d",&n);
                for(i=0;i<n;i++)
                {
                    scanf("%d",&value);
                    node* check=insertNode_Iterative(root,value);
                    if(check==NULL)
                    {
                        printf("Error in the insertion call");
                        break;
                    }
                }
            case 3:
                printf("Inorder Treversal\n");
                inOrder(root);
                printf("\n");
                break;
            case 4:
                printf("Enter the value to be searched\n");
                scanf("%d",&value);
                if(Search_iterative(root,value)==1)
                {
                    printf("The Node is Present\n");
                }
                else
                {
                    printf("The Node is Not Present\n");
                }
                break;
            case 5:
                printf("Enter the Node to be  deleted\n");
                scanf("%d",&k);
                root=delete(root,k);
                inOrder(root);
                printf("\n");
                break;
            case 6:
                printf("Iterative Node deletion Initiated\n");
                printf("Enter the Node to be  deleted\n");
                scanf("%d",&k);
                root=Iterative_delete(root,k);
                inOrder(root);
                printf("\n");
                break;
            case 7:
                printf("EXIT");
                return 0;
            default:
                printf("Wrong Choice: EXIT");
                return 0;

        }
    }
    return 0;
}

