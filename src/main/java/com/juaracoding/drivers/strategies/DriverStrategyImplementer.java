package com.juaracoding.drivers.strategies;

public class DriverStrategyImplementer {
    public static DriverStrategy chooseStrategy (String strategy){
        switch (strategy){
            case "chrome":
                return new Chrome(); //mengarah ke chrome
            case "firefox":
                return new Firefox();
            default:
            return null;
        }
    }
}
