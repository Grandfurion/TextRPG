package yaros.com.textrpg.CheckUpperString;

public class CheckIsUpperString implements ChackIsUpperString {
    @Override
    public boolean checkIsUpperString(String str) {
        if (str.length() == 0)
            return false;

        int count = 0;
        for(int i = 0; i < str.length(); i++){

            if(str.charAt(i) == ' ' || Character.isUpperCase(str.charAt(i))){
                count++;
            }
        }
        return (count == str.length()) ? true : false;
    }
}
