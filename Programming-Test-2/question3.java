import java.util.*;

public class question3{
    public static class FenwickTree{
        int size;
        long tree[];
        FenwickTree(int size){
            this.size = size;
            tree = new long[size+1];
        }
        public void update(int i, int delta){
            while(i<=size){
                tree[i] += delta;
                i += i & -i;
            }
        }
        public long query(int i){
            long sum = 0;
            while(i>0){
                sum += tree[i];
                i -= i & -i;
            }
            return sum;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();

        int mod = 3;

        FenwickTree f[] = new FenwickTree[mod];
        for(int i=0;i<mod;i++){
            f[i] = new FenwickTree(n/mod + ((n % mod >= i)?1:0));
        }
        while(q-- > 0){
            int t = sc.nextInt();
            if(t == 1){
                int l = sc.nextInt();
                int r = sc.nextInt();
                int x = sc.nextInt();
                int FenwickIndex = l % mod;
                f[FenwickIndex].update(l/mod+1,x);
                f[FenwickIndex].update((r/mod)+1+((n % mod >= FenwickIndex)?1:0),-x);
            }else if(t == 2){
                int i = sc.nextInt();
                int FenwickIndex = i % mod;
                long result = f[FenwickIndex].query(i/mod + 1);
                System.out.println(result);
            }
        }
    }
}