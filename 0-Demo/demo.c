#include<stdio.h>
 
// Number of vertices in the graph
#define V 5
 
void printSolution(int path[]);
 
/* A utility function to check if the vertex v can be added at
   index 'pos' in the Hamiltonian Cycle constructed so far (stored
   in 'path[]') */
bool isSafe(int v, bool graph[V][V], int path[], int pos)
{
    /* Check if this vertex is an adjacent vertex of the previously
       added vertex. */
    if (graph [ path[pos-1] ][ v ] == 0)
        return false;
 
    /* Check if the vertex has already been included.
      This step can be optimized by creating an array of size V */
    for (int i = 0; i < pos; i++)
        if (path[i] == v)
            return false;
 
    return true;
}
 
/* A recursive utility function to solve hamiltonian cycle problem */
bool hamCycleUtil(bool graph[V][V], int path[], int pos)
{
    /* base case: If all vertices are included in Hamiltonian Cycle */
    if (pos == V)
    {
        // And if there is an edge from the last included vertex to the
        // first vertex
        if ( graph[ path[pos-1] ][ path[0] ] == 1 )
           return true;
        else
          return false;
    }
 
    // Try different vertices as a next candidate in Hamiltonian Cycle.
    // We don't try for 0 as we included 0 as starting point in in hamCycle()
    for (int v = 1; v < V; v++)
    {
        /* Check if this vertex can be added to Hamiltonian Cycle */
        if (isSafe(v, graph, path, pos))
        {
            path[pos] = v;
 
            /* recur to construct rest of the path */
            if (hamCycleUtil (graph, path, pos+1) == true)
                return true;
 
            /* If adding vertex v doesn't lead to a solution,
               then remove it */
            path[pos] = -1;
        }
    }
 
    /* If no vertex can be added to Hamiltonian Cycle constructed so far,
       then return false */
    return false;
}
 
/* This function solves the Hamiltonian Cycle problem using Backtracking.
  It mainly uses hamCycleUtil() to solve the problem. It returns false
  if there is no Hamiltonian Cycle possible, otherwise return true and
  prints the path. Please note that there may be more than one solutions,
  this function prints one of the feasible solutions. */
bool hamCycle(bool graph[V][V])
{
    int *path = new int[V];
    for (int i = 0; i < V; i++)
        path[i] = -1;
 
    /* Let us put vertex 0 as the first vertex in the path. If there is
       a Hamiltonian Cycle, then the path can be started from any point
       of the cycle as the graph is undirected */
    path[0] = 0;
    if ( hamCycleUtil(graph, path, 1) == false )
    {
        printf("\nSolution does not exist");
        return false;
    }
 
    printSolution(path);
    return true;
}
 
/* A utility function to print solution */
void printSolution(int path[])
{
    printf ("Solution Exists:"
            " Following is one Hamiltonian Cycle \n");
    for (int i = 0; i < V; i++)
        printf(" %d ", path[i]);
 
    // Let us print the first vertex again to show the complete cycle
    printf(" %d ", path[0]);
    printf("\n");
}
 
// driver program to test above function
int main()
{
   /* Let us create the following graph
      (0)--(1)--(2)
       |   / \   |
       |  /   \  |
       | /     \ |
      (3)-------(4)    */
   bool graph1[V][V] = {{0, 1, 0, 1, 0},
                      {1, 0, 1, 1, 1},
                      {0, 1, 0, 0, 1},
                      {1, 1, 0, 0, 1},
                      {0, 1, 1, 1, 0},
                     };
 
    // Print the solution
    hamCycle(graph1);
 
   /* Let us create the following graph
      (0)--(1)--(2)
       |   / \   |
       |  /   \  |
       | /     \ |
      (3)       (4)    */
    bool graph2[V][V] = {{0, 1, 0, 1, 0},
                      {1, 0, 1, 1, 1},
                      {0, 1, 0, 0, 1},
                      {1, 1, 0, 0, 0},
                      {0, 1, 1, 0, 0},
                     };
 
    // Print the solution
    hamCycle(graph2);
 
    return 0;
}#include<stdio.h>
#include<malloc.h>
#include<string.h>

