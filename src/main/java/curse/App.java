package curse;

import curse.core.Engine;

import java.io.IOException;

public class App {

    public static void main(String[] args)  {
        try {
            Engine.getInstance().start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
