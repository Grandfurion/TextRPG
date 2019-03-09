package yaros.com.textrpg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ViewFlipper;

import java.security.Key;
import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;

public class MainMenuFragment extends Fragment {

    public final String TAG = "MainMenuFragment";

    public static MainMenuFragment Create(){
        return new MainMenuFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_menu_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Button button = getView().findViewById(R.id.startButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.chapters =

                //FragmentManager.beginTransaction
            }
        });

        super.onViewCreated(view, savedInstanceState);
    }
}
