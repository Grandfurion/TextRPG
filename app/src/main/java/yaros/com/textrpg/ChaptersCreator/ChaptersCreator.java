package yaros.com.textrpg.ChaptersCreator;

import android.content.Context;
import android.content.res.Resources;

import java.util.ArrayList;
import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.Characters.Enemy;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.CheckUpperString.CheckIsUpperString;
import yaros.com.textrpg.FindeEnemyInChapter.FindeEnemy;
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

            int chapId = context.getResources().getIdentifier(("chapter_" + i),"string", context.getPackageName());

            if(CheckIsUpperString.checkIsUpperString(context.getString(chapId))){
                MainActivity.battleChapters.put(chapId, FindeEnemy.FindeEnemy(context.getString(chapId)));
            }

            int[] variants = GetVariants.getVariants(chapId, context);

            chapters.put(i, new Chapter(i, chapId, variants));
        }
        return chapters;
    }
}
