import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;


class NodeKruskal {
    int x, y, val;

    public NodeKruskal() {
    }

    public NodeKruskal(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }
}

//最小生成树Kruskal算法
//时间复杂度ElogE  E为边树
public class Kruskal {
    static int n, m;
    static int fa[];
    static NodeKruskal a[];
    public static void main(String[] args) {
        int x, y, val;
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            a = new NodeKruskal[n + 10];
            fa = new int[n + 10];
            for (int i = 0; i < m; i++) {
                x = cin.nextInt();
                y = cin.nextInt();
                val = cin.nextInt();
                a[i] = new NodeKruskal(x, y, val);
            }
            for (int i = 1; i <= n; i++)
                fa[i] = i;
            Arrays.sort(a, 0, m, new Comparator<NodeKruskal>() {
                @Override
                public int compare(NodeKruskal o1, NodeKruskal o2) {
                    return o1.val - o2.val;
                }
            });
            System.out.println(KruskalAnswer(a));
        }
    }

    private static int KruskalAnswer(NodeKruskal[] a) {
        int ans = 0;
        int cnt = 0;
        for(int i = 0; i < m; i ++){
            int fx = root(a[i].x);
            int fy = root(a[i].y);
            if(fx != fy){
                fa[fx] = fy;
                ans += a[i].val;
                cnt ++;
                if(cnt == n-1){
                    return ans;
                }
            }
        }
        return -1;
    }

    private static int root(int y) {
        if(fa[y] == y)
            return y;
        else
            return fa[y] = root(fa[y]);
    }
}
