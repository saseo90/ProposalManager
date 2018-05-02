package org.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonUtil {
    /**
     * 파라미터의 값이 숫자만 일 때 True
     * @param text
     * @return
     */
    public static Boolean matchesNumber(String text) {
        Pattern p = Pattern.compile("(^[0-9]*$)");//숫자만
        Matcher m = p.matcher(text);
        Boolean flag = m.matches();
        return flag;
    }

}
