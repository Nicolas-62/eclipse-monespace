package com.testsEntretien.java;

import java.util.Scanner;

public class Temperature {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of temperatures to analyse
        int tMin=0;
        for (int i = 0; i < n; i++) {
            int tCourante = in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
            if(i==0){
                tMin=tCourante;
                continue;
            }
            if(i>0){
                if(Math.abs(tCourante)<Math.abs(tMin)){
                    tMin=tCourante;
                }else if(Math.abs(tCourante)==Math.abs(tMin) && tCourante>0){
                    tMin=tCourante;
                }

            }
        }
    }
}
