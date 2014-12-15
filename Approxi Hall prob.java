/*
Problem 3 – Hall Arrangement
There are 999999 students in Prof. Roy's class, so including him it makes 106 people.
Prof. Roy has arranged a movie show in college's Hall for his students.
Hall is a 1000 x 1000 matrix of seats, making a total of 106 seats, just enough for accommodating everyone of
them. Every student wants to sit as close as possible to his/her crush.
Let’s number everyone before proceeding. Prof. Roy is number 1. Rest of the students are numbered
from 2 to 1000000.
Now Prof. Roy knows his students very well. Every student has a crush on all of its multiples, means student
number 2 has crush on all the multiples of 2 i.e. 4, 6, 8, 10 ... 1000000
Similarly it goes for all other students. 3 has crush on 6, 9, 12 ... 999999 ... ... ... 4 has crush
on 8, 12, 16 ... 1000000 and so on.
One possible matrix of arrangement of students is as follows. We are considering only 3 x 3 matrix in this
example.
Now Prof. Roy is a kind person. He wants to minimize the sum S of squares of distances between every
students' crush.
For eg: sum S for above arrangement is computed as follows:
S = S2 + S3 + S4
where S2 is computed as follows:
Position of 2 in above matrix is (1,2) and his/her crushes are 4 - (2,1) , 6 - (2,3) and 8 - (3,2)

S2 = [Square of distance between 2 & 4] + [Square of distance between 2 & 6] + [Square of distance between 2
& 8]
= [ (1-2)2 + (2-1)2 ] + [ (1-2)2 + (2-3)2 ] + [ (1-3)2 + (2-2)2 ]
= 2 + 2 + 4
= 8
S3 is computed as follows:
Position of 3 in above matrix is (1,3) and his/her crushes are 6 - (2,3) and 9 - (3,3)
S3 = [Square of distance between 3 & 6] + [Square of distance between 3 & 9]
= (1-2)^2 + (3-3)^2 + (1-3)^2 + (3-3)^2
= 1 + 4
= 5
S4 is computed as follows:
Position of 4 in above matrix is (2,1) and his/her crush is 8 - (3,2)
S4 = Square of distance between 4 & 8
= (2-3)2 + (1-2)2
= 2
Now S5, S6 etc are all 0 (zero) because in our example we only considered 8 students numbered from 2 to 9,
number 1 is Prof. Roy
Finally S = S2 + S3 + S4
= 8 + 5 + 2
= 15
There can be several possible arrangements. Your task is to make an arrangement (of 999999 students and
Prof. Roy in a matrix of 1000 x 1000) such that this sum S is minimized.
Minimum is the sum S, better is the solution.
Scoring:
Score for a solution will be S (scroll up for details).
Solution with minimum score will be best solution while other solutions will get points relative to best
solution.
Input:
There is no input.
Output:
Output Hall arrangement in following format.
There should be exactly 1000 lines. Each line contains 1000 space separated integers.
All integers in matrix should be in range [1,1000000] inclusive and no two elements of matrix should be
same

Sample Output Format:

1 2 3
4 5 6
7 8 9
(3 x 3 matrix is for sample only, in actual output there should be 1000 x 1000 matrix)
NOTE:
You may get wrong answer in following cases:
1.) If your program print more or less than 1000000 numbers.
2.) If your program print duplicates values.
3.) If your program print values less than 1 and greater than 1000000

*/

    import java.util.ArrayList;
    import java.util.List;
     
    class HallArrangement7 {
    static List<Integer> primesUpTo(final int target) {
    final boolean[] nonPrime = new boolean[target + 1];
     
    for (int i = 2; i <= Math.sqrt(target); ++i) {
    if (!nonPrime[i]) {
    for (int j = i * 2; j <= target; j += i) {
    nonPrime[j] = true;
    }
    }
    }
     
    final List<Integer> primes = new ArrayList<Integer>();
     
    for (int i = 2; i <= target; ++i) {
    if (!nonPrime[i]) primes.add(i);
    }
     
    return primes;
    }
     
    public static void main(String[] args)
    {
    List<Integer> primes = new ArrayList<Integer>();
    primes=primesUpTo(1000000);
    int[] result=new int[1000001];
    int array[]=new int[1000001];
    int index=1000000;
    for(int i=primes.size()-1;i>=41538;i--)
    {
    array[index]=primes.get(i);
    result[primes.get(i)]=1;
    index--;
    }
    //System.out.println(index);
    index=1;
    for(int i=0;i<41538;i++)
    {
    result[primes.get(i)]=2;
    }
    for(int i=1;i<=1000000;i++)
    {
    if(result[i]==0)
    {
    array[index]=i;
    result[i]=1;
    index++;
    }
    else if(result[i]==2)
    {
    /*array[index]=i;
    result[i]=1;
    index--;
    array[index]=i/2;
    result[i/2]=1;
    index--;*/
    int prime=i;
    /*for(int j=1;j<=10000;j++)
    {
    if(prime*j>1000000)
    {
    break;
    }
    if(index<=963040 && result[prime*j]!=1)
    {
    array[index]=prime*j;
    result[prime*j]=1;
    index++;
    }
    }*/
    int temp[]=new int[151];
    for(int k=1;k<=85;k++)
    {
    temp[k]=prime*k;
    int temp1[]=new int[101];
    for(int l=1;l<=100;l++)
    {
    temp1[l]=temp[k]*l;
    if(temp[k]*l>1000000 && temp[k]*l<0)
    {
    break;
    }
    for(int j=1;j<=120;j++)
    {	
    if(temp1[l]*j>1000000 || temp1[l]*j<0)
    {
    break;
    }
    if(index<=963040 && result[temp1[l]*j]!=1)
    {
    array[index]=temp1[l]*j;
    result[temp1[l]*j]=1;
    index++;
    }
    }
    }
    }
    }
    }
    //System.out.println(index);
    int k=1000000;
    int [][]print=new int[1000][1000];
    int level=1;
    while(level<=500)
    {
    for(int i=level-1;i<=999-level;i++)
    {
    print[i][level-1]=array[k--];
    }
    for(int j=level-1;j<=999-level;j++)
    {
    print[1000-level][j]=array[k--];
    }
    for(int i=1000-level;i>=level;i--)
    {
    print[i][1000-level]=array[k--];
    }
    for(int j=1000-level;j>=level;j--)
    {
    print[level-1][j]=array[k--];
    }
    level++;
    }
    //System.out.println(k);
    for(int i=0;i<1000;i++)
    {
    for(int j=0;j<1000;j++)
    {
    System.out.print(print[i][j]+" ");
    }
    System.out.println();
    }
    }
     
    }


