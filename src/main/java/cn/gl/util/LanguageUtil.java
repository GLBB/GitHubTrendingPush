package cn.gl.util;

public class LanguageUtil {

    public static boolean isChinese(Character c) {
        return c >= 0x4E00 && c <= 0x9FA5;
    }

    /**
     * 判断是否是中文
     */
    public static boolean isChinese(String str){
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isChinese(c))
                return true;
        }
        return false;
    }
}
