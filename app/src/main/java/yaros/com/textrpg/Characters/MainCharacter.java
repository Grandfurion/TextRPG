package yaros.com.textrpg.Characters;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import yaros.com.textrpg.Cube.Cube;
import yaros.com.textrpg.R;
import yaros.com.textrpg.Ui.CharacterInfoFragment;
import yaros.com.textrpg.Ui.MainActivity;

public class MainCharacter {

    public  int mastery;      //мастерство
    public int maxStamina;
    public  int stamina;      //выносливость
    public  int fortune;      //удача
    public  int impactPower;  //Сила удара
    public  int damage;       //урон
    public  int money;        //деньги
    public  String sword = "Стальной меч";
    public  int flask;
    // 1 - стальной меч, 2 - смерть орков (568), 3 - меч зеленого рыцаря(126);
    // при надобности добавить имя Меча
    public final int DIALOG_FILL = 1;


    public MainCharacter()
    {
        mastery = Cube.ThrowOneCube() + 6;
        stamina = Cube.ThrowTwoCube() + 12;
        fortune = Cube.ThrowOneCube() + 6;
        money = 15;
        damage = 2;     // кол-во урона
        flask = 2;
        maxStamina = stamina;
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

    public boolean checkFortune()
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

    public void Drink(Context context){
        if (flask <= 0 ){
            Toast.makeText(context, "Фляга пуста", Toast.LENGTH_SHORT).show();
            return;
        }
        if (stamina >= maxStamina){
            Toast.makeText(context, "Здоровье полное", Toast.LENGTH_SHORT).show();
            return;
        }
        flask --;
        stamina += 2;
        if (stamina > maxStamina){
            stamina = maxStamina;
        }
        CharacterInfoFragment.updateCharacterInfo();
    }

    public void Fill(Context context){
        if (flask <2 ){
            //SOZDANIE DIALOGA
            AlertDialog fillDialog = onCreateDialog(DIALOG_FILL, context);
            fillDialog.show();
        }else {
            Toast.makeText(context, "Фляга полная", Toast.LENGTH_SHORT).show();
            return;
        }
        CharacterInfoFragment.updateCharacterInfo();
    }


    protected AlertDialog onCreateDialog(int id, Context context) {
        if (id == DIALOG_FILL) {
            AlertDialog.Builder adb = new AlertDialog.Builder(context);
            adb.setMessage(R.string.dialog_fill_message);
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_delete_negative_button, myClickListener);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListener);
            return adb.create();
        }
        return onCreateDialog(id, context);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    flask++;
                    CharacterInfoFragment.updateCharacterInfo();
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };


}
