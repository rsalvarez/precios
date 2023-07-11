package com.prices.shared;

public enum Curr {
    USD ("USD"),
    EUR ("EUR"),
    ARG ("ARG");

    private final String value;
    Curr(String curr) { this.value = curr;}
    @Override
    public String toString(){
        return value;
    }
}
