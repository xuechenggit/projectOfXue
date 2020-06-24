package com.xue.foundation.designPattern;

public abstract class AbstractPizzaFactory {

    public AbstractPizzaFactory() {
        PizzaAbstract pizzaAbstract = null;
        PizzaAbstract pizza = createPizza(getPizzaType());
        pizza.make();
    }

    public abstract PizzaAbstract createPizza(String type);

    public String getPizzaType(){
        return "2";
    }
}
