import java.util.*;
import java.io.*;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
 for (int i = 0; i < t; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            int sum = a;
            
            for (int j = 0; j < n; j++) {
                sum += (int)(Math.pow(2, j) * b);
                System.out.print(sum + " ");
            }
            System.out.println(); // move to the next line after each test case
        }
        
        in.close();
    }
}


//You are given t test cases.
//For each test case, you receive three integers: a, b, and n.

//You must generate and print a series for each test case according to the following formula:


//Each term in the series adds the next power of 2 multiplied by b.
//You need to print the first n terms of the sequence on a single line, separated by spaces.
