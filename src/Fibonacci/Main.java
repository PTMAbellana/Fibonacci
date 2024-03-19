package Fibonacci;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<Thread> fibRunnableThreads;
    public static void main(String[] args) {
        fibRunnableThreads = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of terms: ");
        int num = sc.nextInt();
        FibRunnable.results = new int[num];

        for(int i=1; i <= num; i++){
            fibRunnableThreads.add(new Thread(new FibRunnable(i)));
        }
        Thread lastThread = fibRunnableThreads.get(fibRunnableThreads.size()-1);
        lastThread.start();
        try {
            lastThread.join();
        } catch (InterruptedException e) {}
        System.out.println("First " + num + " Fibonacci Numbers: ");
        for(int i = 0; i<num; i++){
            System.out.print(FibRunnable.results[i] + " ");
        }
    }
}