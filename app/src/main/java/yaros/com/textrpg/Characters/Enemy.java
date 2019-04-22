package yaros.com.textrpg.Characters;
import yaros.com.textrpg.Cube.Cube;

public class Enemy {

    public String name; // Имя
    public int mastery;        // мастерство
    public int stamina;        // выносливость
    public int impactPower;    // Сила удара
    public int damage;                // Урон

    public Enemy(String name,int mastery, int stamina, int impactPower, int damage)
    {
        this.name = name;
        this.mastery = mastery;
        this.stamina = stamina;
        this.impactPower = impactPower;
        this.damage = damage;
    }

    public void SetImpactPower()
    {
        impactPower = mastery + Cube.ThrowOneCube();
    }

    public void GetDamage(int damage)
    {
        stamina -= damage;
    }


}
