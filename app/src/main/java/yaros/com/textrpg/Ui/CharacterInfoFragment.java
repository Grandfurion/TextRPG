package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.R;

public class CharacterInfoFragment extends Fragment {

    public static final String TAG = "CharacterInfoFragment";

    static ArrayList<TextView> spells;
    static ArrayList<TextView> items;

    static TextView textViewSword;
    static TextView tvStamina;
    static TextView tvMastery;
    static TextView tvFortune;

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

        Button buttonCheckFortune = getView().findViewById(R.id.buttonCheckFortune);
        buttonCheckFortune.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean luck = MainActivity.mainCharacter.checkFortune();
                Toast ifLuck = new Toast(getContext());
                if (luck){
                    ifLuck.makeText(getContext(), R.string.luck_check_true, Toast.LENGTH_SHORT).show();
                }else {
                    ifLuck.makeText(getContext(), R.string.luck_check_false, Toast.LENGTH_SHORT).show();
                }
                CharacterInfoFragment.updateCharacterInfo();
            }
        });

        spells = new ArrayList<>(10);
        items = new ArrayList<>(9);

        updateCharacterInfo();

        for (int i = 0; i < 10; i++){
            spells.add(getView().findViewById((getResources().getIdentifier(("textViewSpell" + i), "id", getContext().getPackageName()))));
        }
        for (int i = 0; i < 9; i++){
            items.add(getView().findViewById((getResources().getIdentifier(("textViewInventory" + i), "id", getContext().getPackageName()))));
        }

        super.onViewCreated(view, savedInstanceState);
    }

    public static void updateCharacterInfo(){
        try {
            textViewSword.setText("Меч: " + MainActivity.mainCharacter.sword);
            tvStamina.setText(MainActivity.mainCharacter.stamina);
            tvMastery.setText(MainActivity.mainCharacter.mastery);
            tvFortune.setText(MainActivity.mainCharacter.fortune);

        }catch(Exception e){
            Log.e("Warn", "Item did'nt generated yet");
        }
    }
}
