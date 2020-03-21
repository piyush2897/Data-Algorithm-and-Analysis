#include<stdio.h>
#include<limits.h>
int max(int a,int b)
{
    if(a>b)
    return a;
    return b;
}
void rod_cut(int arr[],int n,int r[])
{
    int i,j,q;
    for(i=1;i<=n;i++)
    {
        q=INT_MIN;
        for(j=1;j<=i;j++)
        {
            q=max(q,arr[j]+r[i-j]);
        }
        r[i]=q;
    }
    return ;
}
int main()
{
    int n,p[1000],r[1000],i;
    printf("Enter The Length of Rod\n");
    scanf("%d",&n);
    printf("Enter The Cost array\n");
    for(i=1;i<=n;i++)
    {
        scanf("%d",&p[i]);
    }
    for(i=1;i<1000;i++)
    {
        r[i]=INT_MIN;
    }
    r[0]=0;
    rod_cut(p,n,r);
    printf("Maximum Cost Of Rod Cutting = %d ",r[n]);
}
