package yaros.com.textrpg.Characters;
import yaros.com.textrpg.Cube.Cube;

public class Enemy {

    public static String name;
    public int mastery;
    public int stamina;
    public int impactPower;
    int damage;

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
