package Task3;

import java.util.*;
class pair_s_e implements Comparable<pair_s_e> {
    Long start, end;

    pair_s_e(Long s, Long e) {
        this.start = s;
        this.end = e;
    }

    public int compareTo(pair_s_e o) {
        return start.compareTo(o.start);
    }
}

public class HelpArmy {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Long start = sc.nextLong();
        Long end = sc.nextLong();
        pair_s_e pairs[] = new pair_s_e[n];
        for (int i = 0; i < n; i++) {
            Long x1 = sc.nextLong();
            Long p1 = sc.nextLong();
            pairs[i] = new pair_s_e(x1 - p1, x1 + p1);
        }
        System.out.println(solve(pairs,start,end,n));
        
    }
    static long solve(pair_s_e p[],Long start,Long end,int n)
    {
        Arrays.sort(p);
        Long s = p[0].start;
        Long e = p[0].end;
        ArrayList<pair_s_e> a = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (p[i].start <= e) {
                e = Math.max(p[i].end, e);
            } else {
                a.add(new pair_s_e(s, e));
                s = p[i].start;
                e = p[i].end;

            }
        }
        
        a.add(new pair_s_e(s, e));
        /*for(int i=0;i<a.size();i++)
        	System.out.println(""+a.get(i).s+" "+a.get(i).e);*/
        long answer = 0;
        for (int i = 0; i < a.size(); i++) {
            if (start >= end) {
                start = end;
                break;

            }
            if (start >= a.get(i).start && start <= a.get(i).end) {
                start = a.get(i).end;
            } else if (start <= a.get(i).start && end >= a.get(i).end) {
                answer += a.get(i).start - start;
                start = a.get(i).end;
            } else if (start <= a.get(i).start && end >= a.get(i).start && end <= a.get(i).end) {
                answer += a.get(i).start - start;
                start = end;
            }

            else if (start <= a.get(i).start && end <= a.get(i).start) {
                answer += end - start;
                start = end;
            }

        }
        if (start < end) {
            answer += end - start;
        }
        return answer;
    }
}
