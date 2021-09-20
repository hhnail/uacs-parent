package com.jmu.uacs.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateUtil {

    private static SimpleDateFormat yMdFormat = new SimpleDateFormat("yyyy-MM-dd");

    public static String parseToFormatTime(Date date){
        return yMdFormat.format(date);
    }

}
