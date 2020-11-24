package com.bieitosousa.primenumberscalculator;

import java.util.ArrayList;

public class PrimeCalculator {

    public static boolean esPrimo(int numero){
        int contador = 2;
        boolean primo=true;
        while ((primo) && (contador!=numero)){
            if (numero % contador == 0)
                primo = false;
            contador++;
        }
        return primo;
    }
    public static List<Integer> numberOfPrimo(int number){
        try{
            List<Integer> nPrimoList= new ArrayList<Integer>;
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
                if (esPrimo(index)) {
                    nPrimoList.add(startIndex);
                }
                startIndex++;
            }
            return numberPrimo;
        }catch(Exception e ){
            System.err.println(e.getMessage());
        }
    }
}
