package yaros.com.textrpg;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {

    public final String TAG = "PageFragment";

    public static int id = 0;

    public static PageFragment Create() {
        return new PageFragment();
    }

    public static void Update(int new_id, TextView pageText){
        id = new_id;

        pageText.setText(MainActivity.chapters.get(id).CHAPTER_TEXT);
        for (int variant :MainActivity.chapters.get(id).CHAPTER_VARIANTIDS) {
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

        Update(id, pageText);
        //MainActivity.chapters.get(id);

        super.onViewCreated(view, savedInstanceState);
    }
}