/*
Problem 2 – Dexter plus the Matrix
Dexter is a super genius child but unfortunately he has to study with all the "normal" kids in his school.
Sometimes he gets bored and starts solving his own puzzles.
Today his teacher has given the class an assignment.
She gave a matrix of N rows and M columns. Each cell of the matrix has a character which can either be 'a' or
'b'.
The teacher told the students to highlight some cells of the matrix in such a way that all the highlighted cells
together form a plus sign.
The plus should be made of more than one character. Its center should be at some cell on the matrix and its
four arms should extend equally into four directions (top, bottom, left and right), parallel to the sides of the
matrix.
A proper plus should contain only one type of character ( 'a' or 'b' ). But the teacher is lenient. She will accept
any plus such that all, except at most one, characters of the plus are the same ( In other words, if the number
of characters in the plus is x, then at least x-1 of them should be same ).
Example 1:
If the matrix is
a a a
a a a
a a a
then one way of making a plus by highlighting is,
a a a
a a a
a a a
( Bold letters denote the plus )
Example 2:
If the matrix is
a a a
a a b
a a a

then one way of making a plus is,
a a a
a a b
a a a
As only one character of the plus is different, the teacher will accept it.
Dexter, being the arrogant child he is, decides to prove his superiority by finding the number of
distinct pluses he can make on the given matrix that will be accepted by the teacher.
Note that, two pluses are different if they have a different center or they have a different arm length.
Input:
The first line contains a number T, the number of test cases.
The first line of each test case contains N and M.
Each of the next N lines contains M characters, i.e. the matrix.
Output:
For each test case, output the number of distinct "plus" that can be drawn on the matrix.
Constraints:
1 <= T <= 10
1 <= N , M <= 1000
All characters of the matrix are either 'a' or 'b'.
Explanation of Sample Test Case:
For the first two sample test cases, the only way to highlight the cells to form a plus is the one shown in the
problem statement.
For the third one, the following ways are possible:
a a a a
a a a a
a a a a
a a a a
a a a a
a a a a
a a a a
a a a a

a a a a
a a a a
a a a a
a a a a
a a a a
a a a a
a a a a
a a a a
Sample Input
3
3 3
aaa
aaa
aaa
3 3
aaa
aab
aaa
4 4
aaaa
aaaa
aaaa
aaaa
Sample Output
1
1
4
*/

    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.Scanner;
     
    class DexterPlusTheMatrix10 {
    void solve(Scanner sc)
    {
    int N=sc.nextInt();
    int M=sc.nextInt();
    String array[]=new String[N];
    int result=0;
    int rowAF[][]=new int[N][M];
    int rowAB[][]=new int[N][M];
    int columnAD[][]=new int[N][M];
    int columnAU[][]=new int[N][M];
    int rowBF[][]=new int[N][M];
    int rowBB[][]=new int[N][M];
    int columnBD[][]=new int[N][M];
    int columnBU[][]=new int[N][M];
    int frontA[]=new int[N];
    int backA[]=new int[N];
    int downA[]=new int[M];
    int upA[]=new int[M];
    int frontB[]=new int[N];
    int backB[]=new int[N];
    int downB[]=new int[M];
    int upB[]=new int[M];
    Arrays.fill(frontA, -1);
    Arrays.fill(backA, -1);
    Arrays.fill(downA, -1);
    Arrays.fill(upA, -1);
    Arrays.fill(frontB, -1);
    Arrays.fill(backB, -1);
    Arrays.fill(downB, -1);
    Arrays.fill(upB, -1);
    for(int i=0;i<N;i++)
    {
    array[i]=sc.next();
    }
    for(int i=0;i<N;i++)
    {
    for(int j=0;j<M;j++)
    {	
    int min=Math.min(Math.min(i, j),Math.min(N-1-i, M-1-j));
    //a
    rowAF[i][j]=Math.min(min+1, j-frontA[i]);
    rowBF[i][j]=Math.min(min+1, j-frontB[i]);
    columnAD[i][j]=Math.min(min+1, i-downA[j]);
    columnBD[i][j]=Math.min(min+1, i-downB[j]);
    rowAB[N-1-i][M-1-j]=Math.min(min+1, j-backA[i]);
    rowBB[N-1-i][M-1-j]=Math.min(min+1, j-backB[i]);
    columnAU[N-1-i][M-1-j]=Math.min(min+1, i-upA[j]);
    columnBU[N-1-i][M-1-j]=Math.min(min+1, i-upB[j]);
    if(array[i].charAt(j)=='b')
    {
    frontA[i]=j;
    downA[j]=i;
    }
    else
    {
    frontB[i]=j;
    downB[j]=i;
    }
    if(array[N-1-i].charAt(M-1-j)=='b')
    {
    backA[i]=j;
    upA[j]=i;
    }
    else
    {
    backB[i]=j;
    upB[j]=i;
    }
    }
    }
    int min1=0;
    int min2=0;
    int next=0;
    //Result
    for(int i=1;i<N-1;i++)
    {
    for(int j=1;j<M-1;j++)
    {
    //a
    if(rowAB[i][j]>rowAF[i][j])
    {
    min1=rowAF[i][j];
    min2=rowAB[i][j];
    //next=rowAF[i][j-min1];
    next=1;
    }
    else
    {
    min1=rowAB[i][j];
    min2=rowAF[i][j];
    //next=rowAB[i][j+min1];
    next=2;
    }
    if(columnAD[i][j]<min1)
    {
    min2=min1;
    min1=columnAD[i][j];
    //next=columnAD[i-min1][j];
    next=3;
    }
    else if(columnAD[i][j]<min2)
    {
    min2=columnAD[i][j];
    }
    if(columnAU[i][j]<min1)
    {
    min2=min1;
    min1=columnAU[i][j];
    //next=columnAU[i+min1][j];
    next=4;
    }
    else if(columnAU[i][j]<min2)
    {
    min2=columnAU[i][j];
    }
    if(array[i].charAt(j)=='b')
    {
    result+=min1-1;
    }
    else
    {
    if(min1!=min2)
    {
    /*if(next==1)
    {
    next=rowAF[i][j-min1];
    }
    else if(next==2)
    {
    next=rowAB[i][j+min1];
    }
    else if(next==3)
    {
    next=columnAD[i-min1][j];
    }
    else
    {
    next=columnAU[i+min1][j];
    }*/
    next=Math.min(Math.min(rowAF[i][j-min1],rowAB[i][j+min1]),Math.min(columnAD[i-min1][j],columnAU[i+min1][j]));
    result+=min1+next-1;
    }
    else
    {
    result+=min1-1;
    }
    }
    //b
    if(rowBB[i][j]>rowBF[i][j])
    {
    min1=rowBF[i][j];
    min2=rowBB[i][j];
    //next=rowBF[i][j-min1];
    next=1;
    }
    else
    {
    min1=rowBB[i][j];
    min2=rowBF[i][j];
    //next=rowBB[i][j+min1];
    next=2;
    }
    if(columnBD[i][j]<min1)
    {
    min2=min1;
    min1=columnBD[i][j];
    //next=columnBD[i-min1][j];
    next=3;
    }
    else if(columnBD[i][j]<min2)
    {
    min2=columnBD[i][j];
    }
    if(columnBU[i][j]<min1)
    {
    min2=min1;
    min1=columnBU[i][j];
    //next=columnBU[i+min1][j];
    next=4;
    }
    else if(columnBU[i][j]<min2)
    {
    min2=columnBU[i][j];
    }
    if(array[i].charAt(j)=='a')
    {
    result+=min1-1;
    }
    else
    {
    if(min1!=min2)
    {
    /*if(next==1)
    {
    next=rowBF[i][j-min1];
    }
    else if(next==2)
    {
    next=rowBB[i][j+min1];
    }
    else if(next==3)
    {
    next=columnBD[i-min1][j];
    }
    else
    {
    next=columnBU[i+min1][j];
    }*/
    next=Math.min(Math.min(rowBF[i][j-min1],rowBB[i][j+min1]),Math.min(columnBD[i-min1][j],columnBU[i+min1][j]));
    result+=min1+next-1;
    }
    else
    {
    result+=min1-1;
    }
    }
    //System.out.println();
    //System.out.println("i:"+i+" j:"+j);
    //System.out.println("result"+result);
    }
    }
    System.out.println(result);
    /*//FrontA
    System.out.println();
    System.out.println("FrontA");
    for(int i=0;i<N;i++)
    {
    for(int j=0;j<M;j++)
    {
    System.out.print(rowAF[i][j]+" ");
    }
    System.out.println();
    }
    //BackA
    System.out.println();
    System.out.println("BackA");
    for(int i=0;i<N;i++)
    {
    for(int j=0;j<M;j++)
    {
    System.out.print(rowAB[i][j]+" ");
    }
    System.out.println();
    }
    //DownA
    System.out.println();
    System.out.println("DownA");
    for(int i=0;i<N;i++)
    {
    for(int j=0;j<M;j++)
    {
    System.out.print(columnAD[i][j]+" ");
    }
    System.out.println();
    }
    //UpA
    System.out.println();
    System.out.println("UpA");
    for(int i=0;i<N;i++)
    {
    for(int j=0;j<M;j++)
    {
    System.out.print(columnAU[i][j]+" ");
    }
    System.out.println();
    }*/
    }
     
    public static void main(String[] args)
    {
    Scanner sc=new Scanner(new InputStreamReader(System.in) );
    int testCase=sc.nextInt();
    for(int i=1;i<=testCase;i++)
    {
    new DexterPlusTheMatrix10().solve(sc);
    }
    }
     
    }

