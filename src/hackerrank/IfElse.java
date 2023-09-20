package hackerrank;

// Problem Link
// https://www.hackerrank.com/challenges/java-if-else/problem

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class IfElse {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine().trim());
        if ((N % 2) == 0) {
            if (N <= 5) printNotWeird();
            else if (N <= 20) printWeird();
            else printNotWeird();
        }
        else printWeird();

        bufferedReader.close();
    }

    static void printWeird() {
        System.out.println("Weird");
    }

    static void printNotWeird() {
        System.out.println("Not Weird");
    }
}
