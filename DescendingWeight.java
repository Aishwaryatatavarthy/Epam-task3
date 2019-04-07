package Task3;
import java.util.*;

class Mycomp implements Comparator<Integer>{
    public int compare(Integer a, Integer b){
        return b%DescendingWeight.t-a%DescendingWeight.t;
    }
}
public class DescendingWeight {
    public static int t;
    public static void main(String args[] ) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int val=sc.nextInt();
        DescendingWeight.t=sc.nextInt();
        ArrayList<Integer> array = new ArrayList<Integer>();
        for(int i=0;i<val;i++){
            array.add(sc.nextInt());
        }
        Collections.sort(array);
        Collections.sort(array,new Mycomp());
        for(int arr:array){
        	
            System.out.print(arr +" ");
        }
        
 
    }
}