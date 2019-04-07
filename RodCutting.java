package Task3;

import java.util.*;

public class RodCutting {
    public static int find_special(int n){
        int cnt = 0;
        while(n >0){
            n--;
            n/=2;
            cnt++;
            
        }
        return cnt;
    }
    public static void main(String args[] ) throws Exception {
    	int n,t;
    	Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        while(t>0){
        n= sc.nextInt();
        System.out.println(find_special(n)-1);
        t--;
        }
 
    }
}