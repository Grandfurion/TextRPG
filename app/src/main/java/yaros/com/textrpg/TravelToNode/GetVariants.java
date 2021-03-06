package yaros.com.textrpg.TravelToNode;

import android.content.Context;

import java.util.ArrayList;

import yaros.com.textrpg.Ui.MainActivity;

public class GetVariants {

    static Integer num;

   // public static StringBuilder str;

    public static int[] getVariants(int chapterTextId, Context context){
        String ChapterText = context.getString(chapterTextId);
        ArrayList<Integer> variants = new ArrayList<Integer>();

        for (num = 0; num < ChapterText.length();num++){
            if (ChapterText.charAt(num) == '-' || ChapterText.charAt(num) == '('){
                if (ChapterText.charAt(num) == '-'){
                    num++;
                }
                num++;
                StringBuilder str = new StringBuilder();
                //while (Character.isDigit(ChapterText.charAt(num))) {
                if (Character.isDigit(ChapterText.charAt(num))){
                    str.append(String.valueOf(ChapterText.charAt(num)));
                    AppendNewChar(str, ChapterText, num);

                    int parNum = Integer.parseInt(str.toString());
                    variants.add(parNum);
                }

            }
        }

        int[] arr = new int[variants.size()];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = variants.get(i);
        }
        return arr;

    }


    public static void AppendNewChar(StringBuilder str, String text, Integer num){
        num++;
        if(Character.isDigit(text.charAt(num))){
            str.append(text.charAt(num));
            AppendNewChar(str, text, num);
        }else {
            return;
        }
    }






    /*public static String str;

    public static int[] getVariants(int chapterTextId, Context context){
        String ChapterText = context.getString(chapterTextId);
        ArrayList<Integer> variants = new ArrayList<Integer>();

        for (int num = 0; num < ChapterText.length();num++){
            if (ChapterText.charAt(num) == '-' || ChapterText.charAt(num) == '('){
                if (ChapterText.charAt(num) == '-'){
                    num++;
                }
                num++;
                str = null;
                while (Character.isDigit(ChapterText.charAt(num))){
                    if(str == null) {
                        str = String.valueOf(ChapterText.charAt(num));
                    }else{
                        str += ChapterText.charAt(num);
                    }
                    //str = "2";
                    num++;
                    int parNum = Integer.parseInt(str);
                    if (parNum != 0){
                        variants.add(parNum);
                    }
                }

            }
        }

        int[] arr = new int[variants.size()];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = variants.get(i);
        }
        return arr;

    }*/

}
