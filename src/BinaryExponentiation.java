import java.util.Scanner;

public class BinaryExponentiation {
    //快速幂算法
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n, m;
        n = cin.nextInt();
        m = cin.nextInt();
        int ans = QuickM(n, m);
        System.out.println(ans);
    }

    private static int QuickM(int n, int m) {
        int p = 1;
        while (m != 0) {
            if (m % 2 == 1) {
                p *= n;
            }
            n *= n;
            m /= 2;
        }
        return p;
    }


}
