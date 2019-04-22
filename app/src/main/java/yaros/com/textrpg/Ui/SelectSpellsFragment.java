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


    public SelectSpellsFragment create(){
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

        levitation.setOnClickListener(OCL);
        fire.setOnClickListener(OCL);
        illusion.setOnClickListener(OCL);
        strenght.setOnClickListener(OCL);
        weakness.setOnClickListener(OCL);
        healing.setOnClickListener(OCL);
        sweem.setOnClickListener(OCL);

        LogTv = getView().findViewById(R.id.SpellsLog);
        i = 0;

        super.onViewCreated(view, savedInstanceState);
    }

    View.OnClickListener levitationOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие левитации");
        }
    };

    View.OnClickListener fireOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие огня");
        }
    };

    View.OnClickListener illusionOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие иллюзии");
        }
    };

    View.OnClickListener strenghtOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие силы");
        }
    };

    View.OnClickListener weaknessOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие левитации");
        }
    };

    View.OnClickListener healingOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие левитации");
        }
    };

    View.OnClickListener sweemOCL = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            LogTv.setText(LogTv.getText().toString() + "\n" + "Заклятие левитации");
        }
    };
}
