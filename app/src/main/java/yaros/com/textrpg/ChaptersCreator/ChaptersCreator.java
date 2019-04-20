package yaros.com.textrpg.ChaptersCreator;

import android.content.Context;
import android.content.res.Resources;

import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.R;
import yaros.com.textrpg.TravelToNode.GetVariants;
import yaros.com.textrpg.TravelToNode.TravelToNode;
import yaros.com.textrpg.Ui.MainActivity;

public class ChaptersCreator {

    Context context;

    public ChaptersCreator(Context context){
        this.context = context;
    }

    public static HashMap<Integer, Chapter> Generate(Context context) {
        int initCap = 618;
        HashMap<Integer,Chapter> chapters = new HashMap<>(initCap);

        TravelToNode travelToNode = new TravelToNode();
        for(int i = 0; i<initCap; i++){

            String chapter = "chapter_" + i;

            int chapId = context.getResources().getIdentifier(("chapter_" + i),"string", context.getPackageName());

            //int[] variants = GetVariants.getVariants(context.getString(chapId));
            int[] variants = GetVariants.getVariants(chapId, context);
            /*int[] trueVariants = new int[variants.length];
            for (int a = 0; a < variants.length; a++) {
                trueVariants[a] = context.getResources().getIdentifier((chapter), "")
            }/*
            /*chapters.put(i, new Chapter(i, context.getResources().
                    getIdentifier("chapter_" + i, "string", context.getPackageName()), variants));*/
            chapters.put(i, new Chapter(i, chapId, variants));
        }
        return chapters;
    }
}
