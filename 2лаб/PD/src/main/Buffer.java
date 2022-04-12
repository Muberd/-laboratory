package main;

import java.util.Arrays;

public class Buffer {
    public final int BUFFER_SIZE = 10;
    private volatile int[] data;
    private int index = 0;
    private static Buffer instance = null;

    private Buffer(){
        data = new int[BUFFER_SIZE];
        Arrays.fill(data, -1);
    }

    public static Buffer getInstance() {
        if (instance == null) {
            instance = new Buffer();
        }
        return instance;
    }

    public void add(int number){
        if(isFull()){
            index--;
        }
        data[index] = number;
        index++;
    }

    public int pop(){
        int out = 0;
        if(index == 0){
            out = data[index];
            out = -1;
        }
        index--;
        out = data[index];
        data[index] = -1;
        return out;
    }

    public boolean isFull(){
        return index == BUFFER_SIZE;
    }

    public boolean isEmpty(){
        return index == 0;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
}
