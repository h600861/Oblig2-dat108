package Oppgave1;

import java.util.function.BiFunction;

public class oppg1b {
    public static void main(String[] args) {

        BiFunction<Integer , Integer, Integer> summerFunkjson = (x,y) -> x + y;
        BiFunction<Integer, Integer, Integer> StorreEnnFunkjson = (x,y) -> Math.max(x,y);
        BiFunction<Integer, Integer, Integer> AvstandFunkjson = (x,y) -> x - y;


        int sum = beregn(12, 13, summerFunkjson);
        System.out.println("Sum: " + sum);

        int max = beregn(-5,3,StorreEnnFunkjson);
        System.out.println("Største: " + max);

        int avstand = beregn(45,54, AvstandFunkjson);
        System.out.println("Avstanden: " + Math.abs(avstand));
    }

   public static int beregn(int a, int b, BiFunction<Integer , Integer, Integer> bifunk ) {
       return bifunk.apply(a,b);
   }




}