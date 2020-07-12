package com.mzl.utils;

import java.util.Random;
import java.util.Set;

/**
 * @ClassName :   RandomUtil
 * @Description: 随机生成6位验证码工具类
 * @Author: 21989
 * @CreateDate: 2020/7/11 11:10
 * @Version: 1.0
 */
public class RandomUtil {

    //随机生成字符串验证码
    public static String getRandom() {
        //创建获取是数组
        String[] letters = new String[]{
                "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
                "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"
        };

        String code = "";
        for (int i = 0; i < 6; i++) {
            code += letters[(int)Math.floor(Math.random() * letters.length)];
        }
        System.out.println(code);
        return code;
    }
}
