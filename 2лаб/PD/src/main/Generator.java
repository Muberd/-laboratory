package main;

import java.util.Random;

public class Generator implements Runnable{
    public final int MAX_ITERATION = 100;
    public final int NUMBER_BOUND = 16;
    private final Buffer buffer;
    private final Random random = new Random();

    public Generator(Buffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITERATION; i++) {
            synchronized (buffer){
                buffer.add(generateHexNumber());
                System.out.println("Поток 1 | итерация: " + i + " - " + buffer);
                buffer.notify();
                if(buffer.isFull()){
                    try {
                        buffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }



        }
        System.out.println("Поток 1 | завершение работы");
    }

    private int generateHexNumber(){
        return random.nextInt(NUMBER_BOUND) + 1;
    }
}
