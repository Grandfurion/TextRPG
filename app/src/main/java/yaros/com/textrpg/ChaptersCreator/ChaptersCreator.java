package yaros.com.textrpg.ChaptersCreator;

import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.MainActivity;
import yaros.com.textrpg.R;

public class ChaptersCreator implements IChaptersCreator {


    @Override
    public static HashMap<Integer, Chapter> Generate() {
        String link = "R.string.chapter_";
        int initCap = 618;
        HashMap<Integer,Chapter> chapters = new HashMap<>(initCap);

        for(int i = 0; i<initCap; i++){

            String Chapter = "chapter_" + i;

            

            chapters.put(i, new Chapter());
        }
    }
}
