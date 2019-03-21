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

            int[] variantsa = travelToNode.getChapterVariants(chapter,'-');
            int[] variantsb = travelToNode.getChapterVariants(chapter,'(');

            int[] variants = new int[variantsa.length + variantsb.length];
            for (int j = 0; j < variants.length; j++)
            {
                if(j < variantsa.length) {
                    variants[j] = variantsa[j];
                }else {
                    variants[j] = variantsb[j - variantsa.length-1];
                }
            }



            chapters.put(i, new Chapter());
        }
        return null;
    }
}
