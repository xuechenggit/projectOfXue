package com.xue.foundation.compare;


import java.io.File;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Function;


public class CompareBasicType {

    public static void main(String[] args) {
        /*Integer a = new Integer(127);
        Integer b = 127;
        int c = 127;

        System.out.println(a == b); // false未找到item
        System.out.println(a == c); //true
        System.out.println(b == c); //true

        Integer d = 128;
        Integer e = 128;
        System.out.println(d == e); //false

        String temp = "v2";
        System.out.println(temp.charAt(0) + "    " + temp.charAt(1));
        System.out.println((int)temp.charAt(1));

        Map<String, Function> map = new HashMap<>();

        map.put("a", s -> {
            return "a";
        });
        System.out.println(map.get("a").apply("t"));
*/
        File f = new File("F:\\xml\\caea810d-f9b3-45b8-ae01-8e23735a34c7\\model.xml");
        String name = f.getName();
        System.out.println(name);
        String[] ss = f.getName().split("\\.");
        for (int i = 0; i < ss.length; i++) {
            System.out.println(ss);
        }
        System.out.println(ss[0]);

    }
}
