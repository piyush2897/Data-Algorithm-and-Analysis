#include<stdio.h>
void print(int arr[][100],int n)
{
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
	printf("\n");
}
int safeSeq(int arr[][100],int k,int j,int n)
{
	int i;
	for(i=0;i<k;i++)
	{
		if(arr[i][j]==1)
			return 0;
	}
	for(i=0;i<j;i++)
	{
		if(arr[k][i]==1)
			return 0;
	}
	i=0;
    while((k-i)>=0 && (j-i)>=0)
    {
        if(arr[k-i][j-i]==1)
        return 0;
        i++;
    }
    i=0;
    while((k-i)>=0 && (j+i)<n)
    {
        if(arr[k-i][j+i]==1)
        return 0;
        i++;
    }
    return 1;
}
int nQueen(int arr[][100],int k,int n)
{
	int i;
	if(k==n)
	{
		print(arr,n);
		return 0;
	}
	for(i=0;i<n;i++)
	{
		int s=safeSeq(arr,k,i,n);
		if( s==1 )
		{
			arr[k][i]=1;
			int next=nQueen(arr,k+1,n);
			if(next==1)
			{
				return 1;
			}
			arr[k][i]=0;
		}
	}
	return 0;
}
int main()
{
	int n,arr[100][100];
	int i,j;
	printf("Enter The Order Of Chess Board\n");
	scanf("%d",&n);
	for(i=0;i<n;i++)
	{
		for(j=0;j<n;j++)
		{
			arr[i][j]=0;
		}
	}
	nQueen(arr,0,n);
	return 0;
}