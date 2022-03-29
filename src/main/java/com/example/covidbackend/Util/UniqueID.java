package com.example.covidbackend.Util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;


import java.util.Date;


public class UniqueID {

    public String getTheUniqueId(){
        Date now = DateUtil.date();
        String date = DateUtil.format(now, "yyyyMMddHHmmss");
        String randomString = RandomUtil.randomNumbers(8);
        String tmp = date + randomString;
        return  tmp;
    }
}
