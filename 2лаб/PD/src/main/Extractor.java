package main;

public class Extractor implements Runnable{
    public final int MAX_ITERATION = 100;
    private final Buffer buffer;

    public Extractor(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITERATION; i++) {
            synchronized (buffer){
                if(buffer.isEmpty()){
                    try {
                        buffer.wait(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                int data = buffer.pop();
                System.out.println("Поток 2 | итерация: " + i + " - " + data + " - " + Math.sin(data / Math.PI));
                buffer.notify();

            }
        }
        System.out.println("Поток 2 | завершение работы");
    }
}
