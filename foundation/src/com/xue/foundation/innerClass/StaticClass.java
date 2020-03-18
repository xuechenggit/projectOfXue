package com.xue.foundation.innerClass;

public class StaticClass {

    static class InnerStaticClass{
        public void visit() {
            System.out.println("ddd");
            System.out.println("static class visit");
        }
    }
}
