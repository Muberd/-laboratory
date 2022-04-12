package main;

public class App {
    public static void main(String[] args) {
        Buffer b = Buffer.getInstance();
        Runnable g = new Generator(b);
        Runnable e = new Extractor(b);
        Thread threadGenerator = new Thread(g);
        Thread threadExtractor = new Thread(e);
        threadGenerator.start();
        threadExtractor.start();
    }
}
