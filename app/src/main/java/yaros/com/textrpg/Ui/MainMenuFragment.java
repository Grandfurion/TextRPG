package yaros.com.textrpg.Ui;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import yaros.com.textrpg.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class MainMenuFragment extends Fragment {

    public static final String TAG = "MainMenuFragment";

    public static MainMenuFragment create(){
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
        button.setOnClickListener(v -> {
            FragmentManager fragmentManager = getFragmentManager();
            MainActivity.bottomNavigationView.setVisibility(View.VISIBLE);
            MainActivity.bottomNavigationView.setSelectedItemId(R.id.chapter_info);
            fragmentManager.beginTransaction().remove(fragmentManager.findFragmentByTag(MainActivity.displayedTag));
        });
        super.onViewCreated(view, savedInstanceState);
    }

}
