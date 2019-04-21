package yaros.com.textrpg.Battle;
import android.widget.TextView;

import java.util.ArrayList;

import yaros.com.textrpg.Characters.Enemy;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.Ui.MainActivity;

public class Battle {

    TextView battleLog;
    MainCharacter hero;
    ArrayList<Enemy> enemies;
    Enemy enemy;

    public Battle(MainCharacter hero, Enemy enemy)
    {
        this.hero = hero;
        this.enemy = enemy;
    }

    public Battle(MainCharacter hero, ArrayList<Enemy> enemies)
    {
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
        hero.SetImpactPower();
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
        battleLog.append(str);
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
        battleLog.append(str);
    }

    public void FourthAction(int cur){
        for(int j = cur + 1; j < enemies.size(); j++){
            if(hero.impactPower < enemies.get(j).impactPower){
                hero.TakeDamage(enemies.get(j).damage);
                battleLog.append("Вы ранены, ваша выносливость: " + hero.stamina);
            }
        }
    }

    public void MainBattle(){
        String str;

        while ((hero.stamina > 0 ) && (enemy.stamina > 0)){
            FirstAction();
            SecondAction();

            battleLog.append("Сила удара " + "\"" + enemy.name + "\"" + "-- " + enemy.impactPower + " выносливость --- " + enemy.stamina);

            ThirdAction();
        }
        if(hero.stamina > 0){
            str = "Вы Победили!!!";
        }else {
            str = "ВЫ МЕРТВЫ!!!";
        }
        battleLog.append(str);
    }

    public void MainModBattle(){
        String str;

        for (int i = 0; i < enemies.size();i++){
            while ((hero.stamina > 0)&&(enemies.get(i).stamina > 0)){
                FirstModAction();
                SecondAction();
                ThirdModAction(enemies.get(i));
                FourthAction(i);
            }
        }
        if(hero.stamina > 0){
            str = "Вы Победили!!!";
        }else {
            str = "You Are Dead";
        }
        battleLog.append(str);
    }

}
