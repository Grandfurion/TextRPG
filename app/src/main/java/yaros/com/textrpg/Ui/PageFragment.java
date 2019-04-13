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

public class PageFragment extends Fragment {

    public static final String TAG = "PageFragment";

    public static int id = 0;

    public static PageFragment сreateFragment() {
        return new PageFragment();
    }

    public void Update(int new_id, TextView pageText, LinearLayout linearLayout){
        id = new_id;

        pageText.setText(MainActivity.chapters.get(id).CHAPTER_TEXT);
        int i = 0;
        for (int variant :MainActivity.chapters.get(id).CHAPTER_VARIANTIDS) {
            Button button = new Button(this.getContext());
            button.setText((MainActivity.chapters.get(id).CHAPTER_VARIANTIDS[i]));
            linearLayout.addView(button);
            i++;
            //СОЗДАЕМ КНОПКИ ДИНАМИЧНО (ИЛИ НЕ ОЧЕНЬ)
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

        Update(id, pageText, linearLayout);
        //MainActivity.chapters.get(id);

        super.onViewCreated(view, savedInstanceState);
    }
}
