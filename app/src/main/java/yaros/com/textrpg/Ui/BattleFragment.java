package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import yaros.com.textrpg.Battle.Battle;
import yaros.com.textrpg.R;

public class BattleFragment extends Fragment {

    public static final String TAG = "BattleFragment";

    public static StringBuilder Log;

    //public PageFragment pageFragment;

    public static BattleFragment create(/*PageFragment pageFragment*/){
        //pageFragment = pageFragment;
        return new  BattleFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.battle_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        TextView BattleLog = getView().findViewById(R.id.battleLog);

        MainActivity.bottomNavigationView.setVisibility(View.GONE);
        BattleLog.setText(Log);

        if(MainActivity.battleChapters.get(PageFragment.id).size() == 1){
            Battle battle = new Battle
                    (MainActivity.mainCharacter, MainActivity.battleChapters.get(PageFragment.id).get(0), getView().findViewById(R.id.battleLog));

            battle.MainBattle();
        }else {
            Battle battle = new Battle
                    (MainActivity.mainCharacter, MainActivity.battleChapters.get(PageFragment.id), getView().findViewById(R.id.battleLog));
            //battle.battleLog = getView().findViewById(R.id.battleLog);
            battle.MainModBattle();
            //battle.battleLog.clearComposingText();
        }
        Button battleEndBattle = getView().findViewById(R.id.buttonEndBattle);
        battleEndBattle.setVisibility(View.VISIBLE);
        battleEndBattle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
                FragmentManager fm = getActivity().getSupportFragmentManager();
            PageFragment.layoutBattleFragment.setVisibility(View.GONE);
            fm.findFragmentByTag(PageFragment.TAG);
            fm.beginTransaction().remove(PageFragment.currentBattleFragment).commit();

            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
