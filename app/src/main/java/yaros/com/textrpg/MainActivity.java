package yaros.com.textrpg;

import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.ChaptersCreator.ChaptersCreator;

public class MainActivity extends AppCompatActivity {

    public static HashMap<Integer, Chapter> chapters;

    public static BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chapters = ChaptersCreator.Generate(this);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setVisibility(View.GONE);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, MainMenuFragment.Create()).commit();
     }

}
