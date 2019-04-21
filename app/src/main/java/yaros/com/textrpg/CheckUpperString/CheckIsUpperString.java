package yaros.com.textrpg.CheckUpperString;

import java.util.ArrayList;
import java.util.Arrays;

public class CheckIsUpperString{

    public static boolean checkIsUpperString(String str) {
        boolean flag = false;

        ArrayList<String> rows = cutToRows(str);
        //if(rows.size() > 2)
        //{flag = true;}
        for (String row : rows) {

            int count = 0;
            for (int i = 0; i < row.length(); i++) {

                if (row.charAt(i) == ' ' || Character.isUpperCase(row.charAt(i)) || row.charAt(i)== '\n'
                    || row.charAt(i) == '_') {
                    count++;
                }


             }
           // if(row.equals(row.toUpperCase())){
           //     flag = true;
           // }

            if((count == row.length()) ? true : false){
                flag = true;
            }
        }
        //return (count == str.length()) ? true : false;*/
        return flag;
    }


    public static ArrayList<String> cutToRows(String chapterText) {
        return new ArrayList<String>(Arrays.asList(chapterText.split("\n")));
    }
}
