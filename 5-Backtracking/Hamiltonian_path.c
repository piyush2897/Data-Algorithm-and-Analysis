#include<stdio.h>
int compatible(int G[][100], int path[],int i, int val)
{
	if(G[path[val-1]][i]==0)
	{
		//printf(" : %d-%d : ",path[val],i);
		return 0;
	}
	for(int j=0;j< val;j++)
	{
		if(path[j]==i)
			return 0;
	}
	return 1;
}
int print_path(int G[][100],int  path[],int val,int n)
{
	if(val==n)
	{
		return 1;
	}
	for(int i=1;i<n;i++)
	{
		if(compatible(G,path,i,val)==1)
		{
			path[val]=i;
			if(print_path(G,path,val+1,n)==1)
			{
				return 1;
			}
			path[val]=-1;
		}
	}
	return 0;
}
int main()
{
	int n,a,k=0;
	int path[100];
	int G[100][100];
	printf("Enter The Number Of nodes\n");
	scanf("%d",&n);
	printf("Enter The Matrix Of Graph\n");

	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			scanf("%d",&a);
			G[i][j]=a;
		}
	}
	for(int i=0;i<100;i++)
	{
		path[i]=-1;
	}
	path[0]=0;
	if(print_path(G,path,1,n)==1)
	{
		k=0;
		printf("The Hamiltonian Path is\n");
		while(path[k]!=-1)
		{
			printf("%d ",path[k]);
			k++;
		}
	}
	else
	{
		printf("No Hamiltonian Path Exists\n");
	}
	//printf("\n%d \n ",k);
	return 0;
}