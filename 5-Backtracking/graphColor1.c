#include<stdio.h>
#include<limits.h>
int safe(int i,int k,int color[],int G[][100],int n)
{
	for(int j=0;j<n;j++)
	{
		if(G[k][j]==1)
		{
			if(i==color[j])
				return 0;
		}
	}
	return 1;
}

int graphColor(int G[][100],int m,int k,int n,int color[])
{
	//int check=0;
	if(k==n)
	{	
		int i;
		for(i=0;i<n;i++)
		{
			printf("%d ",color[i]);
		}
		printf("\n");
		return 1;
	}
	int i;

	for(i=1;i<=m;i++)
	{
		//printf("Checking for giving color %d to node %d \n",i,k);
		if(safe(i,k,color,G,n)==1)
		{
			//printf("Color %d  given to node %d \n",i,k);
			color[k]=i;
			if(graphColor(G,m,k+1,n,color)==1)
			{
				 return 1;
			}
			color[k]=0;
		}
	}
	return 0;
}


int main()
{
	printf("Enter the number of nodes in graph\n");
	int n,m,k=INT_MIN;
	scanf("%d",&n);
	printf("Enter the adjajency matrix for the graph\n");
	int G[100][100],i,j;
	int color[100];
	for(i=0;i<n;i++)
	{
		color[i]=0;
		for(j=0;j<n;j++)
		{
			scanf("%d",&G[i][j]);
		}
	}
	printf("Enter the number of colors\n");
	scanf("%d",&m);
	if(graphColor(G,m,0,n,color)==1)
	{
		for(int i=0;i<n;i++)
		{
			if(color[i]>k)
			{
				k=color[i];
			}
		}
		printf("%d colors can be used to Color the Graph \n",k);
	}
	else
	{
		printf("%d colors can not be used to Color the Graph \n",m);	
	}
}