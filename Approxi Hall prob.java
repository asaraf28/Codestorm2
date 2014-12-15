

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


