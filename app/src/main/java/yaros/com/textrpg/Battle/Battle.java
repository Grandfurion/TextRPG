package yaros.com.textrpg.Battle;
import android.content.Context;
import android.widget.TextView;

import java.util.ArrayList;

import yaros.com.textrpg.Characters.Enemy;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.R;
import yaros.com.textrpg.Ui.MainActivity;

public class Battle {

    public static TextView battleLog;
    MainCharacter hero;
    ArrayList<Enemy> enemies;
    Enemy enemy;
    //Context context;

    public Battle(MainCharacter hero, Enemy enemy, TextView battleLog/*,Context context */)
    {
        this.battleLog = battleLog;
        this.hero = hero;
        this.enemy = enemy;

    }

    public Battle(MainCharacter hero, ArrayList<Enemy> enemies, TextView battleLog)
    {
        this.battleLog = battleLog;
        this.hero = hero;
        this.enemies = enemies;
    }

    public void FirstAction()  //Определяет силу удара врагa
    {
        enemy.SetImpactPower();
    }

    public void FirstModAction(){  //Определяет силу удара всех врагов
        for (Enemy en: enemies ) {
            en.SetImpactPower();
        }
    }

    public void SecondAction(){

        if(hero.sword.equals("Меч Зеленого Рыцаря")){
            hero.SetImpactPower(1);
        }else {
            hero.SetImpactPower();
        }
    }

    public void ThirdAction(){
        String str;

        if(hero.impactPower > enemy.impactPower){
            enemy.GetDamage(hero.damage);
            str = "Вы ранили " + enemy.name;
        }else if (enemy.impactPower > hero.impactPower){
            hero.TakeDamage(enemy.damage);
            str = "Вас ранил" + enemy.name;
        }else {
            str = enemy.name + " парирует Ваш удар, бой продолжается...";
        }
        battleLog.setText(battleLog.getText() + str + '\n');
    }

    public void ThirdModAction(Enemy enemy){
        String str;
        if(hero.impactPower > enemy.impactPower){
            enemy.GetDamage(hero.damage);
            str = "Вы ранили " + enemy.name;
        }else if (enemy.impactPower > hero.impactPower){
            hero.TakeDamage(enemy.damage);
            str = "Вас ранил " + enemy.name;
        }else {
            str = enemy.name + " парирует Ваш удар, бой продолжается...";
        }
        battleLog.setText(battleLog.getText() + str + '\n');
    }

    public void FourthAction(int cur){
        for(int j = cur + 1; j < enemies.size(); j++){
            if(hero.impactPower < enemies.get(j).impactPower){
                hero.TakeDamage(enemies.get(j).damage);
                battleLog.setText(battleLog.getText() + "Вы ранены, ваша выносливость: " + hero.stamina  + '\n');
            }
        }
    }

    public void MainBattle(){
        String str;

        if(hero.sword.equals("Смерть Орков")){
            if (enemy.name.contains("ОРК")){
                enemy.stamina = 0;
                battleLog.setText(battleLog.getText() + "Вы убили орка с помощью меча \"Убийца Орков\"" + '\n');

            }
        }

        while ((hero.stamina > 0 ) && (enemy.stamina > 0)){
            FirstAction();
            SecondAction();

            str = "Сила удара " + "\"" + enemy.name + "\"" + "-- " + enemy.impactPower + " выносливость -- " + enemy.stamina;
            battleLog.setText(battleLog.getText() + str + '\n');

            str = "Ваша сила удара " + "-- " + hero.impactPower + " выносливость -- " + hero.stamina;
            battleLog.setText(battleLog.getText() + str + '\n');

            ThirdAction();
        }
        if(hero.stamina > 0){
            str = "Вы Победили!!!";
        }else {
            str = "ВЫ МЕРТВЫ!!!";
        }
        battleLog.setText(battleLog.getText() + str + '\n');
    }

    public void MainModBattle(){
        String str;
        if(hero.sword.equals("Смерть Орков"))
        for (Enemy en: enemies) {
            if (en.name.contains("ОРК")){
                en.stamina = 0;
                battleLog.setText(battleLog.getText() + "Вы убили орка с помощью меча \"Убийца Орков\"" + '\n');
                break;
            }

        }

        for (int i = 0; i < enemies.size(); i++){
            while ((hero.stamina > 0)&&(enemies.get(i).stamina > 0)){
                FirstModAction();
                SecondAction();

                for (Enemy en: enemies) {
                    if(en.stamina > 0) {
                        str = "Сила удара " + "\"" + en.name + "\"" + "-- " + en.impactPower + " выносливость -- " + en.stamina;
                        battleLog.setText(battleLog.getText() + str + '\n');
                    }
                }

                str = "Ваша сила удара " + "-- " + hero.impactPower + " выносливость -- " + hero.stamina;
                battleLog.setText(battleLog.getText() + str + '\n');

                ThirdModAction(enemies.get(i));
                FourthAction(i);
            }
            str = "ВЫ УБИЛИ " + enemies.get(i).name;
            battleLog.setText(battleLog.getText() + str + '\n');
        }
        if(hero.stamina > 0){
            str = "Вы Победили!!!";
        }else {
            str = "You Are Dead";
        }
        battleLog.setText(battleLog.getText() + str + '\n');
    }

}
