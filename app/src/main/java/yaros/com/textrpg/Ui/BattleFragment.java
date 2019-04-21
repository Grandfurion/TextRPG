package yaros.com.textrpg.Ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.R;

public class BattleFragment extends Fragment {

    public static final String TAG = "BattleFragment";

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

        super.onViewCreated(view, savedInstanceState);
    }
}
