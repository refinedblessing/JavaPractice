package hackerrank;

import java.util.Scanner;

//https://www.hackerrank.com/challenges/java-loops/problem?isFullScreen=true

public class Loops2 {
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int currSum = a;
            int currPos = 1;

            while (currPos <= Math.pow(2, n-1)) {
                currSum += (currPos * b);
                System.out.print(currSum + " ");
                currPos *= 2;
            }
            System.out.println();
        }
        in.close();
    }
}
