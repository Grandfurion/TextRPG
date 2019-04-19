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
                //while ( ChapterText.charAt(first) > 47 && ChapterText.charAt(first) < 58)
                while (ChapterText.charAt(first) == 1 || ChapterText.charAt(first) == 2 || ChapterText.charAt(first) == 3 ||
                        ChapterText.charAt(first) == 4 || ChapterText.charAt(first) == 5 || ChapterText.charAt(first) == 6 ||
                        ChapterText.charAt(first) == 7 || ChapterText.charAt(first) == 8 || ChapterText.charAt(first) == 9 ||
                        ChapterText.charAt(first) == 0) {
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
