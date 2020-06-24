package com.xue.foundation.designPattern;

import com.xue.foundation.designPattern.domain.ShangHaiPizza1;
import com.xue.foundation.designPattern.domain.ShangHaiPizza2;

public class ShangHaiPizzaFactory extends AbstractPizzaFactory {
    @Override
    public PizzaAbstract createPizza(String type) {
        switch (type) {
            case "1":
                return new ShangHaiPizza1();
            case "2":
                return new ShangHaiPizza2();
        }
        return null;
    }
}
