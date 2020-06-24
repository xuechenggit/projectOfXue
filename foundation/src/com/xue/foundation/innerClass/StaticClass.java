package com.xue.foundation.innerClass;

public class StaticClass {

    static void test(){}

    static class InnerStaticClass{
        public void visit() {
            test();
            System.out.println("ddd");
            System.out.println("static class visit");
        }
    }
}
