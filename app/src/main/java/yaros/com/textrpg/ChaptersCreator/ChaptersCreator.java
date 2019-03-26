package yaros.com.textrpg.ChaptersCreator;

import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.R;
import yaros.com.textrpg.TravelToNode.TravelToNode;

public class ChaptersCreator {



    public static HashMap<Integer, Chapter> Generate() {
        String link = "R.string.chapter_";
        int initCap = 618;
        HashMap<Integer,Chapter> chapters = new HashMap<>(initCap);

        TravelToNode travelToNode = new TravelToNode();
        for(int i = 0; i<initCap; i++){

            String chapter = "chapter_" + i;

            int[] variantsa = travelToNode.getChapterVariants(chapter);


            chapters.put(i, new Chapter());
        }
        return null;
    }
}
