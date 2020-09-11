import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class NodePrime {
    int to;
    int val;

    public NodePrime() {
    }

    public NodePrime(int to, int val) {
        this.to = to;
        this.val = val;
    }
}

public class Prime {

    //最小生成树Prime算法 WA 但是没找出错
    static int n, m, u, v, val;
    static ArrayList<NodePrime> a[];
    static boolean vis[];
    static int dis[];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            a = new ArrayList[n + 10];
            vis = new boolean[n + 10];
            dis = new int[n + 10];
            Arrays.fill(dis, 0x3f3f3f);
            Arrays.fill(vis,false);
            for (int i = 1; i <= m; i++) {
                u = cin.nextInt();
                v = cin.nextInt();
                val = cin.nextInt();
                if (a[u] == null) {
                    a[u] = new ArrayList<>();
                }
                if (a[v] == null) {
                    a[v] = new ArrayList<>();
                }
                a[u].add(new NodePrime(v, val));
                a[v].add(new NodePrime(u, val));
            }
            PrimeAns();
        }
    }

    private static void PrimeAns() {
        vis[1] = true;
        boolean flag = true;
        int ans = 0;
        int minn = 0x3f3f3f;
        int pos = -1;
        int len = a[1].size();
        for (int i = 0; i < len; i++) {
            NodePrime p = a[1].get(i);
            dis[p.to] = p.val;
        }
        for (int i = 1; i <= n - 1; i++) {
            minn = 0x3f3f3f;
            pos = -1;
            for (int j = 1; j <= n; j++) {
                if (!vis[j] && dis[j] < minn) {
                    minn = dis[j];
                    pos = j;
                }
            }
            if (pos == -1) {
                flag = false;
                break;
            }
            ans += minn;
            vis[pos] = true;
            int len1 = a[pos].size();
            for (int j = 0; j < len1; j++) {
                NodePrime p = a[pos].get(j);
                if (!vis[p.to] && dis[p.to] > p.val) {
                    dis[p.to] = p.val;
                }
            }
        }
        if (!flag)
            System.out.println("-1");
        else System.out.println(ans);
    }
}
