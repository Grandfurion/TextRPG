package yaros.com.textrpg.Ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import yaros.com.textrpg.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PageFragment extends Fragment {

    public static final String TAG = "PageFragment";

    public static int id = 0;

    public static PageFragment сreateFragment() {
        return new PageFragment();
    }

    public static ArrayList<Button> buttons = new ArrayList<>();

    public void Update(int new_id, TextView pageText) {
        id = new_id;

        pageText.setText(MainActivity.chapters.get(id).CHAPTER_TEXT);
        for (Button b : buttons) {
            b.setVisibility(View.GONE);
        }

        int j = 0;
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
