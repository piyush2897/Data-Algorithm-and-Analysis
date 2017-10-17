#include<stdio.h>
#include<limits.h>
int min(int a, int b)
{
    if(a<b)
    return a;
    return b;
}
int matrixMul(int p[],int i, int j)
{
    int k=i,q=INT_MAX;
    if(i==j)
        return 0;
    for(k=i;k<j;k++)
    {
        q=min(q,matrixMul(p,i,k)+matrixMul(p,k+1,j)+p[i-1]*p[k]*p[j]);
    }
    return q;
}
int main()
{
    int n,arr[1000][1000],i,p[1000];
    printf("Enter the Number of Matrices\n");
    scanf("%d",&n);

    printf("Enter The matrices Sizes in form of Array\n");
    for(i=0;i<=n;i++)
    {
        scanf("%d",&p[i]);
    }

    int val= matrixMul(p,1,n);

    printf("Minimum Cost Of multiplying the Matrices = %d",val);
    return ;
}
