package yaros.com.textrpg;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.ChaptersCreator.ChaptersCreator;

public class MainActivity extends AppCompatActivity {

    public static HashMap<Integer, Chapter> chapters;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chapters = ChaptersCreator.Generate(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, MainMenuFragment.Create()).commit();
     }

}
