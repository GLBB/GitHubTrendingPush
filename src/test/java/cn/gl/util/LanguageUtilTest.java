package cn.gl.util;

import org.junit.Test;

import java.util.ArrayList;

public class LanguageUtilTest {
    @Test
    public void test1(){
        ArrayList<Boolean> r = new ArrayList<>();
        r.add(LanguageUtil.isChinese("aaaa"));
        r.add(LanguageUtil.isChinese("aaaaa."));
        r.add(LanguageUtil.isChinese("aaaaa。")); // false
        r.add(LanguageUtil.isChinese("水库附近 是否"));
        r.add(LanguageUtil.isChinese(" "));  // 英文输入法的空格
        r.add(LanguageUtil.isChinese(" ")); // 中文输入法的空格
        r.add(LanguageUtil.isChinese("⏰"));

        for (boolean rs : r){
            System.out.println(rs);
        }
    }
}
