package com.xue.foundation.InterfaceAndAbstract;

public interface ClassA {

    default void testOne() {
        System.out.println("test one");
    }

    default void testTwo(){
        System.out.println("test two");
    }

}
