package Task3;
import java.util.*;
import java.io.*;

public class StringsStatistic
{
	static int[] d;
	static int pow(int a, int b, int m) 
	{
        int pwr;
		if(b==0)
			return 1;
		pwr=pow(a,b/2,m);
		pwr=(int)((long)pwr*pwr%m);
		if(b%2==1)
			pwr=(int)((long)pwr*a%m);
		return pwr;
	}
	
	static int search(int i){
		return d[i]<0 ? i:(d[i]=search(d[i]));
	}
	
	static boolean join(int x, int y) {
		x = search(x);
		y = search(y);
		if (x == y)
			return false;
		if (d[x] > d[y])
			d[x] = y;
		else {
			if (d[x] == d[y])
				d[x]--;
			d[y] = x;
		}
		return true;
	}
	
	static int fun2(int k, int v, int n, int a, int m) {
		Arrays.fill(d,-1);
		int cnt=n,cnt2=0; 
		for (int i=1;i<n;i++)
			if ((v & 1 << i)>0) {
				for (int j=i;j<i+k;j++)
					if (join(j,j-i))
						cnt--;
				cnt2++;
			}
		int sum =pow(a,cnt,m);
		return cnt2%2==1 ? sum:(m-sum)%m;
	}
	
	static int fun(int n,int a,int mod) {
		d=new int[n];
		int s=0;
		for (int k=1; k<n; k++)
			for (int v=2; v<1<<n-k+1; v+=2)
				s =(s+fun2(k,v,n,a,mod))%mod;
		return s;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s=new StringTokenizer(reader.readLine());
		int n=Integer.parseInt(s.nextToken());
		int a=Integer.parseInt(s.nextToken());
		int mod=Integer.parseInt(s.nextToken());
		System.out.println(fun(n,a,mod));
	}
}

