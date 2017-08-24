package com.oranfish.common;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {

    public static BigDecimal regFirstNumber(String str){
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(str);
        if(m.find()){
            return  new BigDecimal(m.group());
        }else{
            return null;
        }
    }

}
