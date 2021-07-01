package com.company;
import java.util.ArrayList;
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

        random();
        //JOptionPane.showMessageDialog(null,rand);

        ArrayList<Integer> Randoms = new ArrayList<Integer>();
        Randoms.add(random());
        Randoms.add(random());
        Randoms.set(1,12);
        //Randoms.remove(1);
        //Randoms.clear();
//        for(int i=0;i<Randoms.size();i++){
//            JOptionPane.showMessageDialog(null,Randoms.get(i));
//        }
        for(int i : Randoms){
            JOptionPane.showMessageDialog(null,i);
        }
    }

    static int random() {
        Random generator = new Random();
        int rand = generator.nextInt(6)+1;
        return rand;
    }

}

