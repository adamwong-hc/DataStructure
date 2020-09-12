import java.util.Scanner;

public class Heap {

    static int n, m;
    static int a[];

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        n = cin.nextInt();
        m = cin.nextInt();
        a = new int[n + 10];
        for (int i = 1; i <= n; i++) {
            a[i] = cin.nextInt();
        }
        for (int i = n / 2; i >= 1; i--)
            swiftdown(i);
        for(int i = 1; i <= m; i ++){
            if(i == m){
                System.out.println(a[1]);
            }else {
                System.out.print(a[1] + " ");
            }
            swap(1, n);
            n --;
            swiftdown(1);
        }
    }

    private static void swiftdown(int i) {
        int t = i;

        while (true) {
            if (i * 2 + 1 <= n && a[i * 2 + 1] > a[i]) {
                t = 2 * i + 1;
            }
            if (i * 2 <= n && a[i * 2] > a[t]) {
                t = 2 * i;
            }
            if(t != i){
                swap(t, i);
                i = t;
            }else break;
        }
    }

    private static void swap(int t, int i) {
        int temp = a[t];
        a[t] = a[i];
        a[i] = temp;
    }
}
