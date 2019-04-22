package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.Battle.Battle;
import yaros.com.textrpg.R;

public class BattleFragment extends Fragment {

    public static final String TAG = "BattleFragment";

    public static StringBuilder Log;

    public BattleFragment create(){
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

        BattleLog.setText(Log);

        if(MainActivity.battleChapters.get(PageFragment.id).size() == 1){
            Battle battle = new Battle
                    (MainActivity.mainCharacter, MainActivity.battleChapters.get(PageFragment.id).get(0), getView().findViewById(R.id.battleLog));
            //battle.battleLog = getView().findViewById(R.id.battleLog);g
            battle.battleLog.setText("ads");// тут ошибка nullPointerEx
            battle.MainBattle();
            //battle.battleLog.clearComposingText();
        }else {
            Battle battle = new Battle
                    (MainActivity.mainCharacter, MainActivity.battleChapters.get(PageFragment.id));
            //battle.battleLog = getView().findViewById(R.id.battleLog);
            battle.MainModBattle();
            //battle.battleLog.clearComposingText();
        }


        super.onViewCreated(view, savedInstanceState);
    }
}
