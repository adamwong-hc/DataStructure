import java.util.*;


class Path {
    int from, to, val;

    public Path() {
    }

    public Path(int from, int to, int val) {
        this.from = from;
        this.to = to;
        this.val = val;
    }
}

class Point {
    int position;
    int value;

    public Point() {
    }

    public Point(int position, int value) {
        this.position = position;
        this.value = value;
    }
}


//最后TLE了
public class Dijkstra {

    static boolean vis[];
    static int dis[];
    static ArrayList<Path> a[];
    static int n, m, u, v, w;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            n = cin.nextInt();
            m = cin.nextInt();
            if (m == 0) {
                System.out.println("0");
                continue;
            }
            a = new ArrayList[n + 10];
            vis = new boolean[n + 10];
            dis = new int[n + 10];
            Arrays.fill(dis, 0x3f3f3f3f);

            for (int i = 1; i <= m; i++) {
                u = cin.nextInt();
                v = cin.nextInt();
                w = cin.nextInt();
                if (a[u] == null) {
                    a[u] = new ArrayList<>();
                }
                if (a[v] == null) {
                    a[v] = new ArrayList<>();
                }
                a[u].add(new Path(u, v, w));
                a[v].add(new Path(v, u, w));
            }
            dij();

        }
    }

    private static void dij() {
        //vis[1] = true;
        dis[1] = 0;
        int len = a[1].size();
        int temp = 0x3f3f3f;
        int pos = 1;
        //堆优化版本
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return o1.value - o2.value;
            }
        });

        pq.add(new Point(1, 0));

        while (!pq.isEmpty()) {
            Point p = pq.poll();
            if (vis[p.position]) continue;
            vis[p.position] = true;
            int l = a[p.position].size();
            for (int i = 0; i < l; i++) {
                Path path = a[p.position].get(i);
                if (dis[path.to] > dis[path.from] + path.val) {
                    dis[path.to] = dis[path.from] + path.val;
                    pq.add(new Point(path.to, dis[path.to]));
                }
            }
        }

//        //普通版本
//        for (int i = 1; i <= n - 1; i++) {
//            temp = 0x3f3f3f;
//            for (int j = 1; j <= n; j++) {
//                if (!vis[j] && dis[j] < temp) {
//                    temp = dis[j];
//                    pos = j;
//                }
//            }
//            vis[pos] = true;
//
//            len = a[pos].size();
//            for (int j = 0; j < len; j++) {
//                Path path = a[pos].get(j);
//                if (!vis[path.to] && dis[path.to] > dis[pos] + path.val) {
//                    dis[path.to] = dis[pos] + path.val;
//                }
//            }
//        }


        if (dis[n] < 0x3f3f3f3f)
            System.out.println(dis[n]);
    }
}
