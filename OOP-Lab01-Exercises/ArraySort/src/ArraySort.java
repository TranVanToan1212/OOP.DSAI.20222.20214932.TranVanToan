
import java.util.Arrays;
import java.util.Scanner;

public class ArraySort {
	public static void main (String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
        System.out.println("Length of array?");
        Integer n = Integer.parseInt(keyboard.nextLine());
        
        System.out.println("Type in the elements of the array");
        Integer array[] = new Integer[n];
        
        for (int i = 0; i < n; i++) {
        	array[i] = keyboard.nextInt();
        }
        
        keyboard.close();
        
        Arrays.sort(array);
        
        System.out.println("Sorted array: " + Arrays.toString(array));
	}
}
