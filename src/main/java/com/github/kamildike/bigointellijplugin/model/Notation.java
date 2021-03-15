package com.github.kamildike.bigointellijplugin.model;

public enum Notation {
    O1("O(1)"),OLOGN("O(log(n))"),ON("O(n)"),ONLOGN("O(n*log(n))"),ONLOGN2("O((n*log(n))^2)")
    ,ON2("O(n^2)"),O2N("O(2^n)"),ONF("O(n!)");

    private final String label;

    Notation(String s) {
        label = s;
    }

    public static String getLabel(Notation notation){
        for (Notation e : values()) {
            if (e==notation) {
                return e.label;
            }
        }
        return null;
    }
}
