package yaros.com.textrpg.Ui;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import yaros.com.textrpg.Battle.Battle;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class PageFragment extends Fragment {

    public static final String TAG = "PageFragment";

    public static int id = 0;

    public static PageFragment сreateFragment() {
        return new PageFragment();
    }

    public static ArrayList<Button> buttons = new ArrayList<>();

    @SuppressLint("ResourceAsColor")
    public void Update(int new_id, TextView pageText) {
        id = new_id;
        if (id == 568){
            MainActivity.mainCharacter.sword = "Смерть Орков";
        }else if(id == 126){
            MainActivity.mainCharacter.sword = "Меч Зеленого Рыцаря";
        }


        pageText.setText(MainActivity.chapters.get(id).CHAPTER_TEXT);
        for (Button b : buttons) {
            b.setVisibility(View.GONE);
        }

        int j = 0;

        if (MainActivity.battleChapters.get(id) != null){
            buttons.get(j).setText("Начать Битву");
            buttons.get(j).setVisibility(View.VISIBLE);
            buttons.get(j).setBackgroundColor(R.color.colorAccent);
            buttons.get(j).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container , new BattleFragment(),BattleFragment.TAG).commit();
                    if(MainActivity.battleChapters.get(id).size() == 1){
                        Battle battle = new Battle
                                (MainActivity.mainCharacter, MainActivity.battleChapters.get(id).get(0), getView().findViewById(R.id.battleLog));
                        //battle.battleLog = getView().findViewById(R.id.battleLog);g
                        battle.battleLog.setText("ads");// тут ошибка nullPointerEx
                        battle.MainBattle();
                        //battle.battleLog.clearComposingText();
                    }else {
                        Battle battle = new Battle
                                (MainActivity.mainCharacter, MainActivity.battleChapters.get(id));
                        //battle.battleLog = getView().findViewById(R.id.battleLog);
                        battle.MainModBattle();
                        //battle.battleLog.clearComposingText();
                    }

                }
            });
            j++;
        }

        for (int i : MainActivity.getChapters().get(id).CHAPTER_VARIANTIDS) {
            Button b = buttons.get(j);
            b.setVisibility(View.VISIBLE);
            b.setText(String.valueOf(i));
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Update(i, pageText);
                }
            });
            j++;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.page_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        final TextView pageText = getView().findViewById(R.id.pageText);
        final LinearLayout linearLayout = getView().findViewById(R.id.buttonsLayout);

        buttons.add(getView().findViewById(R.id.button1));
        buttons.add(getView().findViewById(R.id.button2));
        buttons.add(getView().findViewById(R.id.button3));
        buttons.add(getView().findViewById(R.id.button4));
        buttons.add(getView().findViewById(R.id.button5));
        buttons.add(getView().findViewById(R.id.button6));

        Update(id, pageText);
        //MainActivity.chapters.get(id);

        super.onViewCreated(view, savedInstanceState);
    }
}
