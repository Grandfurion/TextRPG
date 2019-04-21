package yaros.com.textrpg.FindeEnemyInChapter;

import java.util.ArrayList;

import yaros.com.textrpg.Characters.Enemy;
import yaros.com.textrpg.CheckUpperString.CheckIsUpperString;

public class FindeEnemy {

    public static ArrayList<Enemy> FindeEnemy(String str){
        ArrayList<Enemy> enemies = new ArrayList<>();


        ArrayList<String> rows = CheckIsUpperString.cutToRows(str);

        for (int i = 0; i < rows.size(); i++) {
            if (CheckIsUpperString.checkIsUpperString(rows.get(i))){
                String name = rows.get(i);
                int damage = 2;
                if(name.equals("\nТОРГОВЕЦ")){
                    damage = 3;
                }
                i++;

                String[] arr = rows.get(i).split(" ");
                int mastery = Integer.parseInt(arr[1]);
                i++;

                String[] narr = rows.get(i).split(" ");
                int stamina = Integer.parseInt(arr[i]);

                Enemy en = new Enemy(name,mastery,stamina,0,damage);
                enemies.add(en);
            }
        }
        return enemies;
    }

}
