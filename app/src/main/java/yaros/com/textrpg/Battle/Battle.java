package yaros.com.textrpg.Battle;
import java.util.ArrayList;

import yaros.com.textrpg.Characters.Enemy;
import yaros.com.textrpg.Characters.MainCharacter;

public class Battle {

    MainCharacter hero = new MainCharacter();
    ArrayList<Enemy> enemies = new ArrayList<Enemy>();
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
        if(hero.impactPower > enemy.impactPower){
            enemy.GetDamage(hero.damage);
        }else if (enemy.impactPower > hero.impactPower){
            hero.TakeDamage(enemy.damage);
        }
    }

    public void ThirdModAction(Enemy enemy){
        if(hero.impactPower > enemy.impactPower){
            enemy.GetDamage(hero.damage);
        }else if (enemy.impactPower > hero.impactPower){
            hero.TakeDamage(enemy.damage);
        }
    }

    public void FourthAction(int cur){
        for(int j = cur + 1; j < enemies.size(); j++){
            if(hero.impactPower < enemies.get(j).impactPower){
                hero.TakeDamage(enemies.get(j).damage);
            }
        }
    }

    public void MainBattle(){
        while ((hero.stamina > 0 ) && (enemy.stamina > 0)){
            FirstAction();
            SecondAction();
            ThirdAction();
        }
        if(hero.stamina > 0){
            // победа
        }else {
            //проигрышь
        }
    }

    public void MainModBattle(){
        for (int i = 0; i < enemies.size();i++){
            while ((hero.stamina > 0)&&(enemies.get(i).stamina > 0)){
                FirstModAction();
                SecondAction();
                ThirdModAction(enemies.get(i));
                FourthAction(i);
            }
        }
        if(hero.stamina > 0){
            // победа
        }else {
            //проигрышь
        }
    }

}
