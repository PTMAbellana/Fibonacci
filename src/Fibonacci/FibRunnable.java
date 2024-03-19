package Fibonacci;

public class FibRunnable implements Runnable{
    public static int[] results;
    int n;
    public FibRunnable(int n){
        this.n = n;
    }

    public void run(){
        if(n == 1){
            results[0] = 0;
            System.out.println("Fibonacci Number 1 : 0");
            return;

        }
        if(n == 2){
            results[1] = 1;
            System.out.println("Fibonacci Number 2 : 1");
            return;
        }

        Thread before1 = Main.fibRunnableThreads.get(n-3);
        Thread before2 = Main.fibRunnableThreads.get(n-2);

        try{
            before1.start();
            before2.start();
        } catch(IllegalThreadStateException e){

        }

        try {
            before1.join();
            before2.join();
        } catch (InterruptedException e) {

        }

        int finalRes = results[n-2] + results[n-3];
        results[n-1] = finalRes;
        System.out.println("Fibonacci Number " +n + " : " + finalRes);
    }
}