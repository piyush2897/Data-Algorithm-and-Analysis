#include<stdio.h>
int max(int a,int b)
{
    if(a>b)
    return a;
    return b;
}
void printLCS(char str1[],int r[][1000],int n,int m,int *index,char arr[])
{
    if(n==0 || m==0)
    {
        int i;
        for(i=(*index);i>=0;i--)
        printf("%c",arr[i]);
        printf("\n");
        return ;
    }
    if(r[n-1][m] == r[n][m])
    {
        printLCS(str1,r,n-1,m,index,arr);
    }
    else if(r[n][m-1] == r[n][m])
    {
        printLCS(str1,r,n,m-1,index,arr);
    }
    else if(r[n-1][m-1] == r[n][m] -1)
    {
        arr[(*index)]=str1[n-1];
        (*index)=(*index)+1;
        printLCS(str1,r,n-1,m-1,index,arr);
    }
}
int LCS(char str1[],char str2[], int n, int m)
{
    int r[1000][1000];
    char arr[1000];
    int index=0;
    int i,j;
    for(i=0;i<=n;i++)
        r[i][0]=0;
    for(i=0;i<=m;i++)
        r[0][i]=0;
    for(i=1;i<=n;i++)
    {
        for(j=1;j<=m;j++)
        {
            if(str1[i-1]==str2[j-1])
                r[i][j] = r[i-1][j-1]+1;
            else
                r[i][j] = max(r[i-1][j] , r[i][j-1]);
        }
    }
    printLCS(str1,r,n,m,&index,arr);
    return r[n][m];
}
int main()
{
    char str1[1000],str2[1000];
    int n,m;
    printf("Enter The length of 1st String\n");
    scanf("%d",&n);
    printf("Enter the first String\n");
    scanf("%s", str1);
    printf("Enter The length of 2nd String\n");
    scanf("%d",&m);
    printf("Enter the first String\n");
    scanf("%s", str2);
    int maximum=LCS(str1,str2,n,m);
    printf("Maximum Common Subsequence Length= %d",maximum);
}

