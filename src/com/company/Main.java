package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.printf("Hello world!\n");
        System.out.printf("Hello world2!\n");
        Scanner s = new Scanner(System.in);
        int ile = s.nextInt();
        Funkcja f = new Funkcja(ile);
        for(int i=0;i<10;i++){
            System.out.println(f.Tekst());
        }
    }

}

