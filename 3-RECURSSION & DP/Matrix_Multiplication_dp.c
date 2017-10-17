#include<stdio.h>
#include<limits.h>
int min(int a, int b)
{
    if(a<b)
    return a;
    return b;
}
void print(int s[][1000],int i,int j)
{
    if(i==j)
        printf("A");
    else
    {
        printf("(");
        print(s,i,s[i][j]);
        print(s,s[i][j]+1,j);
        printf(")");
    }
}
int matrixMul(int p[],int st[][1000],int s, int n)
{
    int m[100][100];
    int l,i,j,q,k;
    for(i=1;i<=n;i++)
    {
        m[i][i]=0;
    }
    for(l=2; l<=n; l++)
    {
        for(i=1;i<=n-l+1;i++)
        {
            j= i+l-1;
            m[i][j] = INT_MAX;
            q=INT_MAX;
            for(k=i;k<=j-1;k++)
            {
                q=m[i][k]+m[k+1][j]+p[i-1]*p[k]*p[j];
                if(q<m[i][j])
                {
                    m[i][j]=q;
                    st[i][j]=k;
                }
            }
        }
    }
    print(st,1,n);
    printf("\n");
    return m[1][n];

}
int main()
{
    int n,arr[1000][1000],i,p[1000];
    int st[1000][1000];
    printf("Enter the Number of Matrices\n");
    scanf("%d",&n);

    printf("Enter The matrices Sizes in form of Array\n");
    for(i=0;i<=n;i++)
    {
        scanf("%d",&p[i]);
    }

    int val=0;
    val= matrixMul(p,st,1,n);

    printf("Minimum Cost Of multiplying the Matrices = %d \n",val);
    return ;
}
