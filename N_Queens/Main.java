import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of N: ");
        int n = sc.nextInt();

        NQueens nq = new NQueens(n);
        nq.solve();
    }
}