char* append(char* str,char c)
{
	int size=strlen(str);
	str[size]=c;
	str[size+1]='\0';
	return str;
}
typedef struct movie
{
	int freq;
	union node
	{
		struct intNode
		{
			struct movie* left;
			struct movie* right;
		} intNode;
		char name;
	} node;
	bool flag;
} movie;
void swap(movie* a,movie* b)
{
	movie temp;
	temp=*a;
	*a=*b;
	*b=temp;
}
void heapify(movie** arr,int i,int n)
{
	int left=2*i;
	int right=2*i+1;
	int minimum = i;
	if(left<=n&&arr[minimum]->freq>arr[left]->freq)
		minimum=left;
	if(right<=n&&arr[minimum]->freq>arr[right]->freq)
		minimum=right;
	if(minimum!=i)
	{
		swap(arr[minimum],arr[i]);
		heapify(arr,minimum,n);
	}
}
movie* ExtractMin(movie** arr,int* n)
{
	swap(arr[1],arr[*n]);
	// printf("Swapped value is %d as arr[1] and %d as arr[*n]",arr[1]->freq,arr[*n]->freq);
	(*n)--;
	heapify(arr,1,*n);
	// printf("Return  Value is %d \n",arr[*n+1]->freq);
	return arr[*n+1];
}
void buildHeap(movie** arr,int n)
{
	for(int i=n/2;i>=1;i--)
	{
		heapify(arr,i,n);
	}
}
movie* newIntNode(int freq)
{
	movie *temp=(movie *)malloc(sizeof(movie));
	temp->freq=freq;
	temp->node.intNode.left=NULL;
	temp->node.intNode.right=NULL;
	temp->flag=true;
	return temp;
}
void percolateUp(movie** arr,int k)
{
	int parent=k/2;
	// printf("value of node and parent is %d %d \n",arr[k]->freq,arr[parent]->freq);
	while(parent>=1&&arr[parent]->freq>arr[k]->freq)
	{
		// printf("Mai b hu \n");
		swap(arr[parent],arr[k]);
		k=parent;
		parent=k/2;
		// printf("inside while loop value of node and parent is %d %d \n",arr[k]->freq,arr[parent]->freq);
	}
	// printf("Here i am \n");
}
void insertIntoHeap(movie** arr,movie* m,int* k)
{
	(*k)++;
	arr[*k]=m;
	percolateUp(arr,*k);
}
void inorder(movie* node,char *str)
{
	// printf("hehe \n");
	if(node==NULL)
		return;
	movie* temp=node;
	if(temp->flag==false)
	{
		printf("Code for Movie %c  is %s \n",temp->node.name,str);
	}
	else
	{
		char str1[100],str2[100];
		int len=strlen(str);
		strcpy(str1,str);
		str1[len]='\0';
		strcpy(str2,str);
		str2[len]='\0';
		inorder(temp->node.intNode.left,append(str1,'0'));
		inorder(temp->node.intNode.right,append(str2,'1'));
	}
}
int main()
{
	int n,i,j;
	printf("Enter the number of movies \n");
	scanf("%d",&n);
	movie** arr;
	arr=(movie **)malloc(sizeof(movie *) * (n+1));
	for(int i=1;i<=n;i++)
	{
		arr[i]=(movie *)malloc(sizeof(movie));
	}
	printf("Enter the name of each movie \n");
	for(i=1;i<=n;i++)
	{
		scanf(" %c",&(arr[i]->node.name)); //Error here
		arr[i]->flag=false;
		// printf(" %c",(arr[i]->node.name));
	}
	printf("Enter the number of likes on each movie \n");
	for(j=1;j<=n;j++)
	{
		scanf("%d",&(arr[j]->freq)); // error here also
	}
	buildHeap(arr,n);
	int k=n;
	// printf("hello %d\n",ExtractMin(arr,&n)->freq);
	// for(int i=1;i<=n;i++)
	// {
	// 	printf("%d \n",ExtractMin(arr,&k)->freq);
	// }
	while(k>1)
	{
		// printf("Hello \n");
		for(int i=1;i<=k;i++)
		{
			printf("%d ",arr[i]->freq);
		}
		printf("\n");
		movie* m1=ExtractMin(arr,&k);
		movie* m2=ExtractMin(arr,&k);
		int freqSum=m1->freq+m2->freq;
		movie* m3=newIntNode(freqSum);
		// printf("hello ji kive\n");
		if(m1->freq>m2->freq)
		{
			m3->node.intNode.left=m2;
			m3->node.intNode.right=m1;
		}
		else
		{
			m3->node.intNode.left=m1;
			m3->node.intNode.right=m2;
		}
		if(k!=0)
			insertIntoHeap(arr,m3,&k);
		else
		{
			k++;
			arr[k]=m3;
		}
	}
	// printf("result is %d\n",arr[1]->freq);
	char* str;
	str=(char *)malloc(sizeof(char)*100);
	movie* temp=arr[1];
	inorder(temp,str);

	return 0;

}
