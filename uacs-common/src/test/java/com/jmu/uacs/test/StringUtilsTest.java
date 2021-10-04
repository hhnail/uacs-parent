package com.jmu.uacs.test;

import com.jmu.uacs.enums.DateTemplate;
import com.jmu.uacs.util.StringUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtilsTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat(DateTemplate.yyyyMMdd.toString());

        String dateStr1 = "2021-10-20";
        String date2 = "2021-10-29";

        Date date1 = StringUtils.parseString2Date(dateStr1, DateTemplate.yyyyMMdd);
        StringUtils.parseString2Date(date2, DateTemplate.yyyyMMdd);

        System.out.println(sdf.format(date1));

    }

    @Test
    public void test01(){
        String dateStr1 = "2021-10-20";
        String date2 = "2021-10-29";

        Date date1 = StringUtils.parseString2Date(dateStr1, DateTemplate.yyyyMMdd);
        StringUtils.parseString2Date(date2, DateTemplate.yyyyMMdd);

        System.out.println(date1);
    }

}
