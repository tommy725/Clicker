package com.company;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
//        System.out.printf("Hello world!\n");
//        System.out.printf("Hello world2!\n");
//        Scanner s = new Scanner(System.in);
//        int ile = s.nextInt();
//        Funkcja f = new Funkcja(ile);
//        for(int i=0;i<10;i++){
//            System.out.println(f.Tekst());
//        }
//        String name = JOptionPane.showInputDialog("Name");
//        JOptionPane.showMessageDialog(null,"XD"+name);
//
//        int age = Integer.parseInt(JOptionPane.showInputDialog("Age"));
//        double sqrt = Math.sqrt(age);
//        JOptionPane.showMessageDialog(null,"XD"+sqrt);

        Random generator = new Random();
        int rand = generator.nextInt(6)+1;
        JOptionPane.showMessageDialog(null,rand);
    }

}

