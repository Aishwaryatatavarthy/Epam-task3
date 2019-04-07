package Task3;import java.util.*;
public class GlowingBulb {
    
    static List<Integer> switch1 = new ArrayList<>(100);
    public static void main(String[] args) {
    	 long mid,low,high;
         long a=0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int l=0;l<n;l++) {
        	low=1;
            high=1000000000000000L;
            switch1.clear();
            sc.nextLine();
            String temp=sc.nextLine();
            long k=sc.nextLong();
            for(int i=0;i<temp.length();i++)
            {
                if(temp.charAt(i)=='1')
                    switch1.add(i+1);
            }
            while (low<=high) {
                mid=(low+high)/2;
                if(checks(mid)>=k){
                    high=mid-1;
                    a=mid;
                }
                else
                    low=mid+1;
            }
            System.out.println(a);
            sc.close();
        }
    }

    static long checks(long mid) {
        int sign,p=switch1.size();
        long a=0,temp;
        for(int i=1;i<(1<<p);i++) {
            temp=1;
            sign=-1;
            for(int j=0;j<p;j++) {
                if(((i>>j)&1)==1){
                    temp*=switch1.get(j);
                    sign*=-1;
                }
            }
            a+=sign*(mid/temp);
        }
        return a;
    }
}