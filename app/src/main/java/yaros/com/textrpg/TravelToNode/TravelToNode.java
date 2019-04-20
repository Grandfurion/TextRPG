package yaros.com.textrpg.TravelToNode;

import android.content.Context;

import java.nio.charset.Charset;
import java.util.ArrayList;

import yaros.com.textrpg.Ui.MainActivity;


public class TravelToNode {

    public int[] getChapterVariants(String ChapterText) {

        Context context;

        ArrayList<Integer> travel = new ArrayList<Integer>();

        for (int first = 0; first <  ChapterText.length(); first++)
        {
            if (ChapterText.charAt(first) == '—' || ChapterText.charAt(first) == '(')
            {
                if (ChapterText.charAt(first) == '—')
                {
                    first++;
                }
                StringBuilder StrBulid = new StringBuilder();
                while (Character.isDigit(ChapterText.charAt(first)))
                {
                    StrBulid.append(ChapterText.charAt(first + 1));
                    first++;
                }
                int parNum = Integer.parseInt(StrBulid.toString());

                if (parNum != 0)
                {
                    travel.add(parNum);
                }
            }
        }

        int[] arr = new int[travel.size()];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = travel.get(i);
        }
        return arr;
    }
}
