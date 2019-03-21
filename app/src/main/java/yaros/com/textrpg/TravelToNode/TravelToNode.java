package yaros.com.textrpg.TravelToNode;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class TravelToNode {

    public int[] getChapterVariants(String ChapterText, char separator) {

        ArrayList<Integer> travel = new ArrayList<Integer>();

        for (int first = 0; first < ChapterText.length(); first++)
        {
            if (ChapterText.charAt(first) == separator)
            {
                if (separator == '—')
                {
                    first++;
                }
                StringBuilder StrBulid = new StringBuilder();
                while ( ChapterText.charAt(first) > 47 && ChapterText.charAt(first) < 58)
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
