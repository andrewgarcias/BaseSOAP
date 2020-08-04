package com.training.adl.api.questions;

public class Resultado {


    public static Resta resta() {
        return  new Resta();
    }

    public static Suma suma() {
        return new Suma();
    }


    public static Multiplicacion multiplicacion() { return new Multiplicacion(); }

    public static Division division() { return new Division(); }
}
