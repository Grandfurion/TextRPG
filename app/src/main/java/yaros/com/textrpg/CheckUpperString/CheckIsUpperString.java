package yaros.com.textrpg.CheckUpperString;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckIsUpperString implements ChackIsUpperString {
    @Override
    public boolean checkIsUpperString(String str) {
        boolean flag = false;

        ArrayList<String> rows = cutToRows(str);
        for (String row : rows) {

            int count = 0;
            for (int i = 0; i < row.length(); i++) {

                if (row.charAt(i) == ' ' || Character.isUpperCase(row.charAt(i))) {
                    count++;
                }
            }
            if((count == row.length()) ? true : false){
                flag = true;
            }
        }
        //return (count == str.length()) ? true : false;
        return flag;
    }

    @Override
    public ArrayList<String> cutToRows(String chapterText) {
        return new ArrayList<String>(Arrays.asList(chapterText.split("\\n")));
    }
}
