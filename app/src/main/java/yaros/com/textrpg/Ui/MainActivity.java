package yaros.com.textrpg.Ui;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.HashMap;

import androidx.fragment.app.FragmentTransaction;
import yaros.com.textrpg.Chapter.Chapter;
import yaros.com.textrpg.ChaptersCreator.ChaptersCreator;
import yaros.com.textrpg.Characters.Enemy;
import yaros.com.textrpg.Characters.MainCharacter;
import yaros.com.textrpg.R;
import yaros.com.textrpg.Ui.MainMenuFragment;

public class MainActivity extends AppCompatActivity {

    public static HashMap<Integer, Chapter> chapters;
    public static HashMap<Integer, ArrayList<Enemy>> battleChapters = new HashMap<>();

    public static MainCharacter mainCharacter;

    public static BottomNavigationView bottomNavigationView;

    private static final String KEY_SELECTED_TAG = "KEY_SELECTED_TAG";

    public static String displayedTag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainCharacter = new MainCharacter();

        chapters = ChaptersCreator.Generate(this);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container, MainMenuFragment.create(), "MainMenuFragment").commit();
        displayedTag = "MainMenuFragment";
        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == bottomNavigationView.getSelectedItemId()) return true;
            FragmentManager fm = getSupportFragmentManager();
            switch (menuItem.getItemId()) {
                case R.id.character_info:
                    showFragment(CharacterInfoFragment.TAG, CharacterInfoFragment::create, fm);
                    return true;
                case R.id.chapter_info:
                    showFragment(PageFragment.TAG, PageFragment::сreateFragment, fm);
                    return true;
                case R.id.information:
                    showFragment(InformationFragment.TAG, InformationFragment::create, fm);
                    return true;
                default:
                    return false;
            }
        });
        if (savedInstanceState == null) {
            } else {
                displayedTag = savedInstanceState.getString(KEY_SELECTED_TAG);
            }
        bottomNavigationView.setVisibility(View.GONE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(KEY_SELECTED_TAG, displayedTag);
        super.onSaveInstanceState(outState);
    }


     public static void showFragment(String tag, FragmentFactory fragmentFactory,
                                     FragmentManager fm){
        CharacterInfoFragment.updateCharacterInfo();
         FragmentTransaction tx = fm.beginTransaction();

         Fragment currentFragment = fm.findFragmentByTag(displayedTag);
         if (currentFragment != null) {
             tx.hide(currentFragment);
         }

         Fragment fragment = fm.findFragmentByTag(tag);
         if (fragment != null) {
             tx.show(fragment);
         } else {
             fragment = fragmentFactory.createFragment();
             tx.add(R.id.container, fragment, tag);
         }
         tx.setPrimaryNavigationFragment(fragment);
         displayedTag = tag;

         tx.commit();
     }

     public interface FragmentFactory{
        Fragment createFragment();
     }

     public static HashMap<Integer, Chapter> getChapters(){
        return chapters;
     }

     /*public String mGetString(int resId){
        return this.getString(resId);
     }*/

}
