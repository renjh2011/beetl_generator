package com.huazi.generator.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GeneratorUtil {

    public static String underline2Camel(String line,boolean smallCamel){
        if(line==null||"".equals(line)){
            return "";
        }
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("([A-Za-z\\d]+)(_)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(smallCamel&&matcher.start()==0?Character.toLowerCase(word.charAt(0)):Character.toUpperCase(word.charAt(0)));
            int index=word.lastIndexOf('_');
            if(index>0){
                sb.append(word.substring(1, index).toLowerCase());
            }else{
                sb.append(word.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
    /**
     * 驼峰法转下划线
     * @param line 源字符串
     * @return 转换后的字符串
     */
    public static String camel2Underline(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        line=String.valueOf(line.charAt(0)).toUpperCase().concat(line.substring(1));
        StringBuffer sb=new StringBuffer();
        Pattern pattern=Pattern.compile("[A-Z]([a-z\\d]+)?");
        Matcher matcher=pattern.matcher(line);
        while(matcher.find()){
            String word=matcher.group();
            sb.append(word.toUpperCase());
            sb.append(matcher.end()==line.length()?"":"_");
        }
        return sb.toString();
    }

    /**
     * 首字母大写
     * @param line
     * @return
     */
    public static String capFirst(String line){
        if(line==null||"".equals(line)){
            return "";
        }
        String firstLetter=line.substring(0,1).toUpperCase();
        String leftLetter=line.substring(1);
        return firstLetter+leftLetter;
    }

    public static void main(String[] args) {
        String line="im_have_an_ipang3_pig";
        String camel=underline2Camel(line,true);
        System.out.println(camel);
        System.out.println(camel2Underline(camel));
        System.out.println(capFirst(camel));
    }
}
