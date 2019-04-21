package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.R;

public class CharacterInfoFragment extends Fragment {

    public static final String TAG = "CharacterInfoFragment";

    ArrayList<TextView> spells;
    ArrayList<TextView> items;

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

        spells = new ArrayList<>(10);
        items = new ArrayList<>(9);

        for (int i = 0; i < 10; i++){
            spells.add(getResources().getIdentifier("textViewSpell" + ))
        }

        super.onViewCreated(view, savedInstanceState);
    }

    public void updateCharacterInfo(){

    }
}
