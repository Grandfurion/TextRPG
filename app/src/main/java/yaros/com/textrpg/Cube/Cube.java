package yaros.com.textrpg.Cube;

import java.util.Random;

public class Cube {

    public static int ThrowOneCube(){
        Random rnd = new Random();
        return rnd.nextInt(6 )+1;
    }

    public static int ThrowTwoCube()
    {
        return ThrowOneCube() + ThrowOneCube();
    }
}
