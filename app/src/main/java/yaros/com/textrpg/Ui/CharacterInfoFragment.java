package yaros.com.textrpg.Ui;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.R;

public class CharacterInfoFragment extends Fragment {

    public static final String TAG = "CharacterInfoFragment";

    static ArrayList<TextView> items;
    static ArrayList<TextView> spells;

    Button addSpells;

    static TextView textViewSword;
    static TextView tvStamina;
    static TextView tvMastery;
    static TextView tvFortune;
    static TextView tvMoney;
    static Button buttonDrink;
    static Button buttonFill;
    static TextView tvFlask;

    static int itemNum;
    static int spellNum;

    static EditText editText;
    static EditText editTextSpells;

    static int selectToDeleteTvNum;
    static int selectToDeleteTvNumSpell;
    static AlertDialog alertDialogDelete;
    public final int DIALOG_ADD = 1;
    public final int DIALOG_DELETE = 2;
    public final int DIALOG_ADD_SPELL = 3;
    public final int DIALOG_DELETE_SPELL = 4;

    public static CharacterInfoFragment create(){
        return new CharacterInfoFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.character_info_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        textViewSword = getView().findViewById(R.id.textViewSword);
        tvStamina = getView().findViewById(R.id.textViewStamina1);
        tvMastery = getView().findViewById(R.id.textViewMastery1);
        tvFortune = getView().findViewById(R.id.textViewFortune1);
        tvMoney = getView().findViewById(R.id.textViewGold1);
        tvFlask = getView().findViewById(R.id.textViewFlask);
        buttonDrink = getView().findViewById(R.id.flaskDrink);
        buttonFill = getView().findViewById(R.id.flaskFill);


        buttonDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.mainCharacter.Drink(getContext());
            }
        });
        buttonFill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.mainCharacter.Fill(getContext());
            }
        });

        Button addMoneyButton = getView().findViewById(R.id.buttonAddMoney);
        addMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.mainCharacter.money++;
                CharacterInfoFragment.updateCharacterInfo();
            }
        });

        Button getMoneyButton = getView().findViewById(R.id.buttonGetMoney);
        getMoneyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (MainActivity.mainCharacter.money <=0 ){
                    return;
                }
                MainActivity.mainCharacter.money--;
                CharacterInfoFragment.updateCharacterInfo();
            }
        });

        Button buttonCheckFortune = getView().findViewById(R.id.buttonCheckFortune);
        buttonCheckFortune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast ifLuck = new Toast(getContext());
                if (MainActivity.mainCharacter.fortune <= 0){
                    ifLuck.makeText(getContext(), R.string.luck_check_no_fortune, Toast.LENGTH_SHORT).show();
                    return;
                }
                boolean luck = MainActivity.mainCharacter.checkFortune();
                if (luck){
                    ifLuck.makeText(getContext(), R.string.luck_check_true, Toast.LENGTH_SHORT).show();
                }else {
                    ifLuck.makeText(getContext(), R.string.luck_check_false, Toast.LENGTH_SHORT).show();
                }
                CharacterInfoFragment.updateCharacterInfo();
            }
        });

        items = new ArrayList<>(9);
        spells = new ArrayList<>(10);

        updateCharacterInfo();

        /*
        for (int i = 0; i < 9; i++){
            items.add(getView().findViewById((getResources().getIdentifier(("textViewInventory" + i), "id", getContext().getPackageName()))));
        }*/

        //////////////////////////////////////////////////////////////////////////////////////////////////

        itemNum = 0;
        spellNum = 0;

        AlertDialog alertDialog = onCreateDialog(DIALOG_ADD);
        alertDialogDelete =  onCreateDialog(DIALOG_DELETE);
        AlertDialog alertDialogAddSpell = onCreateDialog(DIALOG_ADD_SPELL);
        AlertDialog alertDialogDeleteSpell = onCreateDialog(DIALOG_DELETE_SPELL);

        for (int i = 0; i < 9; i++) {
            items.add(getView().findViewById(this.getResources().getIdentifier(("textViewInventory" + i),
                    "id", getContext().getPackageName())));
            items.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectToDeleteTvNum = items.indexOf(v);
                    alertDialogDelete.show();
                }
            });
        }

        for (int i = 0; i < 10; i++) {
            spells.add(getView().findViewById(this.getResources().getIdentifier(("textViewSpell" + i),
                    "id", getContext().getPackageName())));
            spells.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectToDeleteTvNumSpell = spells.indexOf(v);
                    alertDialogDeleteSpell.show();
                }
            });
        }


        addSpells = getView().findViewById(R.id.buttonAddSpell);
        addSpells.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (spellNum < 10) {
                    alertDialogAddSpell.show();
                } else {
                    Toast.makeText(getContext(), "Максимум заклинаний", Toast.LENGTH_SHORT).show();
                }
            }
        });

        FloatingActionButton fab = getView().findViewById(R.id.inventoryFloatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemNum < 9) {
                    alertDialog.show();
                } else {
                    Toast.makeText(getContext(), "Максимум предметов", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //CODE
        super.onViewCreated(view, savedInstanceState);
    }

    public static void updateCharacterInfo(){
        try {
            textViewSword.setText("Меч: " + MainActivity.mainCharacter.sword);
            tvStamina.setText("" + MainActivity.mainCharacter.stamina + "/" + MainActivity.mainCharacter.maxStamina);
            tvMastery.setText("" + MainActivity.mainCharacter.mastery);
            tvFortune.setText("" + MainActivity.mainCharacter.fortune);
            tvMoney.setText("" + MainActivity.mainCharacter.money);
            tvFlask.setText("Фляга " + MainActivity.mainCharacter.flask + "/ 2");

        }catch(Exception e){
            Log.e("Warn", "Item did'nt generated yet");
        }
    }




    protected AlertDialog onCreateDialog(int id) {
        if (id == DIALOG_ADD) {
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setTitle(R.string.inventory_add_item);
            adb.setMessage(R.string.information_dialog_message);
            EditText dialogEditText = new EditText(getContext());
            adb.setView(dialogEditText);
            editText = dialogEditText;
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_positive_button, myClickListener);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListener);
            return adb.create();
        }else if (id == DIALOG_DELETE) {
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setMessage(R.string.inventory_use_drop_item);
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_delete_negative_button, myClickListenerDeleteDialog);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListenerDeleteDialog);
            return adb.create();
        }else if(id == DIALOG_ADD_SPELL){
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setTitle(R.string.inventory_add_spell);
            adb.setMessage(R.string.information_dialog_message);
            EditText dialogSpellEditText = new EditText(getContext());
            adb.setView(dialogSpellEditText);
            editTextSpells = dialogSpellEditText;
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_positive_button, myClickListenerAddSpell);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListenerAddSpell);
            return adb.create();
        }else if (id == DIALOG_DELETE_SPELL) {
            AlertDialog.Builder adb = new AlertDialog.Builder(getContext());
            adb.setMessage(R.string.inventory_use_spell);
            adb.setIcon(R.drawable.ic_information_24dp);
            adb.setPositiveButton(R.string.dialog_delete_negative_button, myClickListenerDeleteSpellDialog);
            adb.setNegativeButton(R.string.dialog_negative_button, myClickListenerDeleteSpellDialog);
            return adb.create();
        }
        return onCreateDialog(id);
    }

    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    if (!editText.getText().toString().equals("")) {
                        items.get(itemNum).setVisibility(View.VISIBLE);
                        items.get(itemNum).setText(editText.getText());
                        itemNum++;
                    }
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };


        DialogInterface.OnClickListener myClickListenerAddSpell = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case Dialog.BUTTON_POSITIVE:
                        if (!editTextSpells.getText().toString().equals("")) {
                            spells.get(spellNum).setVisibility(View.VISIBLE);
                            spells.get(spellNum).setText(editTextSpells.getText());
                            spellNum++;
                        }
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        break;
                }
            }
        };

    DialogInterface.OnClickListener myClickListenerDeleteDialog = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    for (int i = selectToDeleteTvNum; i < 8; i++){
                        items.get(i).setText(items.get(i + 1).getText());
                    }
                    itemNum--;
                    items.get(itemNum).setText("");
                    items.get(itemNum).setVisibility(View.GONE);
                    break;
                case Dialog.BUTTON_NEGATIVE:
                    break;
            }
        }
    };

        DialogInterface.OnClickListener myClickListenerDeleteSpellDialog = new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case Dialog.BUTTON_POSITIVE:
                        for (int i = selectToDeleteTvNumSpell; i < 9; i++){
                            spells.get(i).setText(spells.get(i + 1).getText());
                        }
                        spellNum--;
                        spells.get(spellNum).setText("");
                        spells.get(spellNum).setVisibility(View.GONE);
                        break;
                    case Dialog.BUTTON_NEGATIVE:
                        break;
                }
            }
        };


}
