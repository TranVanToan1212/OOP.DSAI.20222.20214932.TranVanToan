package hust.soict.dsai.lab01;

import java.util.Scanner;

public class MatrixAddition {
	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		
        System.out.println("Matrix's number of rows");
        Integer rows = keyboard.nextInt();
        
        System.out.println("Matrix's number of columns");
        Integer columns = keyboard.nextInt();
        
        Integer array_1[][] = new Integer[rows][columns];
        Integer array_2[][] = new Integer[rows][columns];
        Integer array[][] = new Integer[rows][columns];
        
        System.out.println("Type in the elements of the first matrix, from right to left, top to bottom");
        
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < columns; j++) {
        		array_1[i][j] = keyboard.nextInt();
        	}
        }
        
        System.out.println("Type in the elements of the second matrix, from right to left, top to bottom");
        
        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < columns; j++) {
        		array_2[i][j] = keyboard.nextInt();
        	}
        }
        keyboard.close();
        
        System.out.println("The sum of the two matrices is: ");

        for (int i = 0; i < rows; i++) {
        	for (int j = 0; j < columns; j++) {
        		array[i][j] = array_1[i][j] + array_2[i][j];
        		System.out.print(array[i][j]);
        		System.out.print(" ");
        	}
        	System.out.println();
        } 
	}
}
