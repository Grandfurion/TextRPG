package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import yaros.com.textrpg.R;

public class SelectSpellsFragment extends Fragment {

    public static final String TAG = "SelectSpellsFragment";

    public int i;
    TextView LogTv;

    Button levitation;
    Button fire;
    Button illusion;
    Button strenght;
    Button weakness;
    Button healing;
    Button sweem;


    public static SelectSpellsFragment create(){
        return new SelectSpellsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.select_spells_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        levitation = getView().findViewById(R.id.levitationSpell);
        fire = getView().findViewById(R.id.fireSpell);
        illusion = getView().findViewById(R.id.illusionSpell);
        strenght = getView().findViewById(R.id.strenghtSpell);
        weakness = getView().findViewById(R.id.weaknessSpell);
        healing = getView().findViewById(R.id.healingSpell);
        sweem = getView().findViewById(R.id.sweemSpell);

        levitation.setOnClickListener(levitationOCL);
        fire.setOnClickListener(fireOCL);
        illusion.setOnClickListener(illusionOCL);
        strenght.setOnClickListener(strenghtOCL);
        weakness.setOnClickListener(weaknessOCL);
        healing.setOnClickListener(healingOCL);
        sweem.setOnClickListener(sweemOCL);

        LogTv = getView().findViewById(R.id.SpellsLog);
        i = 0;

        super.onViewCreated(view, savedInstanceState);
    }

    View.OnClickListener levitationOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_levitation));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_levitation));
            i++;
            if (i >= 10){
                Complete();
            }
        }
    };

    View.OnClickListener fireOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_fire));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_fire));
            i++;
            if (i >= 10){
                Complete();
            }
        }
    };

    View.OnClickListener illusionOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_illusion));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_illusion));
            i++;
            if (i >= 10){
                Complete();
            }        }
    };

    View.OnClickListener strenghtOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_strenght));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_strenght));
            i++;
            if (i >= 10){
                Complete();
            }        }
    };

    View.OnClickListener weaknessOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_weakness));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_weakness));
            i++;
            if (i >= 10){
                Complete();
            }        }
    };

    View.OnClickListener healingOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_healing));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_healing));
            i++;
            if (i >= 10){
                Complete();
            }        }
    };

    View.OnClickListener sweemOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + getString(R.string.spell_sweem));
            CharacterInfoFragment.spells.get(i).setText(getString(R.string.spell_sweem));
            i++;
            if (i >= 10){
                Complete();
            }        }
    };

    public void Complete(){
        MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
        FragmentManager fm = getActivity().getSupportFragmentManager();
        PageFragment.layoutBattleFragment.setVisibility(View.GONE);
        fm.beginTransaction().remove(PageFragment.currentBattleFragment).commit();

    }
}
