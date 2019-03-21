package com.xiaoniu.tools.Generator;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Random;

public class ChineseCharUtils {
    private static Random random = new Random(new Date().getTime());

    public static String genOneChineseChars() {
        String str = null;
        int highPos = (176 + Math.abs(random.nextInt(39)));
        int lowPos = 161 + Math.abs(random.nextInt(93));
        byte[] b = new byte[] { (new Integer(highPos)).byteValue(),
            (new Integer(lowPos)).byteValue() };

        try {
            str = new String(b, "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return str;
    }

    public static String genFixedLengthChineseChars(int length) {
        String str = "";
        for (int i = length; i > 0; i--) {
            str = str + genOneChineseChars();
        }

        return str;
    }

    public static String genRandomLengthChineseChars(int start, int end) {
        String str = "";
        int length = random.nextInt(end + 1);
        if (length < start) {
            str = genRandomLengthChineseChars(start, end);
        } else {
            for (int i = 0; i < length; i++) {
                str = str + genOneChineseChars();
            }
        }
        return str;
    }

    public static void main(String args[]) {
        System.out.println(genOneChineseChars());
        System.out.println(genFixedLengthChineseChars(20));
        System.out.println(genRandomLengthChineseChars(1, 10));
    }
}
