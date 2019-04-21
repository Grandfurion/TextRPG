package yaros.com.textrpg.Characters;
import yaros.com.textrpg.Cube.Cube;

public class MainCharacter {

    public static int mastery;      //мастерство
    public static int stamina;      //выносливость
    public static int fortune;      //удача
    public static int impactPower;  //Сила удара
    public static int damage;       //урон
    public static int money;        //деньги
    public static String sword = "Стальной меч";
    public static int flask;
    // 1 - стальной меч, 2 - смерть орков (568), 3 - меч зеленого рыцаря(126);
    // при надобности добавить имя Меча


    public MainCharacter()
    {
        mastery = Cube.ThrowOneCube() + 6;
        stamina = Cube.ThrowTwoCube() + 12;
        fortune = Cube.ThrowOneCube() + 6;
        money = 15;
        damage = 2;     // кол-во урона
        flask = 2;
    }


    public MainCharacter(int mastery,int stamina,int fortune, int impactPower,int damage) {
        this.mastery = mastery;
        this.stamina = stamina;
        this.fortune = fortune;
        this.impactPower = impactPower;
        this.damage = damage;
        this.money = money;
        flask = 2;
    }

    public  boolean checkFortune()
    {
        int cub = Cube.ThrowTwoCube();
        boolean luck = ((cub <= fortune) || (fortune == 0)) ? true : false;

        --fortune;
        return luck;
    }

    public void SetImpactPower(){
        impactPower = Cube.ThrowTwoCube() + mastery;
    }

    public void  TakeDamage(int damage){
        stamina -= damage;
    }

}
