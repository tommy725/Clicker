package com.company;

public class Funkcja {
    private int x;

    public Funkcja(int x) {
        this.x = x;
    }

    public String Tekst() {
        x++;
        return "Funkcja:" + String.valueOf(x);
    }
}
