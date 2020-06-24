package com.xue.foundation.innerClass;

public class Outer {
    //成员内部类
    class Inner{
        public void InnerFunction() {
            System.out.println("");
        }
    }
    //局部内部类
    public void test() {
        class InnerClass {
            private void InnerFunction() {
                System.out.println("");
            }
        }
    }
    //匿名内部类
    public void test1() {
        new Service(){
            @Override
            public void method() {

            }
        };
    }
    interface Service{
        void method();
    }
}
