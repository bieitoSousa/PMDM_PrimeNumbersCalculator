package com.bieitosousa.primenumberscalculator;

import java.util.ArrayList;
import java.util.List;

public class PrimeCalculator {
/*
 un número primo es un número natural mayor que 1
 que tiene únicamente dos divisores positivos distintos:
  él mismo y el 1
 */
    private static boolean esPrimo(int numero){
        // si el numero es 1 ó 0 es primo
        if (numero  == 0 || numero == 1){
            return true;
        }
        // comenzamso en el numero posterior al 1 --> 2
        int contador = 2;
        boolean primo=true;
        // si el numero divido entre el rango [2 -> numero -1]  no tiene division entera es primo.
        while ( contador!=numero){
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }
    public static List<Integer> numberOfPrimoList(int number){
        try{
            List<Integer> nPrimoList= new ArrayList<Integer>();
            int startIndex = 0;
            int greater = 1000000;
            int less = 0;
            if (number < less && number > greater){
                throw new Exception(
                        "The number must be greater than"
                                + greater
                                + " and less than" +less );
            }
            while (nPrimoList.size() == number){
                if (esPrimo(startIndex)) {
                    nPrimoList.add(startIndex);
                }
                startIndex++;
            }
            return nPrimoList;
        }catch(Exception e ){
            System.err.println(e.getMessage());
        }
        return null;
    }
    public static int numberOfPrimoInt(int number){
        int res = -1;
        try{

            List<Integer> nPrimoList= new ArrayList<Integer>();
            // entendiendo que el 0 no es un numero natural
            // comenzamos en el 1.
            int startIndex = 1;
            int greater = 1000000;
            int less = 0;
            if (number < less && number > greater){
                throw new Exception(
                        "The number must be greater than"
                                + greater
                                + " and less than" +less );
            }
            while (nPrimoList.size() != number){
                if (esPrimo(startIndex)) {
                    nPrimoList.add(startIndex);
                }
                startIndex++;
            }
            // devolvemos el ultimo numero primo (Posicion comienza en 0 , y size en 1)
            res = nPrimoList.get(nPrimoList.size()-1);
            return res;
        }catch(Exception e ){
            System.err.println(e.getMessage());
        }
        return res;
    }
}
