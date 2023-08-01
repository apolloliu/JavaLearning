package Java学习.科目二.多线程;

public class Interrupt extends Thread {
    private boolean stop = false;
    public static void main(String[] args) throws InterruptedException {
        Interrupt t = new Interrupt();
        t.start();
        Thread.sleep(1000);
        t.interrupt();
        Thread.sleep(1000);
        t.notifyAll();
        System.out.println("exit");
    }

    @Override
    public void run() {
        while(!stop){
            System.out.println("running: " + Thread.currentThread().getName());
        }
        System.out.println("stop: " + Thread.currentThread().getName());
    }
}
