package util;

import java.time.LocalDateTime;

public class Util {
    public static void printLog(String msg){
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now + " " + msg);
    }
}