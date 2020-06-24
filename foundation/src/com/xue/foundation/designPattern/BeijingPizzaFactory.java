package com.xue.foundation.designPattern;

import com.xue.foundation.designPattern.domain.BeijingPizza1;
import com.xue.foundation.designPattern.domain.BeijingPizza2;

public class BeijingPizzaFactory extends AbstractPizzaFactory {
    @Override
    public PizzaAbstract createPizza(String type) {
        switch (type) {
            case "1":
                return new BeijingPizza1();
            case "2":
                return new BeijingPizza2();
        }
        return null;
    }
}
