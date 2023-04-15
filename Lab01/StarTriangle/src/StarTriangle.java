
import java.util.Scanner;
public class StarTriangle{
    public static void main(String args[]){
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Input n =");
        int n = keyboard.nextInt();
        
        keyboard.close();
        
        for (int i = 0; i < n; i++ ) {
            for (int j = 0; j < n - i - 1; j ++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2*i + 1; j ++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}