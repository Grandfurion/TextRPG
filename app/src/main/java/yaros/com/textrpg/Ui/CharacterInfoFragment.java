package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
            textViewSword.setText("Меч: " + MainCharacter.sword);
        }catch(Exception e){
            Log.e("Warn", "Item did'nt generated yet");
        }
    }
}